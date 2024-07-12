package Service;

import Modal.AircraftTypes;
import Modal.Airlines;
import Modal.Airports;
import Modal.FlightPrices;
import Modal.Flights;
import java.time.LocalDate;
import java.time.LocalTime;

public class AllFlights {

    private AircraftTypes aircraftTypes;
    private Airlines airlines;
    private Airports airports;
    private Flights flights;
    private FlightPrices flightPrices;
    
   
    private int flightId;
    private int airlineId;
    private int aircraftTypeId;
    private String flightNumber;
    private String originAirportCode;
    private String destinationAirportCode;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate flightDate;
    private LocalDate arrivalDate;
    private String flightStatus;
    private String gateNumber;
    private double economyPrice;
    private double businessPrice;
    private double firstClassPrice;

    public AllFlights(AircraftTypes aircraftTypes, Airlines airlines, Airports airports, Flights flights, FlightPrices flightPrices) {
        this.aircraftTypes = aircraftTypes != null ? aircraftTypes : new AircraftTypes();
        this.airlines = airlines != null ? airlines : new Airlines();
        this.airports = airports != null ? airports : new Airports();
        this.flights = flights != null ? flights : new Flights();
        this.flightPrices = flightPrices != null ? flightPrices : new FlightPrices();
        this.flightId = flights != null ? flights.getFlightId() : 0;
        this.airlineId = airlines != null ? airlines.getAirlineId() : 0;
        this.aircraftTypeId = aircraftTypes != null ? aircraftTypes.getAircraftTypeId() : 0;
        this.flightNumber = flights != null ? flights.getFlightNumber() : "";
        this.originAirportCode = flights != null ? flights.getOriginAirportCode() : "";
        this.destinationAirportCode = flights != null ? flights.getDestinationAirportCode() : "";
        this.departureTime = flights != null ? flights.getDepartureTime() : LocalTime.MIDNIGHT;
        this.arrivalTime = flights != null ? flights.getArrivalTime() : LocalTime.MIDNIGHT;
        this.flightDate = flights != null ? flights.getFlightDate() : LocalDate.now();
        this.arrivalDate = flights != null ? flights.getArrivalDate() : LocalDate.now();
        this.flightStatus = flights != null ? flights.getFlightStatus() : "";
        this.gateNumber = flights != null ? flights.getGateNumber() : "";
        this.economyPrice = flightPrices != null ? flightPrices.getEconomyPrice() : 0.0;
        this.businessPrice = flightPrices != null ? flightPrices.getBusinessPrice() : 0.0;
        this.firstClassPrice = flightPrices != null ? flightPrices.getFirstClassPrice() : 0.0;
    }

    public AllFlights() {
        this.aircraftTypes = new AircraftTypes();
        this.airlines = new Airlines();
        this.airports = new Airports();
        this.flights = new Flights();
        this.flightPrices = new FlightPrices();
    }

    // Getters and setters
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
        if (flights != null) {
            flights.setFlightId(flightId);
        }
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
        if (airlines != null) {
            airlines.setAirlineId(airlineId);
        }
    }

    public int getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(int aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
        if (aircraftTypes != null) {
            aircraftTypes.setAircraftTypeId(aircraftTypeId);
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
        if (flights != null) {
            flights.setFlightNumber(flightNumber);
        }
    }

    public String getOriginAirportCode() {
        return originAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
        if (flights != null) {
            flights.setOriginAirportCode(originAirportCode);
        }
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
        if (flights != null) {
            flights.setDestinationAirportCode(destinationAirportCode);
        }
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        if (flights != null) {
            flights.setDepartureTime(departureTime);
        }
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        if (flights != null) {
            flights.setArrivalTime(arrivalTime);
        }
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
        if (flights != null) {
            flights.setFlightDate(flightDate);
        }
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
        if (flights != null) {
            flights.setArrivalDate(arrivalDate);
        }
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
        if (flights != null) {
            flights.setFlightStatus(flightStatus);
        }
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
        if (flights != null) {
            flights.setGateNumber(gateNumber);
        }
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
        if (flightPrices != null) {
            flightPrices.setEconomyPrice(economyPrice);
        }
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
        if (flightPrices != null) {
            flightPrices.setBusinessPrice(businessPrice);
        }
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
        if (flightPrices != null) {
            flightPrices.setFirstClassPrice(firstClassPrice);
        }
    }

    public String getFormattedDepartureTime() {
        return flights != null ? flights.getFormattedDepartureTime() : "";
    }

    public String getFormattedArrivalTime() {
        return flights != null ? flights.getFormattedArrivalTime() : "";
    }

    public String getFormattedFlightDate() {
        return flights != null ? flights.getFormattedFlightDate() : "";
    }

    public String getFormattedArrivalDate() {
        return flights != null ? flights.getFormattedArrivalDate() : "";
    }

    public String getAirlineCode() {
        return airlines != null ? airlines.getAirlineCode() : "";
    }

    public void setAirlineCode(String airlineCode) {
        if (airlines != null) {
            airlines.setAirlineCode(airlineCode);
        }
    }

    public String getAirlineName() {
        return airlines != null ? airlines.getAirlineName() : "";
    }

    public void setAirlineName(String airlineName) {
        if (airlines != null) {
            airlines.setAirlineName(airlineName);
        }
    }

    public String getAircraftTypeName() {
        return aircraftTypes != null ? aircraftTypes.getAircraftTypeName() : "";
    }

    public void setAircraftTypeName(String aircraftTypeName) {
        if (aircraftTypes != null) {
            aircraftTypes.setAircraftTypeName(aircraftTypeName);
        }
    }

    public AircraftTypes getAircraftTypes() {
        return aircraftTypes;
    }

    public void setAircraftTypes(AircraftTypes aircraftTypes) {
        this.aircraftTypes = aircraftTypes;
    }

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
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
