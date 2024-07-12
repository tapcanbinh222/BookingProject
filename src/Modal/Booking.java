package Modal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

    private Passenger passenger;
    private Flights flights;
    private Seats seats;
//    private Payments payments;
    private int bookingId;
    private String email;
    private String phone;
    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String bookingStatus;
    private int passengerId;
    private int flightId;
    private int seatId;
//    private String paymentStatus;

    // Constructor đầy đủ tham số
    public Booking(int bookingId, int passengerId, int flightId, int seatId, String email, String phone, LocalDateTime bookingDateTime, String paymentStatus, double totalPrice, String bookingStatus, Passenger passenger, Flights flights, Seats seats, Payments payments) {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.seatId = seatId;
        this.email = email;
        this.phone = phone;
        this.bookingDateTime = bookingDateTime;
//        this.paymentStatus = paymentStatus;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
        this.passenger = passenger;
        this.seats = seats;
        this.flights = flights;
//        this.payments = payments;
    }

    public Booking() {
        this.passenger = new Passenger();
        this.flights = new Flights();
        this.seats = new Seats();
    }

    // Getter và setter cho các trường dữ liệu
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
        if (passenger != null) {
            flights.setFlightId(flightId);
        }

    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
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

//    public Payments getPayments() {
//        return payments;
//    }
//
//    public void setPayments(Payments payments) {
//        this.payments = payments;
//    }
//
//    // Lấy paymentStatus từ Payments
//    public String getPaymentStatusFromPayments() {
//        return payments.getPaymentStatus();
//    }
}
