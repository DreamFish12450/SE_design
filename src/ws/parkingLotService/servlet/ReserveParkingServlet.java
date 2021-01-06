package ws.parkingLotService.servlet;

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
import java.sql.SQLException;
import java.text.ParseException;
@WebServlet("/reserve.do")
public class ReserveParkingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean whether_newP = false;
//            whether_newP = session.getAttribute(whether_newP)
        String parking_id = request.getParameter("parking_id");
        System.out.println("the parking id is"+parking_id);
        String car = "888";
//        car = session.getAttribute("carNumber");
        if(!whether_newP){
            try {
                ParkingPlace parkingPlace=ParkingPlaceService.reserveLocation(parking_id,car);
                session.setAttribute("car_x",parkingPlace.getLocation_x());
                session.setAttribute("car_y",parkingPlace.getLocation_y());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            try {
                ParkingPlace parkingPlace= ParkingPlaceService.reserveLocationForNewMan(parking_id,car);
                session.setAttribute("car_x",parkingPlace.getLocation_x());
                session.setAttribute("car_y",parkingPlace.getLocation_y());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
