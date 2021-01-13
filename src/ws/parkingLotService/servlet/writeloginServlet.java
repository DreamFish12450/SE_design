package ws.parkingLotService.servlet;

import cn.cy.domain.User;
import com.google.gson.Gson;
import main.com.wswenyue.db.dao.UserDao;
import main.com.wswenyue.db.dao.impl.UserDaoImpl;

import main.com.wswenyue.db.domain.*;
import main.com.wswenyue.db.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login.do")
public class writeloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        UserDaoImpl ud=new UserDaoImpl();
        HttpSession session=request.getSession();
        personnel p1=null;
        UserW u1=null;
        try {
            p1=ud.findad(username,pwd);
            u1=ud.find(username,pwd);
            System.out.println(u1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(u1!=null)
        {
            Amount amount= null;
            try {
                amount = AmountService.getAmount(u1.getUsername());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            session.setAttribute("username",u1.getUsername());
            session.setAttribute("password",u1.getPassword());
            session.setAttribute("name",u1.getName());
            session.setAttribute("age",u1.getAge());
            session.setAttribute("sex",u1.getSex());
            session.setAttribute("ID_number",u1.getID_number());
            session.setAttribute("balance",u1.getBalance());
            session.setAttribute("phone_number",u1.getPhone_number());
            if(amount!=null){
                session.setAttribute("VIP_level",amount.getVip_level());
                session.setAttribute("totalMoney",amount.getTotal_amount());
            }
            List<Car> carList = CarService.getCarByUserName(username);
            if(carList!=null){
                session.setAttribute("carList",carList);
            }
//                session.setAttribute("VIP_level",u1.getVIP_level());
           // Amount amount=AmountService.getAmount(u1.getUsername());
            //session.setAttribute("VIP_level",amount.getVip_level());
            //session.setAttribute("totalMoney",amount.getTotal_amount());
//            List<Car> carList = CarService.getCarByUserName(username);
//            session.setAttribute("carList",carList);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else if(p1!=null){
            System.out.println("管理员登录！");
            request.getRequestDispatcher("/showfee.jsp").forward(request, response);
//            request.getRequestDispatcher(request.getContextPath()+"/showfee.jsp").forward(request, response);
        }
        else {
            System.out.println("err");
            session.setAttribute("error2","err");
           // request.setAttribute("error2","密码或者账号错误");
          //  request.getRequestDispatcher("/inite.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/inite.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}