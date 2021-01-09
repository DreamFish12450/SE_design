package main.com.wswenyue.db.domain;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class ParkingFee {
    private String username;
    private String car_number;
    private Int parking_time;
    private float fee;
    private string parkplace_ID;

    public Price(String username, String car_number, Int parking_time, float fee, string parkplace_ID) {
        this.username = username;
        this.car_number = car_number;
        this.parking_time = parking_time;
        this.fee = fee;
        this.parkplace_ID = parkplace_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public Int getParking_time() {
        return parking_time;
    }

    public void setParking_time(Int parking_time) {
        this.parking_time = parking_time;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public string getParkplace_ID() {
        return parkplace_ID;
    }

    public void setParkplace_ID(string parkplace_ID) {
        this.parkplace_ID = parkplace_ID;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ParkingFee{" +
                "username='" + username + '\'' +
                ", car_number='" + car_number + '\'' +
                ", parking_time=" + parking_time +
                ", fee=" + fee +
                ", parkplace_ID=" + parkplace_ID +
                '}';
    }
}
