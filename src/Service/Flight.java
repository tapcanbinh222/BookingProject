/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modal.AircraftTypes;
import Modal.Airlines;
import Modal.Airports;
import Modal.Booking;
import Modal.FlightPrices;
import Modal.Flights;
import Modal.Passenger;
import Modal.Payments;
import Modal.Seats;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author trums
 */
public class Flight {

   
    //AircraftTypes
    private int aircraftTypeId;
    private String aircraftTypeName;
    private int economySeats;
    private int firstClassSeats;
    private int businessSeats;
    //Airlines
    private int airlineId;
    private String airlineName;
    private String airlineCode;
    //Airports
    private String airportCode;
    private String airportName;
    private String city;
    private String country;
    //Booking
    private int bookingId;
    private String email;
    private String phone;
    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String bookingStatus;
    private int flightId;
    //FlightPrice
    private int flightPriceId;
    private double economyPrice;
    private double businessPrice;
    private double firstClassPrice;
    //Flights
    private String flightNumber;
    private String originAirportCode;
    private String destinationAirportCode;
    private String flightStatus;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate flightDate;
    private LocalDate arrivalDate;
    private String gateNumber;
    //Passenger
    private int passengerId;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String gender;
    private String passportId;
    private String nationality;
    //Payments
    private int paymentId;
    private LocalDate paymentDate;
    private String paymentMethod;
    private double amount;
    private String paymentStatus;
    //Seats
    private int seatId;
    private String seatNumber;
    private boolean isAvailable;

    private AircraftTypes aircraftTypes;
    private Airlines airlines;
    private Airports airports;
    private Booking booking;
    private FlightPrices flightPrices;
    private Flights flights;
    private Passenger passenger;
    private Payments payments;
    private Seats seats;
    
     public Flight(){
     this.aircraftTypes = new AircraftTypes();
     this.airlines = new Airlines();
     this.airports = new Airports();
     this. booking = new Booking();
     this.flightPrices = new FlightPrices();
     this.flights = new Flights();
     this.passenger = new Passenger();
     this.payments = new Payments();
     this.seats = new Seats();
    }

    public Flight(int aircraftTypeId, String aircraftTypeName, int economySeats, int firstClassSeats, int businessSeats, int airlineId, String airlineName, String airlineCode, String airportCode, String airportName, String city, String country, int bookingId, String email, String phone, LocalDateTime bookingDateTime, double totalPrice, String bookingStatus, int flightId, int flightPriceId, double economyPrice, double businessPrice, double firstClassPrice, String flightNumber, String originAirportCode, String destinationAirportCode, String flightStatus, LocalTime departureTime, LocalTime arrivalTime, LocalDate flightDate, LocalDate arrivalDate, String gateNumber, int passengerId, String firstName, String lastName, LocalDate DOB, String gender, String passportId, String nationality, int paymentId, LocalDate paymentDate, String paymentMethod, double amount, String paymentStatus, int seatId, int aircraftTypeID, String seatNumber, boolean isAvailable, AircraftTypes aircraftTypes, Airlines airlines, Airports airports, Booking booking, FlightPrices flightPrices, Flights flights, Passenger passenger, Payments payments, Seats seats) {
        this.aircraftTypeId = aircraftTypeId;
        this.aircraftTypeName = aircraftTypeName;
        this.economySeats = economySeats;
        this.firstClassSeats = firstClassSeats;
        this.businessSeats = businessSeats;
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.bookingId = bookingId;
        this.email = email;
        this.phone = phone;
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
        this.flightId = flightId;
        this.flightPriceId = flightPriceId;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
        this.flightNumber = flightNumber;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.flightStatus = flightStatus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDate = flightDate;
        this.arrivalDate = arrivalDate;
        this.gateNumber = gateNumber;
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.passportId = passportId;
        this.nationality = nationality;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.aircraftTypes = aircraftTypes;
        this.airlines = airlines;
        this.airports = airports;
        this.booking = booking;
        this.flightPrices = flightPrices;
        this.flights = flights;
        this.passenger = passenger;
        this.payments = payments;
        this.seats = seats;
    }

    
    
    // Getters and Setters for AircraftTypes
    public int getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(int aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
        if (aircraftTypes != null) {
            aircraftTypes.setAircraftTypeId(aircraftTypeId);
        }
    }

    public String getAircraftTypeName() {
        return aircraftTypeName;
    }

    public void setAircraftTypeName(String aircraftTypeName) {
        this.aircraftTypeName = aircraftTypeName;
        if (aircraftTypes != null) {
            aircraftTypes.setAircraftTypeName(aircraftTypeName);
        }
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
        if (aircraftTypes != null) {
            aircraftTypes.setEconomySeats(economySeats);
        }
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(int firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
        if (aircraftTypes != null) {
            aircraftTypes.setFirstClassSeats(firstClassSeats);
        }
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
        if (aircraftTypes != null) {
            aircraftTypes.setBusinessSeats(businessSeats);
        }
    }

    // Getters and Setters for Airlines
    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
        if (airlines != null) {
            airlines.setAirlineId(airlineId);
        }
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        if (airlines != null) {
            airlines.setAirlineName(airlineName);
        }
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
        if (airlines != null) {
            airlines.setAirlineCode(airlineCode);
        }
    }

    // Getters and Setters for Airports
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
        if (airports != null) {
            airports.setAirportCode(airportCode);
        }
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
        if (airports != null) {
            airports.setAirportName(airportName);
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        if (airports != null) {
            airports.setCity(city);
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        if (airports != null) {
            airports.setCountry(country);
        }
    }

    // Getters and Setters for Booking
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
        if (booking != null) {
            booking.setBookingId(bookingId);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if (booking != null) {
            booking.setEmail(email);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        if (booking != null) {
            booking.setPhone(phone);
        }
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
        if (booking != null) {
            booking.setBookingDateTime(bookingDateTime);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        if (booking != null) {
            booking.setTotalPrice(totalPrice);
        }
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
        if (booking != null) {
            booking.setBookingStatus(bookingStatus);
        }
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
        if (booking != null) {
            booking.setFlightId(flightId);
        }
    }

    // Getters and Setters for FlightPrices
    public int getFlightPriceId() {
        return flightPriceId;
    }

    public void setFlightPriceId(int flightPriceId) {
        this.flightPriceId = flightPriceId;
        if (flightPrices != null) {
            flightPrices.setFlightPriceId(flightPriceId);
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

    // Getters and Setters for Flights
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

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
        if (flights != null) {
            flights.setFlightStatus(flightStatus);
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

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
        if (flights != null) {
            flights.setGateNumber(gateNumber);
        }
    }
public String getFormattedDepartureTime() {
        return departureTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getFormattedArrivalTime() {
        return arrivalTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getFormattedFlightDate() {
        return flightDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getFormattedArrivalDate() {
        return arrivalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    // Getters and Setters for Passenger
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
        if (passenger != null) {
            passenger.setPassengerId(passengerId);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if (passenger != null) {
            passenger.setFirstName(firstName);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        if (passenger != null) {
            passenger.setLastName(lastName);
        }
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
        if (passenger != null) {
            passenger.setDOB(DOB);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        if (passenger != null) {
            passenger.setGender(gender);
        }
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
        if (passenger != null) {
            passenger.setPassportId(passportId);
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
        if (passenger != null) {
            passenger.setNationality(nationality);
        }
    }

    // Getters and Setters for Payments
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
        if (payments != null) {
            payments.setPaymentId(paymentId);
        }
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        if (payments != null) {
            payments.setPaymentDate(paymentDate);
        }
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        if (payments != null) {
            payments.setPaymentMethod(paymentMethod);
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        if (payments != null) {
            payments.setAmount(amount);
        }
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        if (payments != null) {
            payments.setPaymentStatus(paymentStatus);
        }
    }

    // Getters and Setters for Seats
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
        if (seats != null) {
            seats.setSeatId(seatId);
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        if (seats != null) {
            seats.setSeatNumber(seatNumber);
        }
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        if (seats != null) {
            seats.setIsAvailable(isAvailable);
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public FlightPrices getFlightPrices() {
        return flightPrices;
    }

    public void setFlightPrices(FlightPrices flightPrices) {
        this.flightPrices = flightPrices;
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }
}
