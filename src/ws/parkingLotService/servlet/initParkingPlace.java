package ws.parkingLotService.servlet;

import com.google.gson.Gson;
import main.com.wswenyue.db.domain.ParkingPlace;
import main.com.wswenyue.db.service.BasicUserService;
import main.com.wswenyue.db.service.ParkingPlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/initParkingPlace.do")
public class initParkingPlace extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
        HttpSession session = request.getSession();
        String parking_id = (String) session.getAttribute("parking_id");
//        String parking_id = "1";
        List<ParkingPlace> parkingPlaceList=ParkingPlaceService.getFreeParking(parking_id);
        String result = new Gson().toJson(parkingPlaceList);
//        int car_x = (int) session.getAttribute("car_x");
//        int car_y = (int) session.getAttribute("car_y");
        int car_x  = 1;
        int car_y = 1;
        ParkingPlace p = new ParkingPlace(car_x,car_y);
        String reserve = new Gson().toJson(p);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(result);
//        response.getWriter().write(reserve);

    }
}
