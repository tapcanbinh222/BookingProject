///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package project;
//
//import Database.AllFlightDAO;
//import java.util.Scanner;
//
///**
// *
// * @author trums
// */
//public class ShowFlight {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        AllFlightDAO allFlightdao = new AllFlightDAO();
//        while (true) {
//            System.out.println("1. Show chuyen bay chua di");
//            System.out.println("2. Show chuyen bay dang di");
//            System.out.println("3. Show chuyen bay delay");
//            System.out.println("4. Show chuyen bay huy");
//            System.out.println("5. Show chuyen bay hoan thanh");
//            System.out.println("6. Show All");
//            System.out.println("7. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (choice) {
//                case 1:
//                    allFlightdao.printAllFlightsNotyetdeparted();
//                    break;
//                case 2:
//                    allFlightdao.printAllFlightsOnflight();
//                    break;
//                case 3:
//                    allFlightdao.printAllFlightsDelayed();
//                    break;
//                case 4:
//                    allFlightdao.printAllFlightsCancelled();
//                    break;
//                case 5:
//                    allFlightdao.printAllFlightsCompleted();
//                    break;
//                case 6:
//                    allFlightdao.printAllFlights();
//                    break;
//                case 7:
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }
//    }
//}
