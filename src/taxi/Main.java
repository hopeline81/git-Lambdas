package taxi;

import taxi.models.Driver;
import taxi.models.Passenger;
import taxi.models.Range;
import taxi.models.Trip;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> allDrivers = new ArrayList<>();
        List<Passenger> allPassengers = new ArrayList<>();
        List<Trip> allTrips = new ArrayList<>();

        Driver driver1 = new Driver("driver1");
        Driver driver2 = new Driver("driver2");

        allDrivers.add(driver1);
        allDrivers.add(driver2);

        List<Passenger> passengersList1 = new ArrayList<>();
        Passenger passenger1 = new Passenger("passenger1");
        Passenger passenger2 = new Passenger("passenger2");
        Passenger passenger3 = new Passenger("passenger3");

        passengersList1.add(passenger1);
        passengersList1.add(passenger2);

        List<Passenger> passengersList2 = new ArrayList<>();
        passengersList2.add(passenger2);
        passengersList2.add(passenger3);

        allPassengers.add(passenger1);
        allPassengers.add(passenger2);
        allPassengers.add(passenger3);

        Trip trip1 = new Trip(driver1, passengersList1, 10,3.6, 0);
        Trip trip2 = new Trip(driver2, passengersList2, 15, 5.0, 10);
        Trip trip3 = new Trip(driver2,passengersList2, 20,8.2, 10);

        allTrips.add(trip1);
        allTrips.add(trip2);
        allTrips.add(trip3);

        TaxiPark taxiPark = new TaxiPark(allDrivers, allPassengers, allTrips);

//        List<Passenger> passengers = taxiPark.allPassengerWhoCompletedGivenNumberOfTrips(2);
//        for (Passenger passenger: passengers) {
//            System.out.println(passenger.getName());
//        }

//        List<Passenger> faithfulPassenger = taxiPark.findFrequentPassengers(driver1);
//        for (Passenger passenger: faithfulPassenger) {
//            System.out.println(passenger.getName());
//        }

//        Range range = taxiPark.findTheMostFrequentTripDurationPeriod();
//        System.out.println(range.toString());
//
        List<Passenger> passengersWithDiscount = taxiPark.findPassengersWithDiscount(10);
        for (Passenger passenger: passengersWithDiscount) {
            System.out.println(passenger.getName());
        }

    }
}
