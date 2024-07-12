/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Modal.Airports;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trums
 */
public class AirportsDAO {

    static ConnectDB connect = new ConnectDB();
    static Connection cn = null;
    static Statement stm = null;
    static ResultSet rs = null;
    static Scanner sc;
    static PreparedStatement pStm = null;
//
    public ArrayList<Airports> listAirport() {
        ArrayList<Airports> list = new ArrayList<>();
        String sql = "SELECT * FROM Airports";
        try {
            cn = connect.GetConnectDB();
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               Airports airports = new Airports();
                airports.setAirportCode(rs.getString("airport_code"));
                airports.setAirportName(rs.getString("airport_name"));
                airports.setCity(rs.getString("city"));
                airports.setCountry(rs.getString("country"));
            list.add(airports);
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

//    public void AddDB(Product pro) {
//
//        String sql = "insert into product values(?,?,?,?)";
//        try {
//            cn = connect.GetConnectDB();
//
//            pStm.setString(1, pro.getProId());
//            pStm.setString(2, pro.getProName());
//            pStm.setInt(3, pro.getProPrice());
//            pStm.setInt(4, pro.getCateId());
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
//    public void DeleteDB(Product pro) {
//        String sql = "DELETE FROM product WHERE proId = ?";
//        try {
//            cn = connect.GetConnectDB();
//            pStm = cn.prepareStatement(sql);
//            pStm.setString(1, pro.getProId());
//            pStm.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (pStm != null) {
//                    pStm.close();
//                }
//                if (cn != null) {
//                    cn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void EditDB(Product pro) {
//        String sql = "update product set name= ? , description=? , price =? where id = ?";
//        try {
//            //mở kết nối
//            cn = connect.GetConnectDB();
//            //tạo môi trường để viết câu truy vấn
//            pStm = cn.prepareStatement(sql);
//            pStm.setString(1, pro.getProName());
//            pStm.setInt(2, pro.getProPrice());
//            pStm.setInt(3, pro.getCateId());
//            pStm.setString(4, pro.getProId());//1 tương ứng với dấu ? thứ 1 ( có thể: "id")
//            pStm.execute();//chạy câu lệnh sql
//            System.out.println("updated!");
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
//    }
//
//    public ArrayList<Product> search(ArrayList<Product> productList, String keyword) {
//        ArrayList<Product> results = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getProName().toLowerCase().contains(keyword.toLowerCase())) {
//                results.add(product);
//            }
//        }
//        return results;
//    }
}
