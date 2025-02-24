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
        String whether_newP = (String) session.getAttribute("whether_new");
        String parking_id = request.getParameter("parking_id");
        session.setAttribute("parking_id",parking_id);

//        String car = "888";
        String car = (String) session.getAttribute("car_number");
        long l = System.currentTimeMillis();
        String rand =""+ (((int) (Math.random()*10000)));
        session.setAttribute("plid",rand);
        String i = String.valueOf (l % 10000);

        if(whether_newP.equals("否")){
            try {
                ParkingPlace parkingPlace=ParkingPlaceService.reserveLocation(parking_id,car,Integer.parseInt(rand));
                session.setAttribute("id",parkingPlace.getParkingplace_id());
                session.setAttribute("car_x",parkingPlace.getLocation_x());
                session.setAttribute("car_y",parkingPlace.getLocation_y());
                System.out.println("carx"+parkingPlace.getLocation_x()+"cary"+parkingPlace.getLocation_y()+"|"+parkingPlace.getParkingplace_id());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            try {
                ParkingPlace parkingPlace= ParkingPlaceService.reserveLocationForNewMan(parking_id,car,Integer.parseInt(rand));
                System.out.println("the parking place is "+parkingPlace);
                session.setAttribute("id",parkingPlace.getParkingplace_id());
                session.setAttribute("car_x",parkingPlace.getLocation_x());
                session.setAttribute("car_y",parkingPlace.getLocation_y());
                System.out.println("carx"+parkingPlace.getLocation_x()+"cary"+parkingPlace.getLocation_y()+"|"+parkingPlace.getParkingplace_id());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
