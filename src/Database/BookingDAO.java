//package Database;
//
//import Modal.AllFlight;
//import Modal.Booking;
//import Modal.Passenger;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Scanner;
//
//public class BookingDAO {
//
//    static ConnectDB connect = new ConnectDB();
//    static Connection cn = null;
//    static Statement stm = null;
//    static ResultSet rs = null;
//    static Scanner sc;
//    static PreparedStatement pStm = null;
//
//    public void AddDB(Booking booking) {
//
//        String sql = "insert into product values(?,?,?,?)";
//        try {
//            cn = connect.GetConnectDB();
//
//            pStm.setString(1, Booking.getProId());
//            pStm.setString(2, Booking.getProName());
//            pStm.setInt(3, Booking.getProPrice());
//            pStm.setInt(4, Booking.getCateId());
//            pStm.execute();
//            pStm.getGeneratedKeys().next();
//
//        } catch (Exception e) {
//            e.getMessage();
//        } finally {
//            try {
//                cn.close();
//                pStm.close();
//            } catch (Exception e) {
//                e.getMessage();
//            }
//        }
//
//    }
//
//}
