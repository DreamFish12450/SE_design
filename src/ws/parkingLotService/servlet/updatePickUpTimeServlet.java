package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.dao.impl.ParkingFeeDaoImpl;
import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.service.UpdateParkingTime;
import main.com.wswenyue.db.service.UpdatePickUpTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updatePickUpTime.do")
public class updatePickUpTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //String parkingId,int parking's_id,String username,String car_number
            HttpSession session = request.getSession();
            String parkingId =  request.getParameter("parking_id").trim();
            System.out.println("here is a test"+request.getParameter("parking_id"));
            String parkingplace_id =request.getParameter("parkingplace_id").trim();
            String username = request.getParameter("username").trim();
            String car_number = request.getParameter("car_number").trim();
            System.out.println("parkingId:"+parkingId+"parkingplace_id:"+parkingplace_id+"username"+username+"car_number"+car_number);
            UpdatePickUpTime.UpdatePickUpTime(parkingId,Integer.parseInt(parkingplace_id),username,car_number);

            //扣费 如果账户余额充足则直接扣 写入数据库； 如果账户余额不充足则转向充值页面
            ParkingFeeDaoImpl parkingFeeDao = new ParkingFeeDaoImpl();
            ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();
            ParkingPlace parkingPlace = placeDao.getParkingPlace(parkingId,Integer.parseInt(parkingplace_id));
            System.out.println("开始时间："+parkingPlace.getEnd_time().getTime()+" "+"结束时间："+parkingPlace.getStart_time().getTime());
            long diff = parkingPlace.getEnd_time().getTime() - parkingPlace.getStart_time().getTime();
            long hour = diff/1000/3600;
            hour = (int) (hour+0.5);
            float money = hour*5;
            UserW userW = new UserW();
            userW = parkingFeeDao.getUser(username);
            int balance = userW.getBalance();
            if(money <= balance){
                parkingFeeDao.updateBalance(username, (int) (balance-money));
                String msg = "finish";
                String result = new Gson().toJson(msg);
                response.getWriter().write(result);
//                session.setAttribute("msg", "支付成功！");
//                request.getRequestDispatcher("showFinished.jsp").forward(request, response);
            }
            else{
                String msg = "unfinished";
                String result = new Gson().toJson(msg);
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(result);
                /*返回数据*/
                //request.setAttribute("msg", "删除成功！");
//                   request.getRequestDispatcher("charge.jsp").forward(request, response);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}

