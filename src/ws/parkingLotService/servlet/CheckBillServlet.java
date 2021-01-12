package ws.parkingLotService.servlet;

import main.com.wswenyue.db.domain.ParkingFee;
import main.com.wswenyue.db.service.CheckBill;
import main.com.wswenyue.db.service.UpdateParkingTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/CheckBill.do")
public class CheckBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //String username, String car_number
            HttpSession session = request.getSession();
            String username = (String) request.getParameter("username");
            String car_number =(String) request.getParameter("car_number");
            List<ParkingFee> listParkingFee;
            listParkingFee = CheckBill.checkBill(username,car_number);
            session.setAttribute("list",listParkingFee);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            /*返回数据*/
            //request.setAttribute("msg", "删除成功！");
            //request.getRequestDispatcher("showMessage.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}

