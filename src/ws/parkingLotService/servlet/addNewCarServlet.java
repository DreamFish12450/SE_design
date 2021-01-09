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
@WebServlet("/addNewCar.do")
public class addNewCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            String username = "zky";//TODO delete
//            String username = session.getAttribute("username");
            String car_number = request.getParameter("car_number");
            String car_model = request.getParameter("car_model");
            String car_brand = request.getParameter("car_brand");
            String get_permit = request.getParameter("get_permit");
            Car car = new Car(car_number, car_brand, car_model, get_permit, username);
            System.out.println(car.toString());
            CarService.insertCar(car);
//            List<Car> carList = CarService.getCarByUserName(username);

            /*返回数据*/
//            response.getWriter().write(result);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    /*将实体类转成json*/


}
