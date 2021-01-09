package main.com.wswenyue.db.domain;

public class Car {
    String car_number;
    String car_brand;
    String car_model;

    @Override
    public String toString() {
        return "Car{" +
                "car_number='" + car_number + '\'' +
                ", car_brand='" + car_brand + '\'' +
                ", car_model='" + car_model + '\'' +
                ", traffic_permit='" + traffic_permit + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    String traffic_permit;
    String username;

    public Car(String car_number, String car_brand, String car_model, String traffic_permit, String username) {
        this.car_number = car_number;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.traffic_permit = traffic_permit;
        this.username = username;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getTraffic_permit() {
        return traffic_permit;
    }

    public void setTraffic_permit(String traffic_permit) {
        this.traffic_permit = traffic_permit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
