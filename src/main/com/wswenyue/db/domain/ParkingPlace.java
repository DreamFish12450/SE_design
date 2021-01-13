package main.com.wswenyue.db.domain;

import java.util.Date;

public class ParkingPlace {
    int parkingplace_id;
    String car_number;
    Date start_time;
    Date end_time;
    String parking_id;
    int status;
    int location_x;
    int location_y;
    public ParkingPlace(){}
    public ParkingPlace(int location_x,
                        int location_y) {
        this.location_x = location_x;
        this.location_y = location_y;
    }
    public ParkingPlace(int location_x,
                        int location_y,int parkingplace_id) {
        this.location_x = location_x;
        this.location_y = location_y;
        this.parkingplace_id = parkingplace_id;
    }

    public ParkingPlace(int parkingplace_id, String car_number, Date start_time, Date end_time, String parking_id, int status, int location_y, int location_x) {
        this.parkingplace_id = parkingplace_id;
        this.car_number = car_number;
        this.start_time = start_time;
        this.end_time = end_time;
        this.parking_id = parking_id;
        this.status = status;
        this.location_x = location_x;
        this.location_y = location_y;
    }

    public ParkingPlace(String car_number, Date start_time, Date end_time, String parking_id, int status, int location_x, int location_y) {
        this.car_number = car_number;
        this.start_time = start_time;
        this.end_time = end_time;
        this.parking_id = parking_id;
        this.status = status;
        this.location_x = location_x;
        this.location_y = location_y;
    }


    @Override
    public String toString() {
        return "ParkingPlace{" +
                "car_number='" + car_number + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", parking_id='" + parking_id + '\'' +
                ", status=" + status +
                ", location_x=" + location_x +
                ", location_y=" + location_y +
                '}';
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getParking_id() {
        return parking_id;
    }

    public void setParking_id(String parking_id) {
        this.parking_id = parking_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLocation_x() {
        return location_x;
    }

    public int getParkingplace_id() {
        return parkingplace_id;
    }

    public void setParkingplace_id(int parkingplace_id) {
        this.parkingplace_id = parkingplace_id;
    }

    public void setLocation_x(int location_x) {
        this.location_x = location_x;
    }

    public int getLocation_y() {
        return location_y;
    }

    public void setLocation_y(int location_y) {
        this.location_y = location_y;
    }
}
