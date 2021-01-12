package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.service.AmountService;
import main.com.wswenyue.db.service.CarService;
import main.com.wswenyue.db.service.UpdateParkingTime;
import main.com.wswenyue.db.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateParkingTime.do")
public class updateParkingTimeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //int parkingId, int location_x , int location_y
            HttpSession session = request.getSession();
            String parkingId = request.getParameter("parking_id").trim();
            String location_x = request.getParameter("car_x").trim();
            String location_y = request.getParameter("car_y").trim();
            System.out.println("parkingId:"+parkingId+"location_x:"+location_x+"location_y"+location_y);
//            System.out.println(parkingId);
            UpdateParkingTime.updateParkingTime(Integer.parseInt(parkingId),Integer.parseInt(location_x),Integer.parseInt(location_y));
            //UpdateParkingTime.updateParkingTime(1,1,1);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            /*返回数据*/
            String result = new Gson().toJson(parkingId);
            response.getWriter().write(result);
            request.setAttribute("msg", "停车成功！");

            request.getRequestDispatcher("showMessage.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}

