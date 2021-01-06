package main.com.wswenyue.db.domain;

public class Parking {
    double lat;
    double lng;
    String parkingName;
    String parkingId;
    int charges;
    int maxSize;
    int spare;

    public Parking() {

    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public Parking(String parkingName, String parkingId, int charges, double lng, double lat, int maxSize, int spare) {
        this.lat = lat;
        this.lng = lng;
        this.parkingId = parkingId;
        this.parkingName = parkingName;
        this.charges = charges;
        this.maxSize = maxSize;
        this.spare = spare;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSpare() {
        return spare;
    }

    public void setSpare(int spare) {
        this.spare = spare;
    }

    public Parking(String parkingName, String parkingId, int charges, double lng, double lat) {
        this.lat = lat;
        this.lng = lng;
        this.parkingName = parkingName;
        this.parkingId = parkingId;
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", parkingName='" + parkingName + '\'' +
                ", parkingId=" + parkingId +
                ", charges=" + charges +
                ", maxSize=" + maxSize +
                ", spare=" + spare +
                '}';
    }
}
