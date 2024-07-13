/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package project;

import Database.AllFlightDAO;
import Modal.Seats;
import Service.AllBooking;
import Service.BookingFlight;
import Service.Flight;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ProjectController implements Initializable {

    @FXML
    private TableColumn<Flight, String> tcFlightNumber;
    @FXML
    private TableColumn<Flight, String> tcOrigin;
    @FXML
    private TableColumn<Flight, String> tcDestination;
    @FXML
    private TableColumn<Flight, String> tcFlightStatus;
    @FXML
    private TableColumn<Flight, LocalTime> tcDepartureTime;
    @FXML
    private TableColumn<Flight, LocalTime> tcArrivalTime;
    @FXML
    private TableColumn<Flight, LocalDate> tcFlightDate;
    @FXML
    private TableColumn<Flight, LocalDate> tcArrivalDate;
    @FXML
    private TableColumn<Flight, String> tcAirlineName;
    @FXML
    private TableColumn<Flight, String> tcAircraftType;
    @FXML
    private TableColumn<Flight, String> tcGateNumber;
    @FXML
    private TableColumn<Flight, Double> tcEconomyPrice;
    @FXML
    private TableColumn<Flight, Double> tcBusinessPrice;
    @FXML
    private TableColumn<Flight, Double> tcFirstClassPrice;
    @FXML
    private TableView<Flight> tvFlight;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    ComboBox<String> comboBoxAircraftName;
    @FXML
    private TextField txtFlightNumber;
    @FXML
    private TextField txtDepartureTime;
    @FXML
    private TextField txtArrivalTime;
    @FXML
    private TextField txtFlightStatus;
    @FXML
    private TextField txtGateNumber;
    @FXML
    private TextField txtEconomyPrice;
    @FXML
    private TextField txtFirtsClassPice;
    @FXML
    private DatePicker dpArrivalDate;
    @FXML
    private DatePicker dpDepartureDate;
    @FXML
    private TextField txtBusinessPrice;
    @FXML
    private AnchorPane apAdd;
    @FXML
    private ComboBox<String> comboBoxAirlineName;
    @FXML
    private ComboBox<String> comboBoxDestination;
    @FXML
    private ComboBox<String> comboBoxOrigin;
    @FXML
    private Button btnchangeUpdate;
    @FXML
    private Button btnChangeAdd;
    @FXML
    private AnchorPane apButonCRUD;
    @FXML
    private AnchorPane apBooking;
    @FXML
    private Label lbBusinessPrice;
    @FXML
    private Label lbEconomyPrice;
    @FXML
    private Label lbFirtsClassPrice;
    @FXML
    private TextField txtGetFlightNumber;
    @FXML
    private TextField txtGetDepartureTime;
    @FXML
    private TextField txtGetArrivalTime;
    @FXML
    private TextField txtGetFlightStatus;
    @FXML
    private DatePicker dpGetDepartureDate;
    @FXML
    private TextField txtGetBusinessPrice;
    @FXML
    private Button btnBack1;
    @FXML
    private Button btnBooking;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private ComboBox<String> comboBoxGender;
    @FXML
    private ComboBox<String> comboBoxNational;
    @FXML
    private ComboBox<String> comboBoxSeatType;
    @FXML
    private ComboBox<String> comboBoxSeat;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private Button btnChangeBooking;
    @FXML
    private Button btnchangeAllBooking;
    @FXML
    private TextField txtGetFirtsClassPrice;
    @FXML
    private TextField txtGetEconomyPrice;
    @FXML
    private TableColumn<AllBooking, String> tcFirstName;
    @FXML
    private TableColumn<AllBooking, String> tcLastName;
    @FXML
    private TableColumn<AllBooking, LocalDate> tcDOB;
    @FXML
    private TableColumn<AllBooking, String> tcGender;
    @FXML
    private TableColumn<AllBooking, String> tcPassportID;
    @FXML
    private TableColumn<AllBooking, String> tcNationality;
    @FXML
    private TableColumn<AllBooking, String> tcSeatNumber;
    @FXML
    private TableColumn<AllBooking, String> tcSeatClass;
    @FXML
    private TableColumn<AllBooking, String> tcEmail;
    @FXML
    private TableColumn<AllBooking, String> tcPhone;
    @FXML
    private TableColumn<AllBooking, LocalDateTime> tcBookingDate;
    @FXML
    private TableColumn<AllBooking, String> tcGateNumber_Booking;
    @FXML
    private TableColumn<AllBooking, String> tcFlightStatus_Passenger;
    @FXML
    private TableColumn<AllBooking, String> tcAirlineName_AllBooking;
    @FXML
    private TableColumn<AllBooking, String> tcFlightNumber_AllBooking;
    @FXML
    private TableView<AllBooking> tvPassengerFlight;
    @FXML
    private TextField txtGetAirlineName;
    @FXML
    private TextField txtGetGateNumber;

    ObservableList<String> options = FXCollections.observableArrayList(
            "Boeing 787 Dreamliner",
            "Airbus A321neo"
    );
    ObservableList<String> optionsAirlineName = FXCollections.observableArrayList(
            "Vietnam Airlines",
            "VietJet Air",
            "Bamboo Airways"
    );
    ObservableList<String> optionsOrigin = FXCollections.observableArrayList(
            "SGN",
            "DAD",
            "HAN"
    );
    ObservableList<String> optionsDestination = FXCollections.observableArrayList(
            "SGN",
            "DAD",
            "HAN"
    );
    ObservableList<String> optionsGender = FXCollections.observableArrayList(
            "Male",
            "Female"
    );
    ObservableList<String> optionsSeatType = FXCollections.observableArrayList(
            "Economy",
            "Business",
            "First Class"
    );

    ObservableList<String> optionsNational = FXCollections.observableArrayList(
            "VietNam",
            "Canada",
            "China"
    );

    @FXML
    private TextField txtGetOrigin;
    @FXML
    private TextField txtGetDestination;
    @FXML
    private TextField txtPassportID;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private AnchorPane apPassengerFlight;
    @FXML
    private Button btnBackAllBooking;
    @FXML
    private Button btnDetailAllBooking;
    @FXML
    private AnchorPane apButtonAllBooking;
    @FXML
    private DatePicker dpFlightDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Flights();
        AllBookings();
        loadFlightData();
        comboBoxSeatType.valueProperty().addListener((observable, oldValue, newValue) -> {
            filterSeatsByType(newValue);
        });
        dpFlightDate.setOnAction(this::filterFlightsByDate);
        comboBoxAircraftName.setValue("Choose Aircraft");
        comboBoxAircraftName.setItems(options);
        comboBoxAirlineName.setValue("Choose Airline");
        comboBoxAirlineName.setItems(optionsAirlineName);
        comboBoxOrigin.setValue("Origin");
        comboBoxOrigin.setItems(optionsOrigin);
        comboBoxDestination.setValue("Destination");
        comboBoxDestination.setItems(optionsDestination);
        comboBoxGender.setItems(optionsGender);
        comboBoxNational.setItems(optionsNational);
        comboBoxSeatType.setItems(optionsSeatType);

    }

    private void loadFlightData() {
        System.out.println("Data Loaded: " + allFlightList.size());

    }
    AllFlightDAO allFlightDAO = new AllFlightDAO();
    ObservableList<Flight> allFlightList = FXCollections.observableArrayList(allFlightDAO.listAllFlight());

    public void Flights() {

        tcFlightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        tcOrigin.setCellValueFactory(new PropertyValueFactory<>("originAirportCode"));
        tcDestination.setCellValueFactory(new PropertyValueFactory<>("destinationAirportCode"));
        tcFlightStatus.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        tcDepartureTime.setCellValueFactory(new PropertyValueFactory<>("formattedDepartureTime"));
        tcArrivalTime.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalTime"));
        tcFlightDate.setCellValueFactory(new PropertyValueFactory<>("formattedFlightDate"));
        tcArrivalDate.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalDate"));
        tcAirlineName.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
        tcAircraftType.setCellValueFactory(new PropertyValueFactory<>("aircraftTypeName"));
        tcGateNumber.setCellValueFactory(new PropertyValueFactory<>("gateNumber"));
        tcEconomyPrice.setCellValueFactory(new PropertyValueFactory<>("economyPrice"));
        tcBusinessPrice.setCellValueFactory(new PropertyValueFactory<>("businessPrice"));
        tcFirstClassPrice.setCellValueFactory(new PropertyValueFactory<>("firstClassPrice"));
        tvFlight.setItems(allFlightList);

    }

    private void filterFlightsByDate(ActionEvent event) {
        LocalDate selectedDate = dpFlightDate.getValue();
        if (selectedDate != null) {
            ObservableList<Flight> filteredFlights = FXCollections.observableArrayList();
            for (Flight flight : allFlightList) {
                if (flight.getFlightDate().equals(selectedDate)) {
                    filteredFlights.add(flight);
                }
            }
            tvFlight.setItems(filteredFlights);
        } else {
            tvFlight.setItems(allFlightList);
        }
    }

    @FXML
    private void btnHandleAdd(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight add = new Flight();
        StringBuilder errorMessage = new StringBuilder();

        if (txtFlightNumber.getText() == null || txtFlightNumber.getText().isEmpty()
                || comboBoxOrigin.getValue() == null || comboBoxOrigin.getValue().isEmpty()
                || comboBoxDestination.getValue() == null || comboBoxDestination.getValue().isEmpty()
                || txtDepartureTime.getText() == null || txtDepartureTime.getText().isEmpty()
                || txtArrivalTime.getText() == null || txtArrivalTime.getText().isEmpty()
                || comboBoxAirlineName.getValue() == null || comboBoxAirlineName.getValue().isEmpty()
                || txtFlightStatus.getText() == null || txtFlightStatus.getText().isEmpty()
                || txtGateNumber.getText() == null || txtGateNumber.getText().isEmpty()
                || txtEconomyPrice.getText() == null || txtEconomyPrice.getText().isEmpty()
                || txtBusinessPrice.getText() == null || txtBusinessPrice.getText().isEmpty()
                || txtFirtsClassPice.getText() == null || txtFirtsClassPice.getText().isEmpty()
                || dpArrivalDate.getValue() == null
                || dpDepartureDate.getValue() == null
                || comboBoxAircraftName.getValue() == null || comboBoxAircraftName.getValue().isEmpty()) {

            showAlert("Invalid Fields", "Please fill in all required fields.");
            return;
        } else {
            try {
                add.setFlightNumber(txtFlightNumber.getText());
                add.setDestinationAirportCode(comboBoxDestination.getValue());
                add.setOriginAirportCode(comboBoxOrigin.getValue());
                add.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
                add.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));

                String selectedAirlineNames = comboBoxAirlineName.getValue();
                int airlineId;
                switch (selectedAirlineNames) {
                    case "Vietnam Airlines":
                        airlineId = 1;
                        break;
                    case "VietJet Air":
                        airlineId = 2;
                        break;
                    case "Bamboo Airways":
                        airlineId = 3;
                        break;
                    default:
                        airlineId = 0;
                        break;
                }
                add.setAirlineId(airlineId);
                add.setFlightStatus(txtFlightStatus.getText());
                add.setGateNumber(txtGateNumber.getText());
                String selectedAircraft = comboBoxAircraftName.getValue();
                int aircraftTypeId;
                switch (selectedAircraft) {
                    case "Boeing 787 Dreamliner":
                        aircraftTypeId = 1;
                        break;
                    case "Airbus A321neo":
                        aircraftTypeId = 2;
                        break;
                    default:
                        aircraftTypeId = 0;
                        break;
                }
                add.setAircraftTypeId(aircraftTypeId);
                add.setFlightDate(dpDepartureDate.getValue());
                add.setArrivalDate(dpArrivalDate.getValue());
                add.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
                add.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
                add.setFirstClassPrice(Double.parseDouble(txtFirtsClassPice.getText()));

                dao.AddDB(add);
                allFlightList.add(add);
                tvFlight.setVisible(true);
                apButonCRUD.setVisible(true);
                apAdd.setVisible(false);

                // Thêm flight mới vào danh sách và cập nhật bảng
                clearInputFields();

                // Hiển thị thông báo thành công
                showAlert("Success", "Flight added successfully!");

                // Đồng bộ lại bảng
                System.out.println("Add Success");

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter a valid number for price.");
                alert.showAndWait();
            } catch (DateTimeParseException e) {
                showAlert("Error", "Invalid time or date format.");
            } catch (Exception e) {
                e.printStackTrace();
                showAlert("Error", "Unknown error: " + e.getMessage());
            }
        }

    }

    private void showAlert(String message, String toString) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Category Selected");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void btnHandleUpdate(ActionEvent event) {
    Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

    StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");

    if (isEmpty(txtFlightNumber)) {
        errorMessage.append("Flight Number\n");
    }
    if (isEmpty(comboBoxOrigin)) {
        errorMessage.append("Origin\n");
    }
    if (isEmpty(comboBoxDestination)) {
        errorMessage.append("Destination\n");
    }
    if (isEmpty(txtDepartureTime)) {
        errorMessage.append("Departure Time\n");
    }
    if (isEmpty(txtArrivalTime)) {
        errorMessage.append("Arrival Time\n");
    }
    if (isEmpty(comboBoxAirlineName)) {
        errorMessage.append("Airline Name\n");
    }
    if (isEmpty(txtFlightStatus)) {
        errorMessage.append("Flight Status\n");
    }
    if (isEmpty(txtGateNumber)) {
        errorMessage.append("Gate Number\n");
    }
    if (isEmpty(txtEconomyPrice)) {
        errorMessage.append("Economy Price\n");
    }
    if (isEmpty(txtBusinessPrice)) {
        errorMessage.append("Business Price\n");
    }
    if (isEmpty(txtFirtsClassPice)) {
        errorMessage.append("First Class Price\n");
    }
    if (dpArrivalDate.getValue() == null) {
        errorMessage.append("Arrival Date\n");
    }
    if (dpDepartureDate.getValue() == null) {
        errorMessage.append("Departure Date\n");
    }
    if (isEmpty(comboBoxAircraftName)) {
        errorMessage.append("Aircraft Name\n");
    }

    if (errorMessage.length() > 16) { // Check if any error message has been added
        showAlert("Invalid Fields", errorMessage.toString());
        return;
    }

    try {
        Flight updateFlights = new Flight();

        updateFlights.setFlightNumber(txtFlightNumber.getText());
        updateFlights.setOriginAirportCode(comboBoxOrigin.getValue());
        updateFlights.setDestinationAirportCode(comboBoxDestination.getValue());
        updateFlights.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
        updateFlights.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));
        updateFlights.setAirlineId(getAirlineIdByName(comboBoxAirlineName.getValue()));
        updateFlights.setAirlineName(comboBoxAirlineName.getValue());
        updateFlights.setFlightStatus(txtFlightStatus.getText());
        updateFlights.setGateNumber(txtGateNumber.getText());
        updateFlights.setAircraftTypeId(getAircraftTypeIdByName(comboBoxAircraftName.getValue()));
        updateFlights.setAircraftTypeName(comboBoxAircraftName.getValue());
        updateFlights.setFlightDate(dpDepartureDate.getValue());
        updateFlights.setArrivalDate(dpArrivalDate.getValue());
        updateFlights.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
        updateFlights.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
        updateFlights.setFirstClassPrice(Double.parseDouble(txtFirtsClassPice.getText()));

        allFlightDAO.EditFlight(updateFlights);
        int index = allFlightList.indexOf(flightsSelected);
        if (index != -1) {
            allFlightList.set(index, updateFlights);
        }
        tvFlight.refresh();

        // Set ComboBox values after update
        comboBoxAirlineName.setValue(getAirlineNameById(updateFlights.getAirlineId()));
        comboBoxAircraftName.setValue(getAircraftNameById(updateFlights.getAircraftTypeId()));

        clearInputFields();
        tvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apAdd.setVisible(false);
        tvFlight.refresh();
        showAlert("Success", "Flight updated successfully.");
    } catch (NumberFormatException e) {
        showAlert("Error", "Please enter a valid number for price.");
    } catch (DateTimeParseException e) {
        showAlert("Error", "Invalid time or date format.");
    } catch (SQLException e) {
        showAlert("Error", "Unknown error: " + e.getMessage());
    }
}


    private boolean isEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().isEmpty();
    }

    private boolean isEmpty(ComboBox<String> comboBox) {
        return comboBox.getValue() == null || comboBox.getValue().isEmpty();
    }

    private int getAirlineIdByName(String airlineName) {
        switch (airlineName) {
            case "Vietnam Airlines":
                return 1;
            case "VietJet Air":
                return 2;
            case "Bamboo Airways":
                return 3;
            default:
                return 0;
        }
    }

    private String getAirlineNameById(int airlineId) {
        switch (airlineId) {
            case 1:
                return "Vietnam Airlines";
            case 2:
                return "VietJet Air";
            case 3:
                return "Bamboo Airways";
            default:
                return null;
        }
    }

    private boolean isAirlineIdValid(int airlineId) {
        // Kiểm tra tính hợp lệ của airlineId
        return airlineId != 0;
    }

    private int getAircraftTypeIdByName(String aircraftName) {
        switch (aircraftName) {
            case "Boeing 787 Dreamliner":
                return 1;
            case "Airbus A321neo":
                return 2;
            default:
                return 0;
        }
    }

    private String getAircraftNameById(int aircraftTypeId) {
        switch (aircraftTypeId) {
            case 1:
                return "Boeing 787 Dreamliner";
            case 2:
                return "Airbus A321neo";
            default:
                return null;
        }
    }

    private void clearInputFields() {
        txtFlightNumber.clear();
        txtFlightNumber.setEditable(true); // Cho phép chỉnh sửa mã chuyến bay khi thêm mới
        txtDepartureTime.clear();
        txtArrivalTime.clear();
        txtFlightStatus.clear();
        txtGateNumber.clear();
        txtEconomyPrice.clear();
        txtBusinessPrice.clear();
        txtFirtsClassPice.clear();
        dpArrivalDate.setValue(null);
        dpDepartureDate.setValue(null);
        comboBoxOrigin.setValue(null);
        comboBoxDestination.setValue(null);
        comboBoxAirlineName.setValue(null);
        comboBoxAircraftName.setValue(null);
    }

    @FXML
    private void btnHandleDelete(ActionEvent event) {
        Flight flightSelected = tvFlight.getSelectionModel().getSelectedItem();
        AllFlightDAO dao = new AllFlightDAO();
        if (flightSelected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete Product");
            alert.setContentText("Are you sure you want to delete the product: " + flightSelected.getFlightId() + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Xóa sản phẩm khỏi cơ sở dữ liệu
                dao.DeleteDB(flightSelected);

                // Xóa sản phẩm khỏi danh sách prolist
                allFlightList.remove(flightSelected);
                tvFlight.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a product in the table.");
            alert.showAndWait();
        }

    }

    @FXML
    private void btnHandleBack(ActionEvent event) {
        tvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apAdd.setVisible(false);
        apBooking.setVisible(false);
        clearInputFields();
    }

    @FXML
    private void btnChangeUpdate(ActionEvent event) {
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
        if (flightsSelected == null) {
            showAlert("Error", "No flight selected.");
            tvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);
        } else {
            tvFlight.setVisible(false);
            apButonCRUD.setVisible(false);
            apAdd.setVisible(true);
            btnAdd.setVisible(false);
            btnUpdate.setVisible(true);
            txtFlightNumber.setText(flightsSelected.getFlightNumber());
            txtFlightNumber.setEditable(false); // Không cho phép chỉnh sửa mã chuyến bay
            comboBoxOrigin.setValue(flightsSelected.getOriginAirportCode());
            comboBoxDestination.setValue(flightsSelected.getDestinationAirportCode());
            txtDepartureTime.setText(flightsSelected.getDepartureTime().toString());
            txtArrivalTime.setText(flightsSelected.getArrivalTime().toString());
            comboBoxAirlineName.setValue(flightsSelected.getAirlineName());
            txtFlightStatus.setText(flightsSelected.getFlightStatus());
            txtGateNumber.setText(flightsSelected.getGateNumber());
            txtEconomyPrice.setText(Double.toString(flightsSelected.getEconomyPrice()));
            txtBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
            txtFirtsClassPice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
            dpArrivalDate.setValue(flightsSelected.getArrivalDate());
            dpDepartureDate.setValue(flightsSelected.getFlightDate());
            comboBoxAircraftName.setValue(flightsSelected.getAircraftTypeName());
        }
    }

    @FXML
    private void btnHandleChangeAdd(ActionEvent event) {
        tvFlight.setVisible(false);
        apButonCRUD.setVisible(false);
        apAdd.setVisible(true);
        btnAdd.setVisible(true);
        btnUpdate.setVisible(false);

    }

    // In ra danh sách ObservableList
    @FXML

    private void btnHandleChangeBooking(ActionEvent event) throws SQLException {
        try {
            Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

            if (flightsSelected == null) {
                showAlert("Error", "Selected Flight to Booking.");
                tvFlight.setVisible(true);
                apButonCRUD.setVisible(true);
                apAdd.setVisible(false);
            } else {

                tvFlight.setVisible(false);
                apButonCRUD.setVisible(false);
                apBooking.setVisible(true);

                txtGetFlightNumber.setText(flightsSelected.getFlightNumber());
                txtGetFlightNumber.setEditable(false);
                txtGetOrigin.setText(flightsSelected.getOriginAirportCode());
                txtGetOrigin.setEditable(false);
                txtGetDestination.setText(flightsSelected.getDestinationAirportCode());
                txtGetDestination.setEditable(false);
                txtGetDepartureTime.setText(flightsSelected.getDepartureTime().toString());
                txtGetDepartureTime.setEditable(false);
                txtGetArrivalTime.setText(flightsSelected.getArrivalTime().toString());
                txtGetArrivalTime.setEditable(false);
                txtGetAirlineName.setText(flightsSelected.getAirlineName());
                txtGetAirlineName.setEditable(false);
                txtGetFlightStatus.setText(flightsSelected.getFlightStatus());
                txtGetFlightStatus.setEditable(false);
                txtGetGateNumber.setText(flightsSelected.getGateNumber());
                txtGetGateNumber.setEditable(false);
                txtGetEconomyPrice.setText(Double.toString(flightsSelected.getEconomyPrice()));
                txtGetEconomyPrice.setEditable(false);
                txtGetBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
                txtGetBusinessPrice.setEditable(false);
                txtGetFirtsClassPrice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
                dpGetDepartureDate.setValue(flightsSelected.getFlightDate());

                // Hiển thị danh sách ghế
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unexpected error: " + e.getMessage());
        }
    }

    @FXML
    private void btnHandleBooking(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");
        boolean isFieldMissing = false;
        BookingFlight bookingFlight = new BookingFlight();

        try {
            bookingFlight.setFirstName(txtFirstName.getText());
            bookingFlight.setLastName(txtLastName.getText());
            bookingFlight.setDOB(dpDOB.getValue());
            bookingFlight.setGender(comboBoxGender.getValue());
            bookingFlight.setPassportId(txtPassportID.getText());
            bookingFlight.setNationality(comboBoxNational.getValue());

            if (flightsSelected != null) {
                bookingFlight.setFlightId(flightsSelected.getFlightId());

                String selectedSeatNumber = comboBoxSeat.getValue();
                if (selectedSeatNumber != null) {
                    int seatId = getSeatIdByNumberAndFlight(flightsSelected.getFlightId(), selectedSeatNumber);
                    bookingFlight.setSeatId(seatId);
                } else {
                    errorMessage.append("Seat Selection\n");
                    isFieldMissing = true;
                }
            } else {
                errorMessage.append("Flight Selection\n");
                isFieldMissing = true;
            }

            // Add other necessary fields such as email, phone, etc.
            bookingFlight.setEmail(txtEmail.getText());
            bookingFlight.setPhone(txtPhone.getText());
            bookingFlight.setBookingDateTime(LocalDateTime.now());
            bookingFlight.setBookingStatus("Confirmed");
            bookingFlight.setTotalPrice(calculateTotalPrice(flightsSelected, comboBoxSeat.getValue()));

            if (isFieldMissing) {
                // Show error message dialog
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Missing Fields");
                alert.setContentText(errorMessage.toString());
                alert.showAndWait();
            } else {
                dao.BookingFlight(bookingFlight);
                // Show success message dialog
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Booking Successful");
                alert.setContentText("Your booking has been successfully made.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Show error message dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Booking Failed");
            alert.setContentText("An error occurred while making the booking. Please try again.");
            alert.showAndWait();
        }
    }

    private int getSeatIdByNumberAndFlight(int flightId, String seatNumber) {
        // Implement the actual database query logic to fetch the seat ID based on seat number and flight ID
        // Placeholder implementation:
        int seatId = 0;
        try {
            AllFlightDAO dao = new AllFlightDAO();
            seatId = dao.getSeatIdByNumberAndFlight(flightId, seatNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatId;
    }

    private double calculateTotalPrice(Flight flight, String seatNumber) {
        double totalPrice = 0.0;
        if (seatNumber.endsWith("A")) {
            totalPrice = flight.getFirstClassPrice();
        } else if (seatNumber.endsWith("B")) {
            totalPrice = flight.getBusinessPrice();
        } else {
            totalPrice = flight.getEconomyPrice();
        }
        return totalPrice;
    }

    private void filterSeatsByType(String seatType) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

        if (flightsSelected != null) {
            try {
                List<Seats> allSeats = dao.getSeatsByFlightId(flightsSelected.getFlightId());
                List<String> filteredSeats = new ArrayList<>();

                for (Seats seat : allSeats) {
                    String seatNumber = seat.getSeatNumber();
                    switch (seatType) {
                        case "First Class":
                            if (seatNumber.endsWith("A")) {
                                filteredSeats.add(seatNumber);
                            }
                            break;
                        case "Business":
                            if (seatNumber.endsWith("B")) {
                                filteredSeats.add(seatNumber);
                            }
                            break;
                        case "Economy":
                            if (!seatNumber.endsWith("A") && !seatNumber.endsWith("B")) {
                                filteredSeats.add(seatNumber);
                            }
                            break;
                    }
                }

                comboBoxSeat.getItems().clear();
                comboBoxSeat.getItems().addAll(filteredSeats);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnHandlechangeAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(true);
        tvFlight.setVisible(false);
        apButonCRUD.setVisible(false);
        apButtonAllBooking.setVisible(true);

    }

    public void AllBookings() {
        try {
            // Lấy danh sách tất cả các đặt chỗ từ DAO
            ObservableList<AllBooking> allBookingList = FXCollections.observableArrayList(allFlightDAO.getAllBookingDetails());

            // Thiết lập CellValueFactory cho từng cột
            tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tcDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            tcGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            tcPassportID.setCellValueFactory(new PropertyValueFactory<>("passportId"));
            tcNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
            tcSeatNumber.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
            tcSeatClass.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            tcBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDateTime"));
            tcGateNumber_Booking.setCellValueFactory(new PropertyValueFactory<>("gateNumber"));
            tcFlightStatus_Passenger.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
            tcAirlineName_AllBooking.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
            tcFlightNumber_AllBooking.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

            // Thiết lập dữ liệu cho TableView
            tvPassengerFlight.setItems(allBookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnHandleBackAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(false);
        tvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apButtonAllBooking.setVisible(false);
    }

    @FXML
    private void btnDetailAllBooking(ActionEvent event) {
    }

    @FXML
    private void dpHandleFlightDate(ActionEvent event) {

    }

}
