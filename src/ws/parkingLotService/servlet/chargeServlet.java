package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.domain.Car;
import main.com.wswenyue.db.service.AmountService;
import main.com.wswenyue.db.service.CarService;
import main.com.wswenyue.db.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/charge.do")
public class chargeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int amount = 0;
            if(request.getParameter("amount")!=null) amount= Integer.parseInt(String.valueOf(request.getParameter("amount")));



            String errorInfo= "no";
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");//TODO delete
            String session_password = (String) session.getAttribute("password");
            String request_password = (String) request.getParameter("pass");
            if(session_password.equals(request_password)){
                AmountService.charges(username,amount);

                session.setAttribute("balance", UserService.getUserPasswordAndBalance(username).getBalance());
                System.out.println("充值成功");
            }else {
                errorInfo = "密码错误";

            }
            String result = new Gson().toJson(errorInfo);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            /*返回数据*/
            response.getWriter().write(result);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}

