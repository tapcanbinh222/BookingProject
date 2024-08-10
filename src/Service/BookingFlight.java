/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modal.Airlines;
import Modal.Booking;
import Modal.Flights;
import Modal.Infants;
import Modal.Passenger;
import Modal.Seats;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author trums
 */
public class BookingFlight {

    private int passengerId;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String gender;
    private String passportId;
    private String nationality;
    private String seatNumber;
    private String seatClass;
    private String gateNumber;

    private int flightId;
    private String flightStatus;
    private String airlineName;
    private String flightNumber;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private LocalDate flightDate;
    private int bookingId;
    private String email;
    private String phone;
    private LocalDateTime bookingDateTime;
    private int seatId;
    private String bookingStatus;
    private double totalPrice;
    private int accompanyingAdultId;
    private String fullName;

    private Passenger passenger;
    private Seats seats;
    private Booking booking;
    private Flights flights;
    private Airlines airlines;
    private String passengerType;
    private Infants infants;

    public BookingFlight() {
        this.passenger = new Passenger();
        this.seats = new Seats();
        this.booking = new Booking();
        this.flights = new Flights();
        this.airlines = new Airlines();
        this.infants = new Infants();

    }

    public int getAccompanyingAdultId() {
        return accompanyingAdultId;
    }

    public void setAccompanyingAdultId(int accompanyingAdultId) {
        this.accompanyingAdultId = accompanyingAdultId;
        if (infants != null) {
            infants.setAccompanyingAdultId(accompanyingAdultId);
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        if (seats != null) {
            seats.setSeatNumber(seatNumber);
        }
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
        if (passenger != null) {
            passenger.setPassengerId(passengerId);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if (passenger != null) {
            passenger.setFirstName(firstName);
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
        if (passenger != null) {
            passenger.setNationality(nationality);
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
        if (booking != null) {
            booking.setBookingId(bookingId);
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

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        if (airlines != null) {
            airlines.setAirlineName(airlineName);
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

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
        if (seats != null) {
            seats.setSeatId(seatId);
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

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
        if (booking != null) {
            booking.setBookingStatus(bookingStatus);
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

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
        if (passenger != null) {
            passenger.setPassengerType(passengerType);
        }
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

}
