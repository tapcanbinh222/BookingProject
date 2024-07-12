package Service;

import Modal.AircraftTypes;
import Modal.Flights;
import Modal.FlightPrices;
import java.time.LocalDate;
import java.time.LocalTime;

public class Add {

    private int airlineIdAdd;
    private int aircraftTypeIdAdd;
    private String flightNumberAdd;
    private String destinationAirportCodeAdd;
    private String originAirportCodeAdd;
    private LocalTime departureTimeAdd;
    private LocalTime arrivalTimeAdd;
    private LocalDate flightDateAdd;
    private LocalDate arrivalDateAdd;
    private String flightStatusAdd;
    private String gateNumberAdd;

    private double economyPriceAdd;
    private double businessPriceAdd;
    private double firstClassPriceAdd;

    private Flights flights;
    private FlightPrices flightPrices;

    public Add() {

        this.flights = new Flights();
        this.flightPrices = new FlightPrices();
    }

    // Constructor đầy đủ tham số
    public Add(Flights flight, FlightPrices flightPrices) {
        this.flights = flight;
        this.flightPrices = flightPrices;
    }

    // Getters and setters
    public int getAirlineIdAdd() {
        return airlineIdAdd;
    }

    public void setAirlineIdAdd(int airlineIdAdd) {
        this.airlineIdAdd = airlineIdAdd;
        if (flights != null) {
            flights.setAirlineId(airlineIdAdd);
        }
    }

    public int getAircraftTypeIdAdd() {
        return aircraftTypeIdAdd;
    }

    public void setAircraftTypeIdAdd(int aircraftTypeIdAdd) {
        this.aircraftTypeIdAdd = aircraftTypeIdAdd;
        if (flights != null) {
            flights.setAircraftTypeId(aircraftTypeIdAdd);
        }
    }

    public String getFlightNumberAdd() {
        return flightNumberAdd;
    }

    public void setFlightNumberAdd(String flightNumberAdd) {
        this.flightNumberAdd = flightNumberAdd;
        if (flights != null) {
            flights.setFlightNumber(flightNumberAdd);
        }
    }

    public String getDestinationAirportCodeAdd() {
        return destinationAirportCodeAdd;
    }

    public void setDestinationAirportCodeAdd(String destinationAirportCodeAdd) {
        this.destinationAirportCodeAdd = destinationAirportCodeAdd;
        if (flights != null) {
            flights.setDestinationAirportCode(destinationAirportCodeAdd);
        }
    }

    public String getOriginAirportCodeAdd() {
        return originAirportCodeAdd;
    }

    public void setOriginAirportCodeAdd(String originAirportCodeAdd) {
        this.originAirportCodeAdd = originAirportCodeAdd;
        if (flights != null) {
            flights.setOriginAirportCode(originAirportCodeAdd);
        }
    }

    public LocalTime getDepartureTimeAdd() {
        return departureTimeAdd;
    }

    public void setDepartureTimeAdd(LocalTime departureTimeAdd) {
        this.departureTimeAdd = departureTimeAdd;
        if (flights != null) {
            flights.setDepartureTime(departureTimeAdd);
        }
    }

    public LocalTime getArrivalTimeAdd() {
        return arrivalTimeAdd;
    }

    public void setArrivalTimeAdd(LocalTime arrivalTimeAdd) {
        this.arrivalTimeAdd = arrivalTimeAdd;
        if (flights != null) {
            flights.setArrivalTime(arrivalTimeAdd);
        }

    }

    public LocalDate getFlightDateAdd() {
        return flightDateAdd;
    }

    public void setFlightDateAdd(LocalDate flightDateAdd) {
        this.flightDateAdd = flightDateAdd;
        if (flights != null) {
            flights.setFlightDate(flightDateAdd);
        }
    }

    public LocalDate getArrivalDateAdd() {
        return arrivalDateAdd;
    }

    public void setArrivalDateAdd(LocalDate arrivalDateAdd) {
        this.arrivalDateAdd = arrivalDateAdd;
        if (flights != null) {
            flights.setArrivalDate(arrivalDateAdd);
        }
        
    }

    public String getFlightStatusAdd() {
        return flightStatusAdd;
    }

    public void setFlightStatusAdd(String flightStatusAdd) {
        this.flightStatusAdd = flightStatusAdd;
        if (flights != null) {
            flights.setFlightStatus(flightStatusAdd);
        }
    }

    public String getGateNumberAdd() {
        return gateNumberAdd;
    }

    public void setGateNumber(String gateNumberAdd) {
        this.gateNumberAdd = gateNumberAdd;
        if (flights != null) {
            flights.setGateNumber(gateNumberAdd);
        }
    }

    public double getEconomyPriceAdd() {
        return economyPriceAdd;
    }

    public void setEconomyPriceAdd(double economyPriceAdd) {
        this.economyPriceAdd = economyPriceAdd;
        if (flightPrices != null) {
            flightPrices.setEconomyPrice(economyPriceAdd);
        }
    }

    public double getBusinessPriceAdd() {
        return businessPriceAdd;
    }

    public void setBusinessPriceAdd(double businessPriceAdd) {
        this.businessPriceAdd = businessPriceAdd;
        if (flightPrices != null) {
            flightPrices.setBusinessPrice(businessPriceAdd);
        }
    }

    public double getFirstClassPriceAdd() {
        return firstClassPriceAdd;
    }

    public void setFirstClassPriceAdd(double firstClassPriceAdd) {
        this.firstClassPriceAdd = firstClassPriceAdd;
        if (flightPrices != null) {
            flightPrices.setFirstClassPrice(firstClassPriceAdd);
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
