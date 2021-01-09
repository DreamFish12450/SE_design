package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.domain.Car;
import main.com.wswenyue.db.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@WebServlet("/chooseCar.do")
public class chooseCar  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String car_number = request.getParameter("car_number");
            String whether_new = request.getParameter("whether_new");
//            System.out.println();
            System.out.println("the car is"+car_number);
            System.out.println("是否是新手的狀態"+whether_new);
            session.setAttribute("car",car_number);
            session.setAttribute("whether_new",whether_new);
            System.out.println(car_number);
//            request.getRequestDispatcher("/guide.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}