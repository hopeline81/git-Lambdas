package taxi.models;

import taxi.Discount;

import java.util.List;
import java.util.Set;

public class Trip {

    private Driver driver;

    private List<Passenger> passengers;

    private int duration;

    private double distance;

    private int discount;

    public Trip(Driver driver, List<Passenger> passengers, int duration, double distance, int discount) {
        this.driver = driver;
        this.passengers = passengers;
        this.duration = duration;
        this.distance = distance;
        this.discount = discount;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "driver=" + driver +
                ", passengers=" + passengers +
                ", duration=" + duration +
                ", distance=" + distance +
                ", discount = " + discount +
                '}';
    }
}
