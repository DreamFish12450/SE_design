package ws.parkingLotService.servlet;

import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.Amount;
import main.com.wswenyue.db.domain.Car;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.service.AmountService;
import main.com.wswenyue.db.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


public class faceloginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name").trim();
        System.out.println(name);
        String type = "-1";
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
//            out.println("Success---llll");
            out.append(type);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        request.setCharacterEncoding("utf-8");
        //String userId=request.getParameter("userId");
        UserDaoImpl d1=new UserDaoImpl();
        try {
           UserW w1=d1.findUserByName(name);
            HttpSession session=request.getSession();
            session.setAttribute("username",w1.getUsername());
            session.setAttribute("password",w1.getPassword());
            session.setAttribute("name",w1.getName());
            session.setAttribute("age",w1.getAge());
            session.setAttribute("sex",w1.getSex());
            session.setAttribute("ID_number",w1.getID_number());
            session.setAttribute("phone_number",w1.getPhone_number());
//            session.setAttribute("balance",w1.getBalance());
            session.setAttribute("balance",w1.getBalance());
            Amount amount= null;
            try {
                amount = AmountService.getAmount(w1.getUsername());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(amount!=null){
                session.setAttribute("VIP_level",amount.getVip_level());
                session.setAttribute("totalMoney",amount.getTotal_amount());
            }
            List<Car> carList = CarService.getCarByUserName(name);
            if(carList!=null){
                session.setAttribute("carList",carList);
            }
//            System.out.println("3up");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
