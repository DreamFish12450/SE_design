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
            session.setAttribute("car_number",car_number);
            String whether_new_p = request.getParameter("whether_new");
            System.out.println(whether_new_p);
            session.setAttribute("whether_new",whether_new_p);
            System.out.println(car_number);
            request.getRequestDispatcher("/guide.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }



        /*将实体类转成json*/


    }
}