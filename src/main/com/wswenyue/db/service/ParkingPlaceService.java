package main.com.wswenyue.db.service;

import main.com.wswenyue.db.dao.impl.ParkingPlaceDaoImpl;
import main.com.wswenyue.db.domain.ParkingPlace;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParkingPlaceService {
    static ParkingPlaceDaoImpl placeDao = new ParkingPlaceDaoImpl();

    public static List<ParkingPlace> getFreeParking(String parkingId) {

        List<ParkingPlace> list = placeDao.getSpareParkings(parkingId);
        int x = 1;
        int y = 1;
        int array[][] = new int[6][7];
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                array[i][j] = 0;
            }
        }
        List<ParkingPlace> busyParks = new ArrayList<>();
        List<ParkingPlace> freeParks = new ArrayList<>();
        for (ParkingPlace l : list) {
            if (l.getStart_time() != null && l.getEnd_time() == null) {
//                busyParks.add(new ParkingPlace());
                array[l.getLocation_x()][l.getLocation_y()] = 1;
            }
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 6; j++) {
                if (array[i][j] != 1) {
                    freeParks.add(new ParkingPlace(i, j));
//                    System.out.println("the x is " + i + "the y is" + j);
                }
            }
        }
        return freeParks;
    }

    public static Integer getFreeParkSize(String parkingId) {
        return getFreeParking(parkingId).size();
    }

    public static ParkingPlace reserveLocation(String parkId, String carNumber,int i) throws SQLException, ParseException {
        List<ParkingPlace> freeList = getFreeParking(parkId);
        placeDao.reservePlace(carNumber, parkId, freeList.get(1).getLocation_x(), freeList.get(1).getLocation_y(), i);
        return new ParkingPlace(freeList.get(1).getLocation_x(), freeList.get(1).getLocation_y(),i);
    }

    public static ParkingPlace reserveLocationForNewMan(String parkId, String carNumber,int i1) throws SQLException, ParseException {
        List<ParkingPlace> freeList = getFreeParking(parkId);
        for (int i = 1; i <= freeList.size(); i++) {
            ParkingPlace tempPlace = freeList.get(i);
//            System.out.println(tempPlace.toString());
            if (tempPlace.getLocation_x() != 1 && tempPlace.getLocation_x() != 5 && tempPlace.getLocation_y() != 1 && tempPlace.getLocation_y() != 6) {
                if (i > 1 && i < freeList.size()) {
                    int nextLocationX = freeList.get(i + 1).getLocation_x();
                    int nextLocationY = freeList.get(i + 1).getLocation_y();
                    int prevLocationX = freeList.get(i - 1).getLocation_x();
                    int prevLocationY = freeList.get(i - 1).getLocation_y();
                    int nowX = freeList.get(i).getLocation_x();
                    int nowY = freeList.get(i).getLocation_y();
                    System.out.println("the X is " + nowX + "the Y is" + nowY);
                    if (nowX == prevLocationX && nowX == nextLocationX
                            && nowY == prevLocationY + 1 && nowY == nextLocationY - 1) {
                        placeDao.reservePlace(carNumber, parkId, freeList.get(i).getLocation_x(), freeList.get(i).getLocation_y(),i1);
                        System.out.println("the reserveX is " + nowX + "the reserveY is" + nowY);
                        return new ParkingPlace(nowX,nowY,i1);
//                        break;
                    }
                }

            }
        }
        return null;
    }
}
