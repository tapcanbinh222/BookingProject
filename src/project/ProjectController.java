/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package project;

import Database.AllFlightDAO;
import Service.BookingFlight;
import Service.Flight;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    private TableColumn<Flight, String> tcAirlineName;
    @FXML
    private TableColumn<Flight, Double> tcEconomyPrice;
    @FXML
    private TableColumn<Flight, Double> tcBusinessPrice;
    @FXML
    private TableColumn<Flight, Double> tcFirstClassPrice;
    @FXML
    private TableColumn<Flight, LocalDate> tcFlightDate;
    @FXML
    private TableView<Flight> tvFlight;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private MenuItem btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    private MenuItem btnchangeUpdate;
    @FXML
    private Button btnChangeAdd;
    @FXML
    private Button btnBack1;
    @FXML
    private Button btnBooking;
    @FXML
    private Button btnBackAllBooking;
    @FXML
    private Button btnDetailAllBooking;
    @FXML
    private MenuItem btnChangeBooking;
    @FXML
    private Button btnchangeAllBooking;
    @FXML
    private Button btnBackViewPassById;
    @FXML
    private TextField txtFlightNumber;
    @FXML
    private TextField txtDepartureTime;
    @FXML
    private TextField txtArrivalTime;
    @FXML
    private TextField txtGateNumber;
    @FXML
    private TextField txtEconomyPrice;
    @FXML
    private TextField txtFirstClassPrice;
    @FXML
    private TextField txtBusinessPrice;
    @FXML
    private DatePicker dpArrivalDate;
    @FXML
    private DatePicker dpDepartureDate;
    @FXML
    private AnchorPane apPassengerFlight;
    @FXML
    private AnchorPane apButtonAllBooking;
    @FXML
    private AnchorPane apFindFlight;
    @FXML
    private AnchorPane apAdd;
    @FXML
    private AnchorPane apButonCRUD;
    @FXML
    private AnchorPane apBooking;
    @FXML
    private ComboBox<String> comboBoxAircraftName;
    @FXML
    private ComboBox<String> comboBoxAirlineName;
    @FXML
    private ComboBox<String> comboBoxDestination;
    @FXML
    private ComboBox<String> comboBoxOrigin;
    @FXML
    private ComboBox<String> comboBoxDestinationFind;
    @FXML
    private ComboBox<String> comboBoxOriginFind;
    @FXML
    private ComboBox<String> comboBoxGender;
    @FXML
    private ComboBox<String> comboBoxNational;
    @FXML
    private ComboBox<String> comboBoxSeatType;
    @FXML
    private ComboBox<String> comboBoxSeat;
    @FXML
    private ComboBox<String> comboBoxFlightStatus;
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
    private DatePicker dpFlightDate;
    @FXML
    private DatePicker dpGetDepartureDate;
    @FXML
    private TextField txtGetBusinessPrice;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtGetFirtsClassPrice;
    @FXML
    private TextField txtGetEconomyPrice;
    @FXML
    private TableColumn<BookingFlight, String> tcFirstName;
    @FXML
    private TableColumn<BookingFlight, String> tcLastName;
    @FXML
    private TableColumn<BookingFlight, LocalDate> tcDOB;
    @FXML
    private TableColumn<BookingFlight, String> tcPassportID;
    @FXML
    private TableColumn<BookingFlight, String> tcNationality;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatNumber;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatClass;
    @FXML
    private TableColumn<BookingFlight, String> tcEmail;
    @FXML
    private TableColumn<BookingFlight, String> tcPhone;
    @FXML
    private TableColumn<BookingFlight, LocalDateTime> tcBookingDate;
    @FXML
    private TableColumn<BookingFlight, String> tcFlightStatus_Passenger;
    @FXML
    private TableColumn<BookingFlight, String> tcAirlineName_AllBooking;
    @FXML
    private TableColumn<BookingFlight, String> tcFlightNumber_AllBooking;
    @FXML
    private TableView<BookingFlight> tvPassengerFlight;
    @FXML
    private TextField txtGetAirlineName;
    @FXML
    private TextField txtGetGateNumber;
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
    private SplitMenuButton spitMenuStatus;
    @FXML
    private MenuItem flightDelayed;
    @FXML
    private MenuItem flightCancelled;
    @FXML
    private MenuItem flightScheduled;
    @FXML
    private AnchorPane apTvFlight;
    @FXML
    private AnchorPane apPassByFlight;
    @FXML
    private TableView<BookingFlight> tvPassengerById;
    @FXML
    private TableColumn<BookingFlight, String> tcFirstNameById;
    @FXML
    private TableColumn<BookingFlight, String> tcLastNameById;
    @FXML
    private TableColumn<BookingFlight, String> tcFlightStatusById;
    @FXML
    private TableColumn<BookingFlight, String> tcDOBById;
    @FXML
    private TableColumn<BookingFlight, String> tcGenderById;
    @FXML
    private TableColumn<BookingFlight, String> tcPassportIDById;
    @FXML
    private TableColumn<BookingFlight, String> tcNationalityById;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatNumberById;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatClassById;
    @FXML
    private TableColumn<BookingFlight, String> tcGateNumberById;
    @FXML
    private TableColumn<BookingFlight, String> tcEmailById;
    @FXML
    private TableColumn<BookingFlight, String> tcPhoneById;
    @FXML
    private TableColumn<BookingFlight, String> tcBookingDateById;
    @FXML
    private TableColumn<BookingFlight, String> tcAirlineNameById;
    @FXML
    private TableColumn<BookingFlight, String> tcFlightNumberById;
    @FXML
    private Button btnRefund;
    @FXML
    private Button btnDetailPass;
    @FXML
    private TableColumn<BookingFlight, Double> tcPriceAllBooking;
    @FXML
    private AnchorPane apPassRefund;
    @FXML
    private Button btnBackViewPassById1;
    @FXML
    private Button btnRefund1;

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
    ObservableList<String> optionsFlightStatus = FXCollections.observableArrayList(
            "SCHEDULED",
            "DELAYED",
            "CANCELLED"
    );

    private boolean isChecking = false;
    @FXML
    private Button btnReset;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Flights();
        AllBookings();
        loadFlightData();
        comboBoxSeatType.valueProperty().addListener((observable, oldValue, newValue) -> {
            filterSeatsByType(newValue);
        });
        comboBoxOrigin.valueProperty().addListener((obs, oldVal, newVal) -> checkOriginAndDestination());
        comboBoxDestination.valueProperty().addListener((obs, oldVal, newVal) -> checkOriginAndDestination());
        flightDelayed.setOnAction(this::handleFlightDelayed);
        flightCancelled.setOnAction(this::handleFlightCancelled);
        flightScheduled.setOnAction(this::handleFlightScheduled);
        comboBoxAircraftName.setItems(options);
        comboBoxAirlineName.setItems(optionsAirlineName);
        comboBoxOrigin.setItems(optionsOrigin);
        comboBoxDestination.setItems(optionsDestination);
        comboBoxOriginFind.setItems(optionsOrigin);
        comboBoxDestinationFind.setItems(optionsDestination);
        comboBoxGender.setItems(optionsGender);
        comboBoxNational.setItems(optionsNational);
        comboBoxSeatType.setItems(optionsSeatType);
        comboBoxFlightStatus.setItems(optionsFlightStatus);

    }

    private void loadFlightData() {
        System.out.println("Data Loaded: " + allFlightList.size());

    }

    AllFlightDAO allFlightDAO = new AllFlightDAO();
    ObservableList<Flight> allFlightList = FXCollections.observableArrayList(allFlightDAO.listAllFlight());

    private TableColumn<Flight, Void> colAction;

    public void Flights() {
        tcFlightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        tcOrigin.setCellValueFactory(new PropertyValueFactory<>("originAirportCode"));
        tcDestination.setCellValueFactory(new PropertyValueFactory<>("destinationAirportCode"));
        tcFlightStatus.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        tcDepartureTime.setCellValueFactory(new PropertyValueFactory<>("formattedDepartureTime"));
        tcArrivalTime.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalTime"));
        tcAirlineName.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
        tcEconomyPrice.setCellValueFactory(new PropertyValueFactory<>("economyPrice"));
        tcBusinessPrice.setCellValueFactory(new PropertyValueFactory<>("businessPrice"));
        tcFirstClassPrice.setCellValueFactory(new PropertyValueFactory<>("firstClassPrice"));
        tcFlightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));

        if (colAction == null) {
            colAction = new TableColumn<>("Action");
            colAction.setCellFactory(col -> new TableCell<>() {
                private final Button btnViewPassengers = new Button("View Passengers");
                private final Button btnDetail = new Button("Detail");

                private final HBox pane = new HBox(btnViewPassengers, btnDetail);

                {
                    pane.setSpacing(10); // Set spacing between buttons
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(pane);

                        btnViewPassengers.setOnAction(event -> {
                            Flight flight = getTableView().getItems().get(getIndex());
                            loadPassengers(flight.getFlightId());
                            apFindFlight.setVisible(false);
                            apTvFlight.setVisible(false);
                            apButonCRUD.setVisible(false);
                            apAdd.setVisible(false);
                            btnAdd.setVisible(false);
                        });

                        btnDetail.setOnAction(event -> {
                            Flight flight = getTableView().getItems().get(getIndex());
                            showFlightDetails(flight);
                        });
                    }
                }
            });
        }

        tvFlight.getColumns().add(colAction);
        tvFlight.setItems(allFlightList);
    }

    private ObservableList<BookingFlight> passengerList = FXCollections.observableArrayList();

    private void loadPassengers(int flightId) {
        AllFlightDAO service = new AllFlightDAO();
        List<BookingFlight> bookings = service.getAllBookingDetailsByFlightId(flightId);
        passengerList.clear();
        passengerList.addAll(bookings);
        displayPassengers(flightId);  // Gọi displayPassengers sau khi tải thông tin
    }

    private void displayPassengers(int flightId) {
        AllFlightDAO service = new AllFlightDAO();
        List<BookingFlight> bookings = service.getAllBookingDetailsByFlightId(flightId);

        ObservableList<BookingFlight> bookingList = FXCollections.observableArrayList(bookings);
        tvPassengerById.setItems(bookingList);

        // Thiết lập các cột của bảng tvPassengerById
        tcFirstNameById.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastNameById.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcFlightStatusById.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        tcDOBById.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tcGenderById.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tcPassportIDById.setCellValueFactory(new PropertyValueFactory<>("passportId"));
        tcNationalityById.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        tcSeatNumberById.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        tcSeatClassById.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
        tcGateNumberById.setCellValueFactory(new PropertyValueFactory<>("gateNumber"));
        tcEmailById.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcPhoneById.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tcBookingDateById.setCellValueFactory(new PropertyValueFactory<>("bookingDateTime"));
        tcAirlineNameById.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
        tcFlightNumberById.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

        // Chuyển đổi sang chế độ xem hành khách
        apPassByFlight.setVisible(true);
        apTvFlight.setVisible(false);
    }

    private void showFlightDetails(Flight flight) {
        // Hiển thị chi tiết của chuyến bay trong giao diện người dùng
        // Ví dụ: hiển thị một cửa sổ mới với thông tin chi tiết của chuyến bay
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Flight Details");
        alert.setHeaderText("Details of Flight: " + flight.getFlightNumber());
        alert.setContentText("Origin: " + flight.getOriginAirportCode()
                + "\nDestination: " + flight.getDestinationAirportCode()
                + "\nDeparture Time: " + flight.getDepartureTime()
                + "\nArrival Time: " + flight.getArrivalTime()
                + "\nAirline: " + flight.getAirlineName()
                + "\nStatus: " + flight.getFlightStatus()
                + "\nDate: " + flight.getFlightDate()
                + "\nRemaining Economy seats: " + flight.getEconomySeats()
                + "\nRemaining Business seats: " + flight.getBusinessSeats()
                + "\nRemaining First Class seats: " + flight.getFirstClassSeats()
        );

        alert.showAndWait();
    }

    @FXML
    private void btnHandleAdd(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight add = new Flight();
        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");

        // Check for empty fields
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
        if (isEmpty(comboBoxFlightStatus)) {
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
        if (isEmpty(txtFirstClassPrice)) {
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

        if (errorMessage.length() > 16) { // If there are missing fields
            showAlert("Invalid Fields", errorMessage.toString());
            return;
        }

        if (comboBoxOrigin.getValue().equals(comboBoxDestination.getValue())) {
            showAlert("Invalid Input", "Origin and Destination cannot be the same.");
            return;
        }

        try {
            add.setFlightNumber(txtFlightNumber.getText());
            add.setDestinationAirportCode(comboBoxDestination.getValue());
            add.setOriginAirportCode(comboBoxOrigin.getValue());
            add.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
            add.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));
            add.setFlightDate(dpDepartureDate.getValue());
            add.setArrivalDate(dpArrivalDate.getValue());

            // Kiểm tra chuyến bay trùng giờ và ngày
            for (Flight flight : allFlightList) {
                if (flight.getFlightDate().equals(add.getFlightDate())
                        && flight.getDepartureTime().equals(add.getDepartureTime())
                        && flight.getArrivalTime().equals(add.getArrivalTime())) {
                    showAlert("Duplicate Flight", "There is already a flight at the same time on the same date.");
                    return;
                }
            }

            // Kiểm tra chuyến bay có cùng mã FlightNumber trong ngày
            for (Flight flight : allFlightList) {
                if (flight.getFlightDate().equals(add.getFlightDate())
                        && flight.getFlightNumber().equals(add.getFlightNumber())) {
                    showAlert("Duplicate Flight Number", "There is already a flight with the same flight number on this date.");
                    return;
                }
            }

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
            add.setAirlineName(selectedAirlineNames);
            add.setFlightStatus(comboBoxFlightStatus.getValue());
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
            add.setAircraftTypeName(selectedAircraft);

            add.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
            add.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
            add.setFirstClassPrice(Double.parseDouble(txtFirstClassPrice.getText()));

            // Kiểm tra giá vé
            if (add.getEconomyPrice() > add.getBusinessPrice()
                    || add.getBusinessPrice() > add.getFirstClassPrice()) {
                showAlert("Invalid Price", "Giá vé không hợp lệ: Economy phải nhỏ hơn Business và Business phải nhỏ hơn FirstClass");
                return;
            }

            dao.AddDB(add);
            allFlightList.add(add);
            apTvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);

            // Add new flight to the list and update the table
            clearInputFields();

            // Display success message
            showAlert("Success", "Flight added successfully!");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please enter a valid number for price.");
            alert.showAndWait();
        } catch (DateTimeParseException e) {
            showAlert("Error", "Invalid time or date format.");
        } catch (SQLException e) {
            showAlert("Error", "Unknown error: " + e.getMessage());
        }
    }

    private void checkOriginAndDestination() {
        if (comboBoxOrigin.getValue() != null && comboBoxDestination.getValue() != null) {

            if (comboBoxOrigin.getValue().equals(comboBoxDestination.getValue())) {
                showAlert("Invalid Input", "Origin and Destination cannot be the same.");

            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void btnHandleUpdate(ActionEvent event) {
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");

        // Kiểm tra các trường nhập
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
        if (isEmpty(comboBoxFlightStatus)) {
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
        if (isEmpty(txtFirstClassPrice)) {
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

        // Nếu có lỗi, hiển thị thông báo và kết thúc phương thức
        if (errorMessage.length() > 16) { // Check if any error message has been added
            showAlert("Invalid Fields", errorMessage.toString());
            return;
        }

        try {
            Flight updateFlights = new Flight();
            updateFlights.setFlightId(flightsSelected.getFlightId());
            updateFlights.setFlightNumber(txtFlightNumber.getText());
            updateFlights.setOriginAirportCode(comboBoxOrigin.getValue());
            updateFlights.setDestinationAirportCode(comboBoxDestination.getValue());
            updateFlights.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
            updateFlights.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));
            updateFlights.setAirlineId(getAirlineIdByName(comboBoxAirlineName.getValue()));
            updateFlights.setAirlineName(comboBoxAirlineName.getValue());
            updateFlights.setFlightStatus(comboBoxFlightStatus.getValue());
            updateFlights.setGateNumber(txtGateNumber.getText());
            updateFlights.setAircraftTypeId(getAircraftTypeIdByName(comboBoxAircraftName.getValue()));
            updateFlights.setAircraftTypeName(comboBoxAircraftName.getValue());
            updateFlights.setFlightDate(dpDepartureDate.getValue());
            updateFlights.setArrivalDate(dpArrivalDate.getValue());

            // Kiểm tra chuyến bay trùng giờ và ngày
            for (Flight flight : allFlightList) {
                if (!flight.equals(flightsSelected)
                        && flight.getFlightDate().equals(updateFlights.getFlightDate())
                        && flight.getDepartureTime().equals(updateFlights.getDepartureTime())
                        && flight.getArrivalTime().equals(updateFlights.getArrivalTime())) {
                    showAlert("Duplicate Flight", "There is already a flight at the same time on the same date.");
                    return;
                }
            }

            // Kiểm tra chuyến bay có cùng mã FlightNumber trong ngày
            for (Flight flight : allFlightList) {
                if (!flight.equals(flightsSelected)
                        && flight.getFlightDate().equals(updateFlights.getFlightDate())
                        && flight.getFlightNumber().equals(updateFlights.getFlightNumber())) {
                    showAlert("Duplicate Flight Number", "There is already a flight with the same flight number on this date.");
                    return;
                }
            }

            updateFlights.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
            updateFlights.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
            updateFlights.setFirstClassPrice(Double.parseDouble(txtFirstClassPrice.getText()));

            // Kiểm tra giá vé
            if (updateFlights.getEconomyPrice() > updateFlights.getBusinessPrice()
                    || updateFlights.getBusinessPrice() > updateFlights.getFirstClassPrice()) {
                showAlert("Invalid Price", "Giá vé không hợp lệ: Economy phải nhỏ hơn Business và Business phải nhỏ hơn First Class");
                return;
            }

            allFlightDAO.EditFlight(updateFlights);
            int index = allFlightList.indexOf(flightsSelected);
            if (index != -1) {
                allFlightList.set(index, updateFlights);
            }

            // Cập nhật giá trị ComboBox sau khi cập nhật
            comboBoxAirlineName.setValue(getAirlineNameById(updateFlights.getAirlineId()));
            comboBoxAircraftName.setValue(getAircraftNameById(updateFlights.getAircraftTypeId()));

            clearInputFields();
            apFindFlight.setVisible(true);
            apTvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);
            showAlert("Success", "Flight updated successfully.");
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for price.");
        } catch (DateTimeParseException e) {
            showAlert("Error", "Invalid time or date format.");
        } catch (SQLException e) {
            showAlert("Error", "Unknown error: " + e.getMessage());
        }
    }

// Hàm kiểm tra trường văn bản trống
    private boolean isEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().isEmpty();
    }

    private boolean isEmpty(ComboBox<String> comboBox) {
        return comboBox.getValue() == null;
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
        txtGateNumber.clear();
        txtEconomyPrice.clear();
        txtBusinessPrice.clear();
        txtFirstClassPrice.clear();
        dpArrivalDate.setValue(null);
        dpDepartureDate.setValue(null);
        comboBoxFlightStatus.setValue(null);
        comboBoxAirlineName.setValue(null);
        comboBoxAircraftName.setValue(null);
        comboBoxOrigin.setValue(null);
        comboBoxDestination.setValue(null);
        comboBoxFlightStatus.setPromptText("Status");
        comboBoxAirlineName.setPromptText("Airline Name");
        comboBoxAircraftName.setPromptText("AircraftName");
        comboBoxOrigin.setPromptText("Origin");
        comboBoxDestination.setPromptText("Destination");

    }

    @FXML
    private void btnHandleDelete(ActionEvent event) {
        Flight flightSelected = tvFlight.getSelectionModel().getSelectedItem();
        AllFlightDAO dao = new AllFlightDAO();

        if (flightSelected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("CANCELLED Flight");
            alert.setContentText("Are you sure you want to CANCELLED the flight FN : " + flightSelected.getFlightNumber() + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Đặt trạng thái chuyến bay thành "Cancelled"
                flightSelected.setFlightStatus("CANCELLED");
                dao.CancelledFlight(flightSelected);

                int index = allFlightList.indexOf(flightSelected);
                if (index != -1) {
                    allFlightList.set(index, flightSelected);
                }
                showAlert("Success", "Flight cancelled successfully.");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a flight in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHandleBack(ActionEvent event) {
        apTvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apAdd.setVisible(false);
        apBooking.setVisible(false);
        apFindFlight.setVisible(true);
        clearInputFields();

    }

    @FXML
    private void btnHandleChangeUpdate(ActionEvent event) {
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
        if (flightsSelected == null) {
            showAlert("Error", "No flight selected.");
            apTvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);
            apFindFlight.setVisible(true);
        } else {
            apFindFlight.setVisible(false);
            apTvFlight.setVisible(false);
            apButonCRUD.setVisible(false);
            apAdd.setVisible(true);
            btnAdd.setVisible(false);
            btnUpdate.setVisible(true);
            txtFlightNumber.setText(flightsSelected.getFlightNumber());
            txtFlightNumber.setEditable(false);
            comboBoxOrigin.setValue(flightsSelected.getOriginAirportCode());
            comboBoxDestination.setValue(flightsSelected.getDestinationAirportCode());
            txtDepartureTime.setText(flightsSelected.getDepartureTime().toString());
            txtArrivalTime.setText(flightsSelected.getArrivalTime().toString());
            comboBoxAirlineName.setValue(flightsSelected.getAirlineName());
            comboBoxFlightStatus.setValue(flightsSelected.getFlightStatus());
            txtGateNumber.setText(flightsSelected.getGateNumber());
            txtEconomyPrice.setText(Double.toString(flightsSelected.getEconomyPrice()));
            txtBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
            txtFirstClassPrice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
            dpArrivalDate.setValue(flightsSelected.getArrivalDate());
            dpDepartureDate.setValue(flightsSelected.getFlightDate());
            comboBoxAircraftName.setValue(flightsSelected.getAircraftTypeName());
        }
    }

    @FXML
    private void btnHandleChangeAdd(ActionEvent event) {
        apTvFlight.setVisible(false);
        apFindFlight.setVisible(false);
        apButonCRUD.setVisible(false);
        apAdd.setVisible(true);
        btnAdd.setVisible(true);
        btnUpdate.setVisible(false);
        comboBoxOrigin.setPromptText("Origin");
        comboBoxDestination.setPromptText("Destination");
    }

    // In ra danh sách ObservableList
    @FXML

    private void btnHandleChangeBooking(ActionEvent event) throws SQLException {

        try {
            Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
            if (flightsSelected == null) {
                showAlert("Error", "Selected Flight to Booking.");
                apTvFlight.setVisible(true);
                apButonCRUD.setVisible(true);
                apAdd.setVisible(false);
                apFindFlight.setVisible(true);
            } else if (flightsSelected != null) {
                if (!"SCHEDULED".equals(flightsSelected.getFlightStatus())) {
                    apTvFlight.setVisible(true);
                    apButonCRUD.setVisible(true);
                    apAdd.setVisible(false);
                    apFindFlight.setVisible(true);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Flight Status");
                    alert.setContentText("You can only book a flight with status 'SCHEDULE'.");
                    alert.showAndWait();
                } else {
                    apFindFlight.setVisible(false);
                    apTvFlight.setVisible(false);
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
                }

                // Hiển thị danh sách ghế
            }
        } catch (Exception e) {
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

        // Validate các trường đầu vào
        if (isEmpty(txtFirstName)) {
            errorMessage.append("First Name\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setFirstName(txtFirstName.getText());
        }

        if (isEmpty(txtLastName)) {
            errorMessage.append("Last Name\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setLastName(txtLastName.getText());
        }

        if (dpDOB.getValue() == null) {
            errorMessage.append("Date of Birth\n");
            isFieldMissing = true;
        } else {
            LocalDate dob = dpDOB.getValue();
            bookingFlight.setDOB(dob);
            int age = Period.between(dob, LocalDate.now()).getYears();
            if (age < 12) {
                errorMessage.append("Age must be over 12 years old\n");
                isFieldMissing = true;
            }
        }

        if (isEmpty(comboBoxGender)) {
            errorMessage.append("Gender\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setGender(comboBoxGender.getValue());
        }

        if (isEmpty(txtPassportID)) {
            errorMessage.append("Passport ID\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setPassportId(txtPassportID.getText());
        }

        if (isEmpty(comboBoxNational)) {
            errorMessage.append("Nationality\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setNationality(comboBoxNational.getValue());
        }

        if (flightsSelected != null) {
            bookingFlight.setFlightId(flightsSelected.getFlightId());

            String selectedSeatNumber = comboBoxSeat.getValue();
            if (selectedSeatNumber != null) {
                try {
                    int seatId = dao.getSeatIdByNumberAndFlight(flightsSelected.getFlightId(), selectedSeatNumber);
                    bookingFlight.setSeatId(seatId);
                    // Calculate total price only if seat number is valid
                    bookingFlight.setTotalPrice(calculateTotalPrice(flightsSelected, selectedSeatNumber));
                } catch (SQLException e) {
                    errorMessage.append("Seat Selection\n");
                    isFieldMissing = true;
                }
            } else {
                errorMessage.append("Seat Selection\n");
                isFieldMissing = true;
            }
        } else {
            errorMessage.append("Flight Selection\n");
            isFieldMissing = true;
        }

        if (isEmpty(txtEmail)) {
            errorMessage.append("Email\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setEmail(txtEmail.getText());
        }

        if (isEmpty(txtPhone)) {
            errorMessage.append("Phone\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setPhone(txtPhone.getText());
        }

        if (isEmpty(comboBoxSeatType)) {
            errorMessage.append("Seat Type\n");
            isFieldMissing = true;
        } else {
            bookingFlight.setSeatClass(comboBoxSeatType.getValue());
        }

        bookingFlight.setBookingDateTime(LocalDateTime.now());
        bookingFlight.setBookingStatus("Confirmed");
        bookingFlight.setAirlineName(flightsSelected.getAirlineName());
        bookingFlight.setFlightNumber(flightsSelected.getFlightNumber());
        bookingFlight.setFlightStatus(flightsSelected.getFlightStatus());
        bookingFlight.setSeatNumber(comboBoxSeat.getValue());
        bookingFlight.setGateNumber(flightsSelected.getGateNumber());

        if (isFieldMissing) {
            // Show error message dialog
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Fields");
            alert.setContentText(errorMessage.toString());
            alert.showAndWait();
        } else {
            try {
                dao.BookingFlight(bookingFlight);
                allBookingList.add(bookingFlight);
                // Show success message dialog
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Booking Successful");
                alert.setContentText("Your booking has been successfully made.");
                alert.showAndWait();
            } catch (SQLException e) {
                // Show error message dialog
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Booking Failed");
                alert.setContentText("An error occurred while making the booking. Please try again.");
                alert.showAndWait();
            }
        }
    }

    private double calculateTotalPrice(Flight flight, String seatNumber) {
        if (flight == null || seatNumber == null) {
            throw new IllegalArgumentException("Flight and seatNumber must not be null");
        }

        double basePrice;
        if (seatNumber.endsWith("A")) {
            basePrice = flight.getFirstClassPrice();
        } else if (seatNumber.endsWith("B")) {
            basePrice = flight.getBusinessPrice();
        } else {
            basePrice = flight.getEconomyPrice();
        }

        return basePrice;
    }

    private void filterSeatsByType(String seatType) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

        if (flightsSelected != null) {
            try {
                List<Flight> allSeats = dao.getSeatsByFlightId(flightsSelected.getFlightId());
                List<String> filteredSeats = new ArrayList<>();

                for (Flight seat : allSeats) {
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
                // Show error message dialog
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Loading Seats");
                alert.setContentText("An error occurred while loading the seats. Please try again.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnHandlechangeAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(true);
        apTvFlight.setVisible(false);
        apButonCRUD.setVisible(false);
        apButtonAllBooking.setVisible(true);
        apFindFlight.setVisible(false);
    }
    ObservableList<BookingFlight> allBookingList = FXCollections.observableArrayList(allFlightDAO.getAllBookingDetails());

    public void AllBookings() {
        try {
            // Lấy danh sách tất cả các đặt chỗ từ DAO

            // Thiết lập CellValueFactory cho từng cột
            tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tcDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            tcPassportID.setCellValueFactory(new PropertyValueFactory<>("passportId"));
            tcNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
            tcSeatNumber.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
            tcSeatClass.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tcPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            tcBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDateTime"));
            tcFlightStatus_Passenger.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
            tcAirlineName_AllBooking.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
            tcFlightNumber_AllBooking.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
            tcPriceAllBooking.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

            // Thiết lập dữ liệu cho TableView
            tvPassengerFlight.setItems(allBookingList);
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnHandleBackAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(false);
        apTvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apButtonAllBooking.setVisible(false);
        apFindFlight.setVisible(true);
    }

    @FXML
    private void btnDetailAllBooking(ActionEvent event) {

    }

    @FXML
    private void dpHandleFlightDate(ActionEvent event) {

    }
    private ObservableList<Flight> filteredFlightList = FXCollections.observableArrayList();

    private LocalDate currentSearchDate;

    @FXML
    private void btnFind(ActionEvent event) {
        LocalDate flightDate = dpFlightDate.getValue();
        String origin = comboBoxOriginFind.getValue();
        String destination = comboBoxDestinationFind.getValue();

        // Kiểm tra đầu vào
        if (flightDate == null || origin == null || destination == null || origin.isEmpty() || destination.isEmpty()) {
            showAlert("Invalid Input", "Please fill in all fields.");
            return;
        }

        // Lưu trữ ngày tìm kiếm hiện tại
        currentSearchDate = flightDate;

        // Tìm kiếm trong danh sách chuyến bay
        filteredFlightList.clear();
        for (Flight flight : allFlightList) {
            if (flight.getFlightDate().equals(flightDate)
                    && flight.getOriginAirportCode().equals(origin)
                    && flight.getDestinationAirportCode().equals(destination)) {
                filteredFlightList.add(flight);
            }
        }

        // Cập nhật bảng hiển thị
        tvFlight.setItems(filteredFlightList);

        // Kiểm tra kết quả tìm kiếm
        if (filteredFlightList.isEmpty()) {
            showAlertINFORMATION("No Results", "No flights found for the given criteria.");
            currentSearchDate = null; // Reset the search date if no results found
        }
    }

    private void showAlertINFORMATION(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void handleFlightStatus(ActionEvent event, String status, String message) {
        List<Flight> filteredFlights;

        if (currentSearchDate != null) {
            // Lọc theo ngày tìm kiếm và trạng thái chuyến bay
            filteredFlights = allFlightList.stream()
                    .filter(flight -> status.equals(flight.getFlightStatus()) && flight.getFlightDate().equals(currentSearchDate))
                    .collect(Collectors.toList());
        } else {
            // Chỉ lọc theo trạng thái chuyến bay
            filteredFlights = allFlightList.stream()
                    .filter(flight -> status.equals(flight.getFlightStatus()))
                    .collect(Collectors.toList());
        }

        ObservableList<Flight> filteredFlightList1 = FXCollections.observableArrayList(filteredFlights);
        tvFlight.setItems(filteredFlightList1);

        showAlert(message, "Displaying " + status + " flights.");
    }

    @FXML
    private void handleFlightCancelled(ActionEvent event) {
        handleFlightStatus(event, "CANCELLED", "Flight Cancelled");
    }

    @FXML
    private void handleFlightDelayed(ActionEvent event) {
        handleFlightStatus(event, "DELAYED", "Flight Delayed");
    }

    @FXML
    private void handleFlightScheduled(ActionEvent event) {
        handleFlightStatus(event, "SCHEDULED", "Flight Scheduled");
    }

    @FXML
    private void btnHandleBackViewPassById(ActionEvent event) {
        apPassByFlight.setVisible(false);
        apTvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apFindFlight.setVisible(true);
    }

    @FXML
    private void btnHandleReset(ActionEvent event) {
        // Đặt lại các trường tìm kiếm về giá trị mặc định
        dpFlightDate.setValue(null);
        comboBoxOriginFind.setValue(null);
        comboBoxDestinationFind.setValue(null);
        currentSearchDate = null;

        // Hiển thị lại tất cả các chuyến bay
        tvFlight.setItems(allFlightList);

        // Kiểm tra và thêm lại cột Action nếu bị mất
        if (!tvFlight.getColumns().contains(colAction)) {
            tvFlight.getColumns().add(colAction);
        } else {
            // Cập nhật lại cột Action để đảm bảo các nút hiển thị đúng cách
            colAction.setCellFactory(col -> new TableCell<>() {
                private final Button btnViewPassengers = new Button("View Passengers");
                private final Button btnDetail = new Button("Detail");

                private final HBox pane = new HBox(btnViewPassengers, btnDetail);

                {
                    pane.setSpacing(10); // Set spacing between buttons
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(pane);

                        btnViewPassengers.setOnAction(event -> {
                            Flight flight = getTableView().getItems().get(getIndex());
                            loadPassengers(flight.getFlightId());
                            apFindFlight.setVisible(false);
                            apTvFlight.setVisible(false);
                            apButonCRUD.setVisible(false);
                            apAdd.setVisible(false);
                            btnAdd.setVisible(false);
                        });

                        btnDetail.setOnAction(event -> {
                            Flight flight = getTableView().getItems().get(getIndex());
                            showFlightDetails(flight);
                        });
                    }
                }
            });
        }

        // Thông báo người dùng rằng tất cả các trường đã được đặt lại
        showAlert("Reset", "All fields have been reset and all flights are displayed.");
    }
}
