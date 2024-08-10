/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Modal.AircraftTypes;
import Modal.Airlines;
import Modal.Booking;
import Modal.Passenger;
import Modal.Seats;
import Service.BookingFlight;
import Service.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author trums
 */
public class AllFlightDAO {

    static ConnectDB connect = new ConnectDB();
    static Connection cn = null;
    static Statement stm = null;
    static ResultSet rs = null;
    static Scanner sc;
    static PreparedStatement pStm = null;
//

    public ArrayList<Flight> listAllFlight() {
        ArrayList<Flight> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    flights.flight_id, \n"
                + "    flights.aircraft_type_id, \n"
                + "    flights.flight_number, \n"
                + "    flights.origin_airport_code,\n"
                + "    flights.destination_airport_code,\n"
                + "    flights.departure_time, \n"
                + "    flights.arrival_time, \n"
                + "    flights.flight_date,\n"
                + "    flights.arrival_date,\n"
                + "    flights.flight_status, \n"
                + "    flights.gate_number,\n"
                + "    airlines.airline_name, \n"
                + "    aircraft_types.aircraft_type_name,\n"
                + "    aircraft_types.economy_seats,\n"
                + "    aircraft_types.business_seats,\n"
                + "    aircraft_types.first_class_seats,\n"
                + "    flight_prices.economy_price, \n"
                + "	flight_prices.business_price, \n"
                + "	flight_prices.first_class_price\n"
                + "\n"
                + "FROM \n"
                + "    flights\n"
                + "JOIN \n"
                + "    flight_prices ON flights.flight_id = flight_prices.flight_id\n"
                + "JOIN \n"
                + "    airlines ON flights.airline_id = airlines.airline_id \n"
                + "JOIN \n"
                + "    aircraft_types ON flights.aircraft_type_id = aircraft_types.aircraft_type_id ;";
        try {
            cn = connect.GetConnectDB();
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Flight flight = new Flight();
                Airlines airlines = new Airlines();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setOriginAirportCode(rs.getString("origin_airport_code"));
                flight.setDestinationAirportCode(rs.getString("destination_airport_code"));
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setFlightDate(rs.getDate("flight_date").toLocalDate());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setFlightStatus(rs.getString("flight_status"));
                flight.setGateNumber(rs.getString("gate_number"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setAircraftTypeName(rs.getString("aircraft_type_name"));
                flight.setEconomyPrice(rs.getDouble("economy_price"));
                flight.setBusinessPrice(rs.getDouble("business_price"));
                flight.setFirstClassPrice(rs.getDouble("first_class_price"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setEconomySeats(rs.getInt("economy_seats"));
                flight.setBusinessSeats(rs.getInt("business_seats"));
                flight.setFirstClassSeats(rs.getInt("first_class_seats"));
                flight.setAircraftTypeId(rs.getInt("aircraft_type_id"));

                list.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void AddDB(Flight flight) throws SQLException {
        String sqlFlights = "INSERT INTO flights (airline_id, aircraft_type_id, flight_number, origin_airport_code, destination_airport_code, departure_time, arrival_time, flight_date, flight_status, arrival_date, gate_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlPrices = "INSERT INTO flight_prices (flight_id, economy_price, business_price, first_class_price) VALUES (?, ?, ?, ?)";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStmFlights = cn.prepareStatement(sqlFlights, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement pStmPrices = cn.prepareStatement(sqlPrices)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Thiết lập các tham số cho câu lệnh INSERT vào bảng flights
            pStmFlights.setInt(1, flight.getAirlineId());
            pStmFlights.setInt(2, flight.getAircraftTypeId());
            pStmFlights.setString(3, flight.getFlightNumber());
            pStmFlights.setString(4, flight.getOriginAirportCode());
            pStmFlights.setString(5, flight.getDestinationAirportCode());
            pStmFlights.setTime(6, java.sql.Time.valueOf(flight.getDepartureTime()));
            pStmFlights.setTime(7, java.sql.Time.valueOf(flight.getArrivalTime()));
            pStmFlights.setDate(8, java.sql.Date.valueOf(flight.getFlightDate()));
            pStmFlights.setString(9, flight.getFlightStatus());
            pStmFlights.setDate(10, java.sql.Date.valueOf(flight.getArrivalDate()));
            pStmFlights.setString(11, flight.getGateNumber());

            pStmFlights.executeUpdate();

            // Lấy flight_id vừa thêm
            try (ResultSet generatedKeys = pStmFlights.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    flight.setFlightId(generatedKeys.getInt(1));

                    // Thiết lập các tham số cho câu lệnh INSERT vào bảng flight_prices
                    pStmPrices.setInt(1, flight.getFlightId());
                    pStmPrices.setDouble(2, flight.getEconomyPrice());
                    pStmPrices.setDouble(3, flight.getBusinessPrice());
                    pStmPrices.setDouble(4, flight.getFirstClassPrice());

                    pStmPrices.executeUpdate();

                    // Commit giao dịch
                    cn.commit();
                } else {
                    cn.rollback();
                    throw new SQLException("Creating flight failed, no ID obtained.");
                }
            } catch (SQLException e) {
                cn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần
            throw new SQLException("Error in AddDB method", e);
        }
    }

    public void EditFlight(Flight updateFlights) throws SQLException {
        String sqlFlights = "UPDATE flights SET airline_id = ?, aircraft_type_id = ?, flight_number = ?, origin_airport_code = ?, destination_airport_code = ?, departure_time = ?, arrival_time = ?, flight_date = ?, flight_status = ?, arrival_date = ?, gate_number = ? WHERE flight_id = ?";
        String sqlPrices = "UPDATE flight_prices SET economy_price = ?, business_price = ?, first_class_price = ? WHERE flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStmFlights = cn.prepareStatement(sqlFlights); PreparedStatement pStmPrices = cn.prepareStatement(sqlPrices)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Thiết lập các tham số cho câu lệnh UPDATE vào bảng flights
            pStmFlights.setInt(1, updateFlights.getAirlineId());
            pStmFlights.setInt(2, updateFlights.getAircraftTypeId());
            pStmFlights.setString(3, updateFlights.getFlightNumber());
            pStmFlights.setString(4, updateFlights.getOriginAirportCode());
            pStmFlights.setString(5, updateFlights.getDestinationAirportCode());
            pStmFlights.setTime(6, java.sql.Time.valueOf(updateFlights.getDepartureTime()));
            pStmFlights.setTime(7, java.sql.Time.valueOf(updateFlights.getArrivalTime()));
            pStmFlights.setDate(8, java.sql.Date.valueOf(updateFlights.getFlightDate()));
            pStmFlights.setString(9, updateFlights.getFlightStatus());
            pStmFlights.setDate(10, java.sql.Date.valueOf(updateFlights.getArrivalDate()));
            pStmFlights.setString(11, updateFlights.getGateNumber());
            pStmFlights.setInt(12, updateFlights.getFlightId());

            pStmFlights.executeUpdate();

            // Thiết lập các tham số cho câu lệnh UPDATE vào bảng flight_prices
            pStmPrices.setDouble(1, updateFlights.getEconomyPrice());
            pStmPrices.setDouble(2, updateFlights.getBusinessPrice());
            pStmPrices.setDouble(3, updateFlights.getFirstClassPrice());
            pStmPrices.setInt(4, updateFlights.getFlightId());

            pStmPrices.executeUpdate();

            // Commit giao dịch
            cn.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void DeleteDB(Flight flights) {
        String deleteFlightPricesSQL = "DELETE FROM flight_prices WHERE flight_id = ?";
        String deleteFlightSQL = "DELETE FROM flights WHERE flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement deleteFlightPricesStmt = cn.prepareStatement(deleteFlightPricesSQL); PreparedStatement deleteFlightStmt = cn.prepareStatement(deleteFlightSQL)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Xóa dữ liệu từ bảng flight_prices
            deleteFlightPricesStmt.setInt(1, flights.getFlightId());
            deleteFlightPricesStmt.executeUpdate();

            // Xóa dữ liệu từ bảng flights
            deleteFlightStmt.setInt(1, flights.getFlightId());
            deleteFlightStmt.executeUpdate();

            // Commit giao dịch
            cn.commit();

        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần thiết
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback(); // Rollback giao dịch nếu có lỗi
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void CancelledFlight(Flight flights) {
        String updateFlightSQL = "UPDATE flights SET flight_status = 'CANCELLED' WHERE flight_id = ?";
        String updateBookingsSQL = "UPDATE bookings SET booking_status = 'REFUNDING' WHERE flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement updateFlightStmt = cn.prepareStatement(updateFlightSQL); PreparedStatement updateBookingsStmt = cn.prepareStatement(updateBookingsSQL)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Cập nhật trạng thái chuyến bay
            updateFlightStmt.setInt(1, flights.getFlightId());
            updateFlightStmt.executeUpdate();

            // Cập nhật trạng thái đặt chỗ của tất cả hành khách trên chuyến bay
            updateBookingsStmt.setInt(1, flights.getFlightId());
            updateBookingsStmt.executeUpdate();

            // Commit giao dịch
            cn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback(); // Rollback giao dịch nếu có lỗi
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Flight getFlightById(int flightId) throws SQLException {
        String sql = "SELECT f.*, fp.economy_price, fp.business_price, fp.first_class_price, a.airline_name, at.aircraft_type_name "
                + "FROM flights f "
                + "JOIN flight_prices fp ON f.flight_id = fp.flight_id "
                + "JOIN airlines a ON f.airline_id = a.airline_id "
                + "JOIN aircraft_types at ON f.aircraft_type_id = at.aircraft_type_id "
                + "WHERE f.flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {

            pStm.setInt(1, flightId);
            ResultSet rs = pStm.executeQuery();

            if (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setOriginAirportCode(rs.getString("origin_airport_code"));
                flight.setDestinationAirportCode(rs.getString("destination_airport_code"));
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setFlightDate(rs.getDate("flight_date").toLocalDate());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setFlightStatus(rs.getString("flight_status"));
                flight.setGateNumber(rs.getString("gate_number"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setAircraftTypeName(rs.getString("aircraft_type_name"));
                flight.setEconomyPrice(rs.getDouble("economy_price"));
                flight.setBusinessPrice(rs.getDouble("business_price"));
                flight.setFirstClassPrice(rs.getDouble("first_class_price"));

                return flight;
            }
        }

        return null; // Hoặc ném một ngoại lệ nếu không tìm thấy chuyến bay
    }

    public List<Flight> getSeatsByFlightId(int flightId) throws SQLException {
        String sql = "SELECT\n"
                + "    s.seat_id, -- Thêm cột seat_id\n"
                + "    s.seat_number,\n"
                + "    CASE WHEN b.seat_id IS NOT NULL THEN 0 ELSE 1 END AS is_available\n"
                + "FROM \n"
                + "    seats s\n"
                + "LEFT JOIN \n"
                + "    bookings b ON s.seat_id = b.seat_id AND b.flight_id = ?\n"
                + "WHERE \n"
                + "    s.aircraft_type_id = (SELECT aircraft_type_id FROM flights WHERE flight_id = ?);";
        List<Flight> seats = new ArrayList<>();
        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {
            pStm.setInt(1, flightId);
            pStm.setInt(2, flightId);
            try (ResultSet rs = pStm.executeQuery()) {
                while (rs.next()) {
                    Flight seat = new Flight();
                    seat.setSeatId(rs.getInt("seat_id"));
                    seat.setSeatNumber(rs.getString("seat_number"));
                    seat.setIsAvailable(rs.getBoolean("is_available")); // Nếu is_available là false, nghĩa là ghế đã được đặt
                    seats.add(seat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return seats;
    }

    private BookingFlight lastAddedAdult = null; // Biến lưu thông tin người lớn cuối cùng được thêm

    public void BookingFlight(BookingFlight bookingFlight) throws SQLException {
        String sqlAddPass = "INSERT INTO passengers (first_name, last_name, date_of_birth, gender, passport_number, nationality, passenger_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlAddBooking = "INSERT INTO bookings (passenger_id, flight_id, seat_id, email, phone, booking_date_time, booking_status, total_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlAddInfant = "INSERT INTO infants (passenger_id, accompanying_adult_id) VALUES (?, ?)";

        Connection cn = null;
        PreparedStatement pStmAddPass = null;
        PreparedStatement pStmAddBooking = null;
        PreparedStatement pStmAddInfant = null;

        try {
            cn = connect.GetConnectDB();

            if (cn == null || cn.isClosed()) {
                throw new SQLException("The connection to the database is closed.");
            }

            cn.setAutoCommit(false);

            // Thêm hành khách vào bảng passengers
            pStmAddPass = cn.prepareStatement(sqlAddPass, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmAddPass.setString(1, bookingFlight.getFirstName());
            pStmAddPass.setString(2, bookingFlight.getLastName());
            pStmAddPass.setDate(3, java.sql.Date.valueOf(bookingFlight.getDOB()));
            pStmAddPass.setString(4, bookingFlight.getGender());
            pStmAddPass.setString(5, bookingFlight.getPassportId());
            pStmAddPass.setString(6, bookingFlight.getNationality());
            pStmAddPass.setString(7, bookingFlight.getPassengerType());

            pStmAddPass.executeUpdate();

            ResultSet rs = pStmAddPass.getGeneratedKeys();
            if (rs.next()) {
                bookingFlight.setPassengerId(rs.getInt(1));
            }

            // Nếu hành khách là người lớn, lưu thông tin người lớn cuối cùng
            if ("Adult".equals(bookingFlight.getPassengerType())) {
                lastAddedAdult = bookingFlight;
            }

            // Nếu hành khách là trẻ sơ sinh, gán người lớn đi kèm và thêm vào bảng infants
            if ("Infant".equals(bookingFlight.getPassengerType())) {
                if (lastAddedAdult == null) {
                    throw new SQLException("No accompanying adult found for infant.");
                }
                bookingFlight.setAccompanyingAdultId(lastAddedAdult.getPassengerId());
                bookingFlight.setSeatNumber(lastAddedAdult.getSeatNumber());
                bookingFlight.setSeatId(lastAddedAdult.getSeatId());
                bookingFlight.setSeatClass(lastAddedAdult.getSeatClass());

                double adultPrice = lastAddedAdult.getTotalPrice();
                double infantPrice = adultPrice * 0.10; // Tính giá cho trẻ sơ sinh bằng 10% giá vé người lớn
                bookingFlight.setTotalPrice(infantPrice);

                pStmAddInfant = cn.prepareStatement(sqlAddInfant);
                pStmAddInfant.setInt(1, bookingFlight.getPassengerId());
                pStmAddInfant.setInt(2, bookingFlight.getAccompanyingAdultId());
                pStmAddInfant.executeUpdate();

                // Reset lastAddedAdult for the next Infant
                lastAddedAdult = null;
            }

            // Thêm thông tin đặt chỗ vào bảng bookings
            pStmAddBooking = cn.prepareStatement(sqlAddBooking);
            pStmAddBooking.setInt(1, bookingFlight.getPassengerId());
            pStmAddBooking.setInt(2, bookingFlight.getFlightId());
            pStmAddBooking.setInt(3, bookingFlight.getSeatId());
            pStmAddBooking.setString(4, bookingFlight.getEmail());
            pStmAddBooking.setString(5, bookingFlight.getPhone());
            pStmAddBooking.setTimestamp(6, java.sql.Timestamp.valueOf(bookingFlight.getBookingDateTime()));
            pStmAddBooking.setString(7, bookingFlight.getBookingStatus());
            pStmAddBooking.setDouble(8, bookingFlight.getTotalPrice());

            pStmAddBooking.executeUpdate();

            cn.commit();

            System.out.println("Booking successful for " + bookingFlight.getPassengerType() + bookingFlight.getSeatId());
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            System.out.println("Error during booking: " + e.getMessage());
            // Hiển thị thông báo lỗi cho giao diện người dùng
        } finally {
            try {
                if (pStmAddPass != null) {
                    pStmAddPass.close();
                }
                if (pStmAddBooking != null) {
                    pStmAddBooking.close();
                }
                if (pStmAddInfant != null) {
                    pStmAddInfant.close();
                }
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Other methods...
    public int getSeatIdByNumberAndFlight(int flightId, String seatNumber) throws SQLException {
        String sql = "SELECT s.seat_id "
                + "FROM seats s "
                + "LEFT JOIN bookings b ON s.seat_id = b.seat_id AND b.flight_id = ? "
                + "WHERE s.seat_number = ? AND "
                + "s.aircraft_type_id = (SELECT aircraft_type_id FROM flights WHERE flight_id = ?) "
                + "AND b.seat_id IS NULL"; // Ensure the seat is not already booked

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {
            pStm.setInt(1, flightId);
            pStm.setString(2, seatNumber);
            pStm.setInt(3, flightId);

            try (ResultSet rs = pStm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("seat_id");
                } else {
                    throw new SQLException("No seat found with the specified number for this flight or the seat is already booked." + seatNumber);
                }
            }
        }
    }

    public List<BookingFlight> getAllBookingDetails() {
        List<BookingFlight> bookingList = new ArrayList<>();
        String sql = "SELECT p.passenger_id, p.first_name, p.last_name, p.date_of_birth, p.gender, p.passport_number, p.nationality,p.passenger_type, "
                + "s.seat_number, b.booking_id, b.email, b.phone, b.booking_date_time, f.flight_number, f.gate_number,f.flight_status,f.flight_date, a.airline_name,b.total_price "
                + "FROM bookings b "
                + "JOIN passengers p ON b.passenger_id = p.passenger_id "
                + "JOIN seats s ON b.seat_id = s.seat_id "
                + "JOIN flights f ON b.flight_id = f.flight_id "
                + "JOIN airlines a ON f.airline_id = a.airline_id";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql); ResultSet rs = pStm.executeQuery()) {

            while (rs.next()) {
                BookingFlight allBooking = new BookingFlight();
                allBooking.setPassengerId(rs.getInt("passenger_id"));
                allBooking.setFirstName(rs.getString("first_name"));
                allBooking.setLastName(rs.getString("last_name"));
                allBooking.setDOB(rs.getDate("date_of_birth").toLocalDate());
                allBooking.setGender(rs.getString("gender"));
                allBooking.setPassportId(rs.getString("passport_number"));
                allBooking.setNationality(rs.getString("nationality"));
                allBooking.setSeatNumber(rs.getString("seat_number"));
                allBooking.setBookingId(rs.getInt("booking_id"));
                allBooking.setFlightStatus(rs.getString("flight_status"));
                allBooking.setEmail(rs.getString("email"));
                allBooking.setPhone(rs.getString("phone"));
                allBooking.setBookingDateTime(rs.getTimestamp("booking_date_time").toLocalDateTime());
                allBooking.setFlightNumber(rs.getString("flight_number"));
                allBooking.setGateNumber(rs.getString("gate_number"));
                allBooking.setAirlineName(rs.getString("airline_name"));
                allBooking.setTotalPrice(rs.getDouble("total_price"));

                // Optionally set seat class based on seat number
                String seatNumber = rs.getString("seat_number");
                if (seatNumber.endsWith("A")) {
                    allBooking.setSeatClass("FirstClass");
                } else if (seatNumber.endsWith("B")) {
                    allBooking.setSeatClass("Business");
                } else {
                    allBooking.setSeatClass("Economy");
                }

                bookingList.add(allBooking);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return bookingList;
    }

    public void updateBookingStatusToCancel(int passengerId) throws SQLException {
        String sql = "UPDATE bookings SET booking_status = 'CANCEL', seat_id = NULL WHERE passenger_id = ?";
        String sqlInfant = "UPDATE bookings SET booking_status = 'CANCEL', seat_id = NULL WHERE passenger_id = (SELECT passenger_id FROM infants WHERE accompanying_adult_id = ?)";

        try (Connection cn = connect.GetConnectDB()) {
            // Hủy đặt chỗ cho hành khách chính
            try (PreparedStatement pStm = cn.prepareStatement(sql)) {
                pStm.setInt(1, passengerId);
                pStm.executeUpdate();
            }

            // Kiểm tra nếu hành khách có Infant đi kèm
            if (hasInfant(passengerId, cn)) {
                // Hủy đặt chỗ cho Infant đi kèm
                try (PreparedStatement pStmInfant = cn.prepareStatement(sqlInfant)) {
                    pStmInfant.setInt(1, passengerId);
                    pStmInfant.executeUpdate();
                }
            }
        }
    }

    public void payment(int passengerId) throws SQLException {
        String sql = "UPDATE bookings SET booking_status = 'CONFIRM' WHERE passenger_id = ?";
        String sqlInfant = "UPDATE bookings SET booking_status = 'CONFIRM'  WHERE passenger_id = (SELECT passenger_id FROM infants WHERE accompanying_adult_id = ?)";
        String sqlPayment = "INSERT INTO Payment VALUES(booking_id,payment_date,payment_method,amount,payment_status)";
        try (Connection cn = connect.GetConnectDB()) {
            // Hủy đặt chỗ cho hành khách chính
            try (PreparedStatement pStm = cn.prepareStatement(sql)) {
                pStm.setInt(1, passengerId);
                pStm.executeUpdate();
            }

            // Kiểm tra nếu hành khách có Infant đi kèm
            if (hasInfant(passengerId, cn)) {
                // Hủy đặt chỗ cho Infant đi kèm
                try (PreparedStatement pStmInfant = cn.prepareStatement(sqlInfant)) {
                    pStmInfant.setInt(1, passengerId);
                    pStmInfant.executeUpdate();
                }
            }
        }
    }

    private boolean hasInfant(int adultId, Connection cn) throws SQLException {
        String sqlCheckInfant = "SELECT COUNT(*) FROM infants WHERE accompanying_adult_id = ?";
        try (PreparedStatement pStmCheck = cn.prepareStatement(sqlCheckInfant)) {
            pStmCheck.setInt(1, adultId);
            try (ResultSet rs = pStmCheck.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void Refund(int seatId) throws SQLException {
        String sqlInfants = "UPDATE bookings SET booking_status = 'REFUND', seat_id = NULL WHERE seat_id = ? AND passenger_id IN (SELECT passenger_id FROM infants)";
        String sqlAdult = "UPDATE bookings SET booking_status = 'REFUND', seat_id = NULL WHERE seat_id = ? AND passenger_id NOT IN (SELECT passenger_id FROM infants)";

        try (Connection cn = connect.GetConnectDB()) {
            // Xóa booking của infants liên quan trước
            try (PreparedStatement pStmInfants = cn.prepareStatement(sqlInfants)) {
                pStmInfants.setInt(1, seatId);
                pStmInfants.executeUpdate();
            }

            // Sau đó xóa booking của adult
            try (PreparedStatement pStmAdult = cn.prepareStatement(sqlAdult)) {
                pStmAdult.setInt(1, seatId);
                pStmAdult.executeUpdate();
            }
        }
    }

    public List<BookingFlight> getAllBookingDetailsByFlightId(int flightId) {
        List<BookingFlight> bookingList = new ArrayList<>();
        String sql = "SELECT p.passenger_id, p.first_name, p.last_name, p.date_of_birth, p.gender, p.passport_number, p.nationality, p.passenger_type, \n"
                + "                s.seat_number, b.seat_id, b.booking_id, b.email, b.phone,f.departure_time,f.arrival_time,f.arrival_date, b.booking_date_time, f.flight_number, f.gate_number, f.flight_status,f.flight_date, a.airline_name \n"
                + "                FROM bookings b \n"
                + "                JOIN passengers p ON b.passenger_id = p.passenger_id \n"
                + "                JOIN seats s ON b.seat_id = s.seat_id \n"
                + "                JOIN flights f ON b.flight_id = f.flight_id \n"
                + "                JOIN airlines a ON f.airline_id = a.airline_id WHERE f.flight_id =?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {
            pStm.setInt(1, flightId);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                BookingFlight allBooking = new BookingFlight();
                allBooking.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                allBooking.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                allBooking.setFlightDate(rs.getDate("flight_date").toLocalDate());
                allBooking.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                allBooking.setPassengerId(rs.getInt("passenger_id"));
                allBooking.setFirstName(rs.getString("first_name"));
                allBooking.setLastName(rs.getString("last_name"));
                allBooking.setDOB(rs.getDate("date_of_birth").toLocalDate());
                allBooking.setGender(rs.getString("gender"));
                allBooking.setSeatId(rs.getInt("seat_id"));
                allBooking.setPassportId(rs.getString("passport_number"));
                allBooking.setNationality(rs.getString("nationality"));
                allBooking.setSeatNumber(rs.getString("seat_number"));
                allBooking.setBookingId(rs.getInt("booking_id"));
                allBooking.setFlightStatus(rs.getString("flight_status"));
                allBooking.setBookingDateTime(rs.getTimestamp("booking_date_time").toLocalDateTime());
                allBooking.setFlightNumber(rs.getString("flight_number"));
                allBooking.setGateNumber(rs.getString("gate_number"));
                allBooking.setAirlineName(rs.getString("airline_name"));
                allBooking.setPassengerType(rs.getString("passenger_type"));

                // Tùy chọn thiết lập loại ghế dựa trên số ghế
                String seatNumber = rs.getString("seat_number");
                if (seatNumber.endsWith("A")) {
                    allBooking.setSeatClass("FirstClass");
                } else if (seatNumber.endsWith("B")) {
                    allBooking.setSeatClass("Business");
                } else {
                    allBooking.setSeatClass("Economy");
                }
                bookingList.add(allBooking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public List<BookingFlight> getInfantsByAdultId(int adultId) {
        List<BookingFlight> infants = new ArrayList<>();
        // SQL query để lấy thông tin các infant đi cùng adult
        String sql = "SELECT p.first_name, p.last_name, p.date_of_birth, p.gender, p.passport_number, p.passenger_id,p.passenger_type "
                + "FROM passengers p "
                + "JOIN infants i ON p.passenger_id = i.passenger_id "
                + "WHERE i.accompanying_adult_id = ? AND p.passenger_type = 'Infant'";

        try (Connection cn = connect.GetConnectDB(); // Mở kết nối đến cơ sở dữ liệu
                 PreparedStatement ps = cn.prepareStatement(sql)) { // Tạo đối tượng PreparedStatement
            ps.setInt(1, adultId); // Thiết lập giá trị cho tham số truy vấn
            ResultSet rs = ps.executeQuery(); // Thực thi truy vấn
            System.out.println(adultId);
            while (rs.next()) { // Duyệt qua kết quả truy vấn
                BookingFlight infant = new BookingFlight();
                infant.setPassengerId(rs.getInt("passenger_id"));
                infant.setFirstName(rs.getString("first_name"));
                infant.setLastName(rs.getString("last_name"));
                infant.setDOB(rs.getDate("date_of_birth").toLocalDate());
                infant.setGender(rs.getString("gender"));
                infant.setPassengerType("passenger_type");
                infant.setPassportId(rs.getString("passport_number"));
                // Thêm đối tượng infant vào danh sách
                infants.add(infant);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In thông báo lỗi nếu có
        }
        return infants; // Trả về danh sách các infant
    }

    public BookingFlight getAdultByInfantId(int infantId) {
        BookingFlight adult = null;
        // Câu SQL để lấy thông tin của adult từ bảng passengers và bookings
        String sql = "SELECT p.passenger_id, p.first_name, p.last_name, p.date_of_birth, p.gender, p.passport_number, p.nationality, p.passenger_type, \n"
                + "                s.seat_number, b.booking_id, b.email, b.phone,f.departure_time,f.arrival_time,f.arrival_date, b.booking_date_time, f.flight_number, f.gate_number, f.flight_status,f.flight_date, a.airline_name \n"
                + "                FROM bookings b \n"
                + "                JOIN passengers p ON b.passenger_id = p.passenger_id \n"
                + "JOIN infants i ON p.passenger_id = i.accompanying_adult_id "
                + "                JOIN seats s ON b.seat_id = s.seat_id \n"
                + "                JOIN flights f ON b.flight_id = f.flight_id \n"
                + "                JOIN airlines a ON f.airline_id = a.airline_id WHERE i.passenger_id = ?";

        try (Connection cn = connect.GetConnectDB(); // Mở kết nối đến cơ sở dữ liệu
                 PreparedStatement ps = cn.prepareStatement(sql)) { // Tạo đối tượng PreparedStatement
            ps.setInt(1, infantId); // Thiết lập giá trị cho tham số truy vấn
            ResultSet rs = ps.executeQuery(); // Thực thi truy vấn

            if (rs.next()) { // Nếu có kết quả trả về
                adult = new BookingFlight();
                adult.setPassengerId(rs.getInt("passenger_id"));
                adult.setFirstName(rs.getString("first_name"));
                adult.setLastName(rs.getString("last_name"));
                adult.setDOB(rs.getDate("date_of_birth").toLocalDate());
                adult.setGender(rs.getString("gender"));
                adult.setPassportId(rs.getString("passport_number"));
                String seatNumber = rs.getString("seat_number");
                if (seatNumber.endsWith("A")) {
                    adult.setSeatClass("FirstClass");
                } else if (seatNumber.endsWith("B")) {
                    adult.setSeatClass("Business");
                } else {
                    adult.setSeatClass("Economy");
                }

                adult.setSeatNumber(rs.getString("seat_number")); // Điều chỉnh nếu cần
                adult.setPassengerType(rs.getString("passenger_type"));
                adult.setAirlineName(rs.getString("airline_name")); // Điều chỉnh nếu cần
                adult.setFlightNumber(rs.getString("flight_number")); // Điều chỉnh nếu cần
                adult.setFlightDate(rs.getDate("flight_date").toLocalDate()); // Điều chỉnh nếu cần
                adult.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                adult.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In thông báo lỗi nếu có
        }
        return adult; // Trả về đối tượng adult
    }

    public List<BookingFlight> getInfantsBySeatId(int seatId) {
        List<BookingFlight> infants = new ArrayList<>();
        // SQL query để lấy thông tin các infant đi cùng với seatId
        String sql = "SELECT p.first_name, p.last_name, p.date_of_birth, p.gender, p.passport_number, p.passenger_id, b.seat_id "
                + "FROM passengers p "
                + "JOIN infants i ON p.passenger_id = i.passenger_id "
                + "JOIN bookings b ON p.passenger_id = b.passenger_id "
                + "WHERE b.seat_id = ? AND p.passenger_type = 'Infant'";

        try (Connection cn = connect.GetConnectDB(); // Mở kết nối đến cơ sở dữ liệu
                 PreparedStatement ps = cn.prepareStatement(sql)) { // Tạo đối tượng PreparedStatement
            ps.setInt(1, seatId); // Thiết lập giá trị cho tham số truy vấn
            ResultSet rs = ps.executeQuery(); // Thực thi truy vấn

            while (rs.next()) { // Duyệt qua kết quả truy vấn
                BookingFlight infant = new BookingFlight();
                infant.setPassengerId(rs.getInt("passenger_id"));
                infant.setFirstName(rs.getString("first_name"));
                infant.setLastName(rs.getString("last_name"));
                infant.setDOB(rs.getDate("date_of_birth").toLocalDate());
                infant.setGender(rs.getString("gender"));
                infant.setPassengerType("Infant");
                infant.setPassportId(rs.getString("passport_number"));
                infant.setSeatId(rs.getInt("seat_id"));
                // Thêm đối tượng infant vào danh sách
                infants.add(infant);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In thông báo lỗi nếu có
        }
        return infants; // Trả về danh sách các infant
    }

    public int getBookedSeats(int flightId, char seatTypePrefix) {
        String sql = "SELECT COUNT(*) FROM bookings JOIN seats ON bookings.seat_id = seats.seat_id WHERE flight_id = ? AND seat_number LIKE ?";
         
        try (Connection cn = connect.GetConnectDB(); PreparedStatement pstmt = cn.prepareStatement(sql)) {
            pstmt.setInt(1, flightId); // Gán giá trị flightNumber vào câu truy vấn
            pstmt.setString(2, seatTypePrefix + "%"); // Gán giá trị seatTypePrefix vào câu truy vấn với ký tự đầu tiên của seatNumber
            ResultSet rs = pstmt.executeQuery(); // Thực thi câu truy vấn

            if (rs.next()) { // Kiểm tra nếu có kết quả trả về
                return rs.getInt(1); // Trả về số lượng ghế đã đặt
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Trả về 0 nếu không có kết quả hoặc có lỗi
    }

    public String getSeatNumberById(int seatId) {
        String seatNumber = null;
        String query = "SELECT seat_number FROM seats WHERE seat_id = ?";

        try (Connection cn = connect.GetConnectDB();PreparedStatement statement = cn.prepareStatement(query)) {
            statement.setInt(1, seatId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                seatNumber = resultSet.getString("seat_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return seatNumber;
    }
}
