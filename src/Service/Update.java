package Service;

import Modal.AircraftTypes;
import Modal.Flights;
import Modal.FlightPrices;
import java.time.LocalDate;
import java.time.LocalTime;

public class Update {

    private int airlineIdUpdate;
    private int aircraftTypeIdUpdate;
    private String flightNumberUpdate;
    private String destinationAirportCodeUpdate;
    private String originAirportCodeUpdate;
    private LocalTime departureTimeUpdate;
    private LocalTime arrivalTimeUpdate;
    private LocalDate flightDateUpdate;
    private LocalDate arrivalDateUpdate;
    private String flightStatusUpdate;
    private String gateNumberUpdate;
    private int flightIdUpdate;

    private double economyPriceUpdate;
    private double businessPriceUpdate;
    private double firstClassPriceUpdate;

    private Flights flights;
    private FlightPrices flightPrices;

    public Update() {

        this.flights = new Flights();
        this.flightPrices = new FlightPrices();
    }

    // Constructor đầy đủ tham số
    public Update(Flights flight, FlightPrices flightPrices) {
        this.flights = flight;
        this.flightPrices = flightPrices;
    }

    // Getters and setters
    public int getFlightIdUpdate() {
        return flightIdUpdate;
    }

    public void setFlightIdUpdate(int flightIdUpdate) {
        this.flightIdUpdate = flightIdUpdate;
        if (flights != null) {
            flights.setFlightId(flightIdUpdate);
        }
    }
    public Update(AllFlights flight) {
        this.airlineIdUpdate = flight.getAirlineId();
        this.aircraftTypeIdUpdate = flight.getAircraftTypeId();
        this.flightNumberUpdate = flight.getFlightNumber();
        this.destinationAirportCodeUpdate = flight.getDestinationAirportCode();
        this.originAirportCodeUpdate = flight.getOriginAirportCode();
        this.departureTimeUpdate = flight.getDepartureTime();
        this.arrivalTimeUpdate = flight.getArrivalTime();
        this.flightDateUpdate = flight.getFlightDate();
        this.arrivalDateUpdate = flight.getArrivalDate();
        this.flightStatusUpdate = flight.getFlightStatus();
        this.gateNumberUpdate = flight.getGateNumber();
        this.flightIdUpdate = flight.getFlightId();
        this.economyPriceUpdate = flight.getEconomyPrice();
        this.businessPriceUpdate = flight.getBusinessPrice();
        this.firstClassPriceUpdate = flight.getFirstClassPrice();
    }
    public int getAirlineIdUpdate() {
        return airlineIdUpdate;
    }

    public void setAirlineIdUpdate(int airlineIdUpdate) {
        this.airlineIdUpdate = airlineIdUpdate;
        if (flights != null) {
            flights.setAirlineId(airlineIdUpdate);
        }
    }

    public int getAircraftTypeIdUpdate() {
        return aircraftTypeIdUpdate;
    }

    public void setAircraftTypeIdUpdate(int aircraftTypeIdUpdate) {
        this.aircraftTypeIdUpdate = aircraftTypeIdUpdate;
        if (flights != null) {
            flights.setAircraftTypeId(aircraftTypeIdUpdate);
        }
    }

    public String getFlightNumberUpdate() {
        return flightNumberUpdate;
    }

    public void setFlightNumberUpdate(String flightNumberUpdate) {
        this.flightNumberUpdate = flightNumberUpdate;
        if (flights != null) {
            flights.setFlightNumber(flightNumberUpdate);
        }
    }

    public String getDestinationAirportCodeUpdate() {
        return destinationAirportCodeUpdate;
    }

    public void setDestinationAirportCodeUpdate(String destinationAirportCodeUpdate) {
        this.destinationAirportCodeUpdate = destinationAirportCodeUpdate;
        if (flights != null) {
            flights.setDestinationAirportCode(destinationAirportCodeUpdate);
        }
    }

    public String getOriginAirportCodeUpdate() {
        return originAirportCodeUpdate;
    }

    public void setOriginAirportCodeUpdate(String originAirportCodeUpdate) {
        this.originAirportCodeUpdate = originAirportCodeUpdate;
        if (flights != null) {
            flights.setOriginAirportCode(originAirportCodeUpdate);
        }
    }

    public LocalTime getDepartureTimeUpdate() {
        return departureTimeUpdate;
    }

    public void setDepartureTimeUpdate(LocalTime departureTimeUpdate) {
        this.departureTimeUpdate = departureTimeUpdate;
        if (flights != null) {
            flights.setDepartureTime(departureTimeUpdate);
        }
    }

    public LocalTime getArrivalTimeUpdate() {
        return arrivalTimeUpdate;
    }

    public void setArrivalTimeUpdate(LocalTime arrivalTimeUpdate) {
        this.arrivalTimeUpdate = arrivalTimeUpdate;
        if (flights != null) {
            flights.setArrivalTime(arrivalTimeUpdate);
        }

    }

    public LocalDate getFlightDateUpdate() {
        return flightDateUpdate;
    }

    public void setFlightDateUpdate(LocalDate flightDateUpdate) {
        this.flightDateUpdate = flightDateUpdate;
        if (flights != null) {
            flights.setFlightDate(flightDateUpdate);
        }
    }

    public LocalDate getArrivalDateUpdate() {
        return arrivalDateUpdate;
    }

    public void setArrivalDateUpdate(LocalDate arrivalDateUpdate) {
        this.arrivalDateUpdate = arrivalDateUpdate;
        if (flights != null) {
            flights.setArrivalDate(arrivalDateUpdate);
        }
        
    }

    public String getFlightStatusUpdate() {
        return flightStatusUpdate;
    }

    public void setFlightStatusUpdate(String flightStatusUpdate) {
        this.flightStatusUpdate = flightStatusUpdate;
        if (flights != null) {
            flights.setFlightStatus(flightStatusUpdate);
        }
    }

    public String getGateNumberUpdate() {
        return gateNumberUpdate;
    }

    public void setGateNumberUpdate(String gateNumberUpdate) {
        this.gateNumberUpdate = gateNumberUpdate;
        if (flights != null) {
            flights.setGateNumber(gateNumberUpdate);
        }
    }

    public double getEconomyPriceUpdate() {
        return economyPriceUpdate;
    }

    public void setEconomyPriceUpdate(double economyPriceUpdate) {
        this.economyPriceUpdate = economyPriceUpdate;
        if (flightPrices != null) {
            flightPrices.setEconomyPrice(economyPriceUpdate);
        }
    }

    public double getBusinessPriceUpdate() {
        return businessPriceUpdate;
    }

    public void setBusinessPriceUpdate(double businessPriceUpdate) {
        this.businessPriceUpdate = businessPriceUpdate;
        if (flightPrices != null) {
            flightPrices.setBusinessPrice(businessPriceUpdate);
        }
    }

    public double getFirstClassPriceUpdate() {
        return firstClassPriceUpdate;
    }

    public void setFirstClassPriceUpdate(double firstClassPriceUpdate) {
        this.firstClassPriceUpdate = firstClassPriceUpdate;
        if (flightPrices != null) {
            flightPrices.setFirstClassPrice(firstClassPriceUpdate);
        }
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public FlightPrices getFlightPrices() {
        return flightPrices;
    }

    public void setFlightPrices(FlightPrices flightPrices) {
        this.flightPrices = flightPrices;
    }

}
