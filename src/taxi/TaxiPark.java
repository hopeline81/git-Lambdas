package taxi;

import taxi.models.Driver;
import taxi.models.Passenger;
import taxi.models.Range;
import taxi.models.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxiPark {
    private List<Driver> allDrivers;
    private List<Passenger> allPassenger;
    private List<Trip> tripList;

    public TaxiPark(List<Driver> allDrivers, List<Passenger> allPassenger, List<Trip> tripList) {
        this.allDrivers = allDrivers;
        this.allPassenger = allPassenger;
        this.tripList = tripList;
    }

    public List<Driver> findFakeDrivers() {
        List<Driver> allDriversThatHaveHadTrips = tripList.stream()
                .map(Trip::getDriver)
                .distinct()
                .collect(Collectors.toList());
        return allDrivers
                .stream()
                .filter(driver -> !allDriversThatHaveHadTrips.contains(driver))
                .collect(Collectors.toList());
    }

    public List<Passenger> allPassengerWhoCompletedGivenNumberOfTrips(int minTrips) {
        if (minTrips == 0) {
            return allPassenger;
        }

        Map<String, List<Passenger>> passengerMap = tripList.stream()
                .flatMap(trip -> trip.getPassengers()
                        .parallelStream())
                .collect(Collectors.groupingBy(Passenger::getName));
        return passengerMap.values()
                .stream()
                .filter(passengers -> passengers.size() >= minTrips)
                .map(passengers -> passengers.get(0))
                .collect(Collectors.toList());
    }

    public List<Passenger> findFrequentPassengers(Driver driver) {
        Map<Driver, List<Passenger>> driverPassengerMap =
                tripList.stream()
                        .collect(Collectors.toMap(Trip::getDriver, Trip::getPassengers,
                                (passenger1, passenger2) -> {
                                    System.out.println("Fount duplicate driver");
                                    return Stream.concat(passenger1.stream(),
                                            passenger2.stream())
                                            .collect(Collectors.toList());
                                }));

        List<Passenger> passengers = driverPassengerMap.get(driver);

        Map<String, List<Passenger>> namePassengerMap = passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getName));

        List<Passenger> faithfulPassenger = new ArrayList<>();

        for (Map.Entry<String, List<Passenger>> entry : namePassengerMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                faithfulPassenger.add(entry.getValue().get(0));
            }
        }
        return faithfulPassenger;
    }

    public Range findTheMostFrequentTripDurationPeriod() {
        Map<Range, List<Passenger>> rangePassengerMap =
                tripList.stream()
                        .collect(Collectors.toMap(trip -> getMinutesRange(trip.getDuration())
                                , Trip::getPassengers, (passenger1, passenger2) -> {
                                    System.out.println("Fount duplicate driver");
                                    return Stream.concat(passenger1.stream(),
                                            passenger2.stream())
                                            .collect(Collectors.toList());
                                }));
        Range range = null;
        int maxNumberOfPassenger = 0;

        for (Map.Entry<Range, List<Passenger>> entry : rangePassengerMap.entrySet()) {
            if (entry.getValue().size() > maxNumberOfPassenger) {
                maxNumberOfPassenger = entry.getValue().size();
                range = entry.getKey();
            }
        }
        return range;
    }

    public Range getMinutesRange(int duration) {
        int rangeLowerBorder = (duration / 10) * 10;
        return new Range(rangeLowerBorder, rangeLowerBorder + 9);

    }

    public List<Passenger> findPassengersWithDiscount (int discount) {

        Map<String, List<Passenger>> passengerMap = tripList.stream()
                .flatMap(trip -> trip.getPassengers()
                        .parallelStream())
                .collect(Collectors.groupingBy(Passenger::getName));
        return passengerMap.values()
                .stream()
                .filter(passengers -> passengers.size() == discount)
                .map(passengers -> passengers.get(0))
                .collect(Collectors.toList());
    }


}
