package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.domain.Parking;
import main.com.wswenyue.db.domain.UserW;
import main.com.wswenyue.db.service.ParkingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/init.do")
public class initServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
//            List<Parking> parkingList = ParkingService.getAll();
            HttpSession session = request.getSession();
            //TODO 当管理员引入的时候需要修改
            String userName = (String) session.getAttribute("username");
            Integer balance = (Integer) session.getAttribute("balance");
            UserW u= new UserW();
            u.setUsername(userName);
            u.setBalance(balance);
            String result = new Gson().toJson(u);
            System.out.println("返回的结果：" + result);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            /*返回数据*/
            response.getWriter().write(result);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }
}
