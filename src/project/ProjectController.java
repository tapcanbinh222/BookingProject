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
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class ProjectController implements Initializable {

    private Label selectedSeat; // Biến để lưu trữ Label của ghế được chọn
    private String selectedSeatNumber; // Biến để lưu trữ số ghế được chọn

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
    private MenuItem btnchangeUpdate;
    @FXML
    private Button btnChangeAdd;
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
    private Text txtGetFlightNumber;
    @FXML
    private Text txtGetDepartureTime;
    @FXML
    private Label txtGetArrivalTime;
    @FXML
    private DatePicker dpFlightDate;
    @FXML
    private Text dpGetDepartureDate;
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
    private Label txtGetAirlineName;
    @FXML
    private Text txtGetOrigin;
    @FXML
    private Text txtGetDestination;
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
    private TableColumn<BookingFlight, String> tcNationalityById1;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatNumberById;
    @FXML
    private TableColumn<BookingFlight, String> tcSeatClassById;
    @FXML
    private TableColumn<BookingFlight, String> tcGateNumberById;
    @FXML
    private TableColumn<BookingFlight, String> tcBookingDateById;
    @FXML
    private TableColumn<BookingFlight, String> tcAirlineNameById;
    @FXML
    private TableColumn<BookingFlight, String> tcFlightNumberById;
    @FXML
    private TableColumn<BookingFlight, String> tcTypePass;
    @FXML
    private Button btnRefund;
    @FXML
    private Button btnDetailPass;
    @FXML
    private TableColumn<BookingFlight, Double> tcPriceAllBooking;
    @FXML
    private AnchorPane apPassRefund;

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
    ObservableList<String> optionsPayment = FXCollections.observableArrayList(
            "VISA",
            "CASH"
    );

    private boolean isChecking = false;
    @FXML
    private Button btnReset;
    @FXML
    private AnchorPane apToBooking;
    @FXML
    private Spinner<Integer> spAdult;
    @FXML
    private Spinner<Integer> spChild;
    @FXML
    private Spinner<Integer> spInfant;
    @FXML
    private TextField tTotal;
    @FXML
    private TextField txtFindDes;
    @FXML
    private TextField txtFindOri;
    @FXML
    private ContextMenu contextMenuOri;
    @FXML
    private ContextMenu contextMenuDes;
    @FXML
    private DatePicker dpFindFlightDate;
    @FXML
    private Button btnFindFlight;
    @FXML
    private TableColumn<Flight, String> tcFlightNumber1;
    @FXML
    private TableColumn<Flight, String> tcOrigin1;
    @FXML
    private TableColumn<Flight, String> tcDestination1;
    @FXML
    private TableColumn<Flight, String> tcFlightStatus1;
    @FXML
    private TableColumn<Flight, LocalTime> tcDepartureTime1;
    @FXML
    private TableColumn<Flight, LocalTime> tcArrivalTime1;
    @FXML
    private TableColumn<Flight, String> tcAirlineName1;
    @FXML
    private TableColumn<Flight, Double> tcEconomyPrice1;
    @FXML
    private TableColumn<Flight, Double> tcBusinessPrice1;
    @FXML
    private TableColumn<Flight, Double> tcFirstClassPrice1;
    @FXML
    private TableColumn<Flight, LocalDate> tcFlightDate1;
    @FXML
    private TableView<Flight> tvFindFlight;
    @FXML
    private Button btnBook;
    @FXML
    private Text txtgetPrice;
    @FXML
    private VBox vboxPassengerDetails;
    @FXML
    private ScrollPane scrollPanePassengerDetails;
    @FXML
    private Button btnBackadAddToapTvFlight;
    @FXML
    private Button btnBackapToBookingtoapTvFlight;
    @FXML
    private Button btnBackapBookingToapToBooking;
    @FXML
    private ScrollPane scrollPaneSelectSeat;
    @FXML
    private Text txtTotal;
    @FXML
    private ComboBox<String> comboBoxPayment;
    @FXML
    private Button btnCancelAll;
    @FXML
    private Button btnPassRefundToPassByFlight;
    @FXML
    private GridPane gridpanePassenger;
    @FXML
    private Button btnRefundAtDetailPass;
    @FXML
    private Text txtGetDepartureTimePayment;
    @FXML
    private Text txtGetFlightNumberPayment;
    @FXML
    private Text txtGetOriginPayment;
    @FXML
    private Text txtGetDestinationPayment;
    @FXML
    private Label txtGetArrivalTimePayment;
    @FXML
    private Label txtGetAirlineNamePayment;
    @FXML
    private Text dpGetDepartureDatePayment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Flights();
        FindFlight();
        AllBookings();
        loadFlightData();
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
        comboBoxPayment.setItems(optionsPayment);
        contextMenuDes = new ContextMenu();
        contextMenuOri = new ContextMenu();
        setupSpinners();
        createAndSetGridPane();
        // Vô hiệu hóa txtFlightNumber ban đầu
        txtFlightNumber.setDisable(true);

        comboBoxAirlineName.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                final String prefix;
                switch (newValue) {
                    case "Vietnam Airlines":
                        prefix = "VN";
                        break;
                    case "Bamboo Airways":
                        prefix = "QH";
                        break;
                    case "VietJet Air":
                        prefix = "VJ";
                        break;
                    default:
                        prefix = "";
                        break;
                }

                // Thiết lập TextFormatter để kiểm soát đầu vào
                TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    if (change.isContentChange()) {
                        String newText = change.getControlNewText();

                        // Kiểm tra nếu người dùng cố gắng thay đổi hai chữ cái đầu tiên
                        if (newText.length() < prefix.length() || !newText.startsWith(prefix)) {
                            return null; // Không cho phép thay đổi
                        }

                        // Kiểm tra nếu phần còn lại không phải là số hoặc không đủ 3 số
                        String numericPart = newText.substring(prefix.length());
                        if (!numericPart.matches("\\d{0,3}")) {
                            return null; // Không cho phép nếu không phải số hoặc vượt quá 3 số
                        }
                    }
                    return change;
                });

                // Loại bỏ TextFormatter hiện tại để cập nhật
                txtFlightNumber.setTextFormatter(null);

                // Đặt TextFormatter mới với tiền tố mới
                txtFlightNumber.setTextFormatter(textFormatter);

                // Đặt lại giá trị của txtFlightNumber với tiền tố mới
                txtFlightNumber.setText(prefix);

                // Kích hoạt txtFlightNumber sau khi chọn hãng hàng không
                txtFlightNumber.setDisable(false);
            } else {
                // Vô hiệu hóa txtFlightNumber nếu không có hãng hàng không nào được chọn
                txtFlightNumber.setDisable(true);
            }
        });

        spAdult.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateInfantSpinner();
            updateMaxChildrenAndAdults();
            updateTotal(); // Cập nhật tổng số hành khách

        });

        spChild.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateMaxChildrenAndAdults();
            updateTotal(); // Cập nhật tổng số hành khách
        });
        spInfant.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateTotal();
        });

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
                            apTvFlight.setVisible(false);
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
                            apTvFlight.setVisible(false);
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
                            apTvFlight.setVisible(false);
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

    @FXML
    private void filterAirportsDestination(KeyEvent event) {
        filterAirports(txtFindDes, contextMenuDes);
    }

    @FXML
    private void filterAirportsOrigin(KeyEvent event) {
        filterAirports(txtFindOri, contextMenuOri);
    }

    private void filterAirports(TextField textField, ContextMenu contextMenu) {
        String filter = textField.getText();
        if (filter.isEmpty()) {
            contextMenu.hide();
            return;
        }

        List<String> filteredAirportCodes = optionsDestination.stream()
                .filter(code -> code.startsWith(filter.toUpperCase()))
                .collect(Collectors.toList());

        if (filteredAirportCodes.isEmpty()) {
            contextMenu.hide();
            return;
        }

        contextMenu.getItems().clear();
        for (String code : filteredAirportCodes) {
            MenuItem item = new MenuItem(code);
            item.setOnAction(e -> {
                textField.setText(code);
                contextMenu.hide();
            });
            contextMenu.getItems().add(item);
        }

        if (!contextMenu.isShowing()) {
            contextMenu.show(textField, Side.BOTTOM, 0, 0);
        }
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

        // Thiết lập các cột của bảng tvPassengerById
        tcFirstNameById.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastNameById.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcFlightStatusById.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        tcDOBById.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tcGenderById.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tcPassportIDById.setCellValueFactory(new PropertyValueFactory<>("passportId"));
        tcNationalityById1.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        tcSeatNumberById.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        tcSeatClassById.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
        tcGateNumberById.setCellValueFactory(new PropertyValueFactory<>("gateNumber"));
        tcBookingDateById.setCellValueFactory(new PropertyValueFactory<>("bookingDateTime"));
        tcAirlineNameById.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
        tcFlightNumberById.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        tcTypePass.setCellValueFactory(new PropertyValueFactory<>("passengerType"));
        tvPassengerById.setItems(bookingList);

        // Chuyển đổi sang chế độ xem hành khách
        apPassByFlight.setVisible(true);
        apTvFlight.setVisible(false);
    }

    private void showFlightDetails(Flight flight) {
        AllFlightDAO flightDAO = new AllFlightDAO();

        // Ép kiểu giá trị trả về thành int nếu cần
        int bookedEconomySeats = (int) flightDAO.getBookedSeats(flight.getFlightId(), 'C');
        int bookedBusinessSeats = (int) flightDAO.getBookedSeats(flight.getFlightId(), 'B');
        int bookedFirstClassSeats = (int) flightDAO.getBookedSeats(flight.getFlightId(), 'A');

        int remainingEconomySeats = flight.getEconomySeats() - bookedEconomySeats;
        int remainingBusinessSeats = flight.getBusinessSeats() - bookedBusinessSeats;
        int remainingFirstClassSeats = flight.getFirstClassSeats() - bookedFirstClassSeats;

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
                + "\nRemaining Economy seats: " + remainingEconomySeats
                + "\nRemaining Business seats: " + remainingBusinessSeats
                + "\nRemaining First Class seats: " + remainingFirstClassSeats
        );

        alert.showAndWait();
    }

    @FXML
    private void btnHandleAdd(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight add = new Flight();
        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");

        if (isEmpty(txtFlightNumber)) {
            errorMessage.append("Flight Number\n");
        }
        if (isEmpty(comboBoxOrigin)) {
            errorMessage.append("Origin\n");
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
        if (dpDepartureDate.getValue() == null) {
            errorMessage.append("Departure Date\n");
        } else if (dpDepartureDate.getValue().isBefore(LocalDate.now())) {
            errorMessage.append("Departure Date cannot be in the past.\n");
        }

        if (dpArrivalDate.getValue() == null) {
            errorMessage.append("Arrival Date\n");
        } else if (dpArrivalDate.getValue().isBefore(LocalDate.now())) {
            errorMessage.append("Arrival Date cannot be in the past.\n");
        }

        if (errorMessage.length() > 16) {
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
                if (flight.getFlightDate().equals(add.getFlightDate()) // Kiểm tra cùng ngày bay
                        && (flight.getDepartureTime().equals(add.getDepartureTime()) // Trùng giờ đi
                        || flight.getArrivalTime().equals(add.getArrivalTime()))) { // Trùng giờ đến
                    showAlert("Duplicate Flight", "There is already a flight with the same departure or arrival time on the same date.");
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
        if (dpDepartureDate.getValue() == null) {
            errorMessage.append("Departure Date\n");
        } else if (dpDepartureDate.getValue().isBefore(LocalDate.now())) {
            errorMessage.append("Departure Date cannot be in the past.\n");
        }

        if (dpArrivalDate.getValue() == null) {
            errorMessage.append("Arrival Date\n");
        } else if (dpArrivalDate.getValue().isBefore(LocalDate.now())) {
            errorMessage.append("Arrival Date cannot be in the past.\n");
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
                if (!flight.equals(flightsSelected) // Không so sánh với chính nó
                        && flight.getFlightDate().equals(updateFlights.getFlightDate()) // Cùng ngày
                        && (flight.getDepartureTime().equals(updateFlights.getDepartureTime()) // Trùng giờ đi
                        || flight.getArrivalTime().equals(updateFlights.getArrivalTime()) // Trùng giờ đến
                        || (flight.getDepartureTime().equals(updateFlights.getDepartureTime())
                        && flight.getArrivalTime().equals(updateFlights.getArrivalTime())))) { // Cùng giờ đi và giờ đến
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
            apTvFlight.setVisible(true);
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
        return textField.getText() == null || textField.getText().trim().isEmpty();
    }

    private boolean isEmpty(ComboBox<String> comboBox) {
        return comboBox == null || comboBox.getValue() == null || comboBox.getValue().trim().isEmpty();
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
    private void btnHandleChangeUpdate(ActionEvent event) {
        Flight flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
        if (flightsSelected == null) {
            showAlert("Error", "No flight selected.");
            apTvFlight.setVisible(true);
            apAdd.setVisible(false);
        } else {
            apTvFlight.setVisible(false);
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
        apAdd.setVisible(true);
        btnAdd.setVisible(true);
        btnUpdate.setVisible(false);
        comboBoxOrigin.setPromptText("Origin");
        comboBoxDestination.setPromptText("Destination");
    }

    // In ra danh sách ObservableList
    @FXML

    private void btnHandleChangeBooking(ActionEvent event) throws SQLException {
        apTvFlight.setVisible(false);
        apAdd.setVisible(false);
        apToBooking.setVisible(true);
    }

    private void FindFlight() {

        tcFlightNumber1.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        tcOrigin1.setCellValueFactory(new PropertyValueFactory<>("originAirportCode"));
        tcDestination1.setCellValueFactory(new PropertyValueFactory<>("destinationAirportCode"));
        tcFlightStatus1.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        tcDepartureTime1.setCellValueFactory(new PropertyValueFactory<>("formattedDepartureTime"));
        tcArrivalTime1.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalTime"));
        tcAirlineName1.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
        tcEconomyPrice1.setCellValueFactory(new PropertyValueFactory<>("economyPrice"));
        tcBusinessPrice1.setCellValueFactory(new PropertyValueFactory<>("businessPrice"));
        tcFirstClassPrice1.setCellValueFactory(new PropertyValueFactory<>("firstClassPrice"));
        tcFlightDate1.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
        FilteredList<Flight> filteredFlightList = new FilteredList<>(allFlightList, flight -> flight.getFlightStatus().equals("SCHEDULED"));
        tvFindFlight.setItems(filteredFlightList);
    }

    @FXML
    private void btnHandleFindFlight(ActionEvent event) {
        try {
            // Kiểm tra đầu vào
            if (txtFindOri.getText().isEmpty()) {
                showAlert("Error", "Origin is empty.");
                return;
            } else if (txtFindDes.getText().isEmpty()) {
                showAlert("Error", "Destination is empty.");
                return;
            } else if (dpFindFlightDate.getValue() == null) {
                showAlert("Error", "Flight Date is empty.");
                return;
            }

            // Lấy giá trị đầu vào
            String origin = txtFindOri.getText();
            String destination = txtFindDes.getText();
            LocalDate flightDate = dpFindFlightDate.getValue();

            // Lưu trữ ngày tìm kiếm hiện tại
            currentSearchDate = flightDate;

            // Tìm kiếm trong danh sách chuyến bay
            filteredFlightList.clear();
            for (Flight flight : allFlightList) {
                if (flight.getFlightDate().equals(flightDate)
                        && flight.getOriginAirportCode().equalsIgnoreCase(origin)
                        && flight.getDestinationAirportCode().equalsIgnoreCase(destination)
                        && "SCHEDULED".equalsIgnoreCase(flight.getFlightStatus())) {
                    filteredFlightList.add(flight);
                }
            }

            // Cập nhật bảng hiển thị
            tvFindFlight.setItems(FXCollections.observableArrayList(filteredFlightList));

            // Kiểm tra kết quả tìm kiếm
            if (filteredFlightList.isEmpty()) {
                showAlert("No Results", "No flights found for the given criteria.");
                currentSearchDate = null; // Reset the search date if no results found
            }
        } catch (Exception e) {
            showAlert("Error", "Unexpected error: " + e.getMessage());
        }
    }

    // Khai báo selectedSeats như là một thuộc tính của lớp
    private Set<String> selectedSeats = new HashSet<>();
    private int maxSelectableSeats;
    private GridPane gridPaneSelectSeats;

    private void createAndSetGridPane() {
        // Tạo GridPane mới
        gridPaneSelectSeats = new GridPane();
        gridPaneSelectSeats.setHgap(10);
        gridPaneSelectSeats.setVgap(10);

        // Đặt GridPane vào ScrollPane
        scrollPaneSelectSeat.setContent(gridPaneSelectSeats);
    }

    private void loadSeatLayout(int aircraftTypeId) {
        AllFlightDAO dao = new AllFlightDAO();
        Flight flightsSelected = tvFindFlight.getSelectionModel().getSelectedItem();

        if (flightsSelected != null) {
            try {
                List<Flight> allSeats = dao.getSeatsByFlightId(flightsSelected.getFlightId());
                Map<String, Boolean> seatBookingStatus = new HashMap<>();

                for (Flight seat : allSeats) {
                    seatBookingStatus.put(seat.getSeatNumber(), seat.getIsAvailable());
                }

                int firstClassSeats = 0;
                int businessClassSeats = 0;
                int economyClassSeats = 0;

                if (aircraftTypeId == 1) { // Boeing 787 Dreamliner
                    firstClassSeats = 12;
                    businessClassSeats = 30;
                    economyClassSeats = 198;
                } else if (aircraftTypeId == 2) { // Airbus A321neo
                    firstClassSeats = 10;
                    businessClassSeats = 20;
                    economyClassSeats = 150;
                }

                // Xóa tất cả các ghế cũ trong GridPane
                gridPaneSelectSeats.getChildren().clear();

                int seatIndex = 0;
                // First Class
                for (int i = 1; i <= firstClassSeats; i++) {
                    String seatNumber = i + "A";
                    createSeatBox(seatNumber, !seatBookingStatus.getOrDefault(seatNumber, true), seatIndex++);
                }

                // Business Class
                for (int i = firstClassSeats + 1; i <= businessClassSeats + firstClassSeats; i++) {
                    String seatNumber = i + "B";
                    createSeatBox(seatNumber, !seatBookingStatus.getOrDefault(seatNumber, true), seatIndex++);
                }

                // Economy Class
                for (int i = businessClassSeats + 1; i <= economyClassSeats + businessClassSeats + firstClassSeats; i++) {
                    String seatNumber = i + "C";
                    createSeatBox(seatNumber, !seatBookingStatus.getOrDefault(seatNumber, true), seatIndex++);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Error Loading Seats", "An error occurred while loading the seats. Please try again.");
            }
        } else {
            System.err.println("No flight selected");
        }
    }

    private void createSeatBox(String seatNumber, boolean isBooked, int seatIndex) {
        Label seatLabel = new Label(seatNumber);
        seatLabel.setMinSize(40, 40);
        seatLabel.setAlignment(Pos.CENTER);
        seatLabel.setStyle("-fx-padding: 5; -fx-background-radius: 10; -fx-background-insets: 5;");

        String color;
        if (isBooked) {
            color = "red";
        } else if (selectedSeats.contains(seatNumber)) {
            color = "yellow";
        } else {
            color = "green";
        }
        seatLabel.setStyle(seatLabel.getStyle() + "-fx-background-color: " + color + ";");

        seatLabel.setOnMouseClicked(event -> {
            if (!isBooked) {
                if (selectedSeats.contains(seatNumber)) {
                    selectedSeats.remove(seatNumber);
                    seatLabel.setStyle("-fx-background-color: green; -fx-background-radius: 10; -fx-background-insets: 5;");
                } else {
                    if (selectedSeats.size() < maxSelectableSeats) {
                        selectedSeats.add(seatNumber);
                        seatLabel.setStyle("-fx-background-color: yellow; -fx-background-radius: 10; -fx-background-insets: 5;");
                    } else {
                        showAlert("Selection Error", "Seat Selection Limit Exceeded", "You can only select up to " + maxSelectableSeats + " seats." + selectedSeats.size());
                    }
                }
                System.out.println("selectedSeat size" + selectedSeats.size());
                System.out.println("maxSelectableSeats :" + maxSelectableSeats);

                updateTotalPrice();

            }
        });

        int col = seatIndex % 6;
        int row = seatIndex / 6;

        gridPaneSelectSeats.add(seatLabel, col, row);
    }

    private void updateTotalPrice() {
        double totalPrice = 0.0;
        Flight flightsSelected = tvFindFlight.getSelectionModel().getSelectedItem();

        if (flightsSelected != null) {
            Set<String> selectedSeatsWithInfants = new HashSet<>(selectedSeats);
            int numberOfAdults = Integer.parseInt(spAdult.getValue().toString());
            int numberOfInfants = Integer.parseInt(spInfant.getValue().toString());

            // Đếm số trẻ sơ sinh đi kèm với mỗi người lớn
            int infantCounter = 0;

            // Tính toán giá tổng cho các ghế đã chọn
            int i = 0;
            for (String seatNumber : selectedSeats) {
                String passengerType = getPassengerTypeByIndex(i);
                double seatPrice = calculateTotalPrice(flightsSelected, seatNumber, passengerType);

                // Nếu hành khách là người lớn và có trẻ sơ sinh đi kèm
                if (passengerType.equals("Adult")) {
                    if (infantCounter < numberOfInfants) {
                        seatPrice += seatPrice * 0.1; // Thêm 10% giá vé của người lớn
                        infantCounter++;
                    }
                }

                totalPrice += seatPrice;
                i++;
            }

            // Định dạng giá tổng với hai số sau dấu thập phân
            DecimalFormat df = new DecimalFormat("#.##");
            String formattedTotalPrice = df.format(totalPrice);

            // Cập nhật giá tổng vào TextField
            txtgetPrice.setText("Total Price: " + formattedTotalPrice);

        }
    }

    private String getPassengerTypeByIndex(int index) {
        int numberOfAdults = Integer.parseInt(spAdult.getValue().toString());
        int numberOfChildren = Integer.parseInt(spChild.getValue().toString());
        int numberOfInfants = Integer.parseInt(spInfant.getValue().toString());

        if (index < numberOfAdults) {
            return "Adult";
        } else if (index < numberOfAdults + numberOfChildren) {
            return "Child";
        } else {
            return "Infant";
        }
    }

    private void calculateMaxSelectableSeats() {
        int numberOfAdults = Integer.parseInt(spAdult.getValue().toString());
        int numberOfChildren = Integer.parseInt(spChild.getValue().toString());
        maxSelectableSeats = numberOfAdults + numberOfChildren;
    }
// Thay đổi cách lấy loại ghế từ số ghế (giả sử bạn đã có logic để phân loại ghế)

    private String determineSeatClass(String seatNumber) {
        String seatClass;
        if (seatNumber.endsWith("A")) {
            seatClass = "First Class";
        } else if (seatNumber.endsWith("B")) {
            seatClass = "Business Class";
        } else {
            seatClass = "Economy Class";
        }
        return seatClass;
    }

// If all passengers are valid, proceed to add to the database
    private double calculateTotalPrice(Flight flight, String seatNumber, String passengerType) {
        if (flight == null || seatNumber == null || passengerType == null) {
            throw new IllegalArgumentException("Flight, seatNumber, and passengerType must not be null");
        }

        double basePrice;
        if (seatNumber.endsWith("A")) {
            basePrice = flight.getFirstClassPrice();
        } else if (seatNumber.endsWith("B")) {
            basePrice = flight.getBusinessPrice();
        } else if (seatNumber.endsWith("C")) {
            basePrice = flight.getEconomyPrice();
        } else {
            throw new IllegalArgumentException("Invalid seat number");
        }

        switch (passengerType) {
            case "Adult":
                return basePrice;
            case "Child":
                return basePrice * 0.9;  // 90% giá vé cho trẻ em
            case "Infant":
                return basePrice * 0.1;  // 10% giá vé cho trẻ sơ sinh
            default:
                throw new IllegalArgumentException("Invalid passenger type");
        }
    }

    private VBox createPassengerBox(String labelText, String passengerType) {
        VBox passengerBox = new VBox(5);
        passengerBox.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 1;");

        Label label = new Label(labelText);
        TextField txtFirstName = new TextField();
        txtFirstName.setPromptText("First Name");
        txtFirstName.setId("txtFirstName");

        TextField txtLastName = new TextField();
        txtLastName.setPromptText("Last Name");
        txtLastName.setId("txtLastName");

        DatePicker dpDOB = new DatePicker();
        dpDOB.setPromptText("Date of Birth");
        dpDOB.setId("dpDOB");
        dpDOB.setValue(getDefaultDOB(passengerType));

        ComboBox<String> comboBoxGender = new ComboBox<>(optionsGender);
        comboBoxGender.setPromptText("Gender");
        comboBoxGender.setId("comboBoxGender");

        TextField txtPassportID = new TextField();
        txtPassportID.setPromptText("Passport ID");
        txtPassportID.setId("txtPassportID");

        ComboBox<String> comboBoxNational = new ComboBox<>(optionsNational);
        comboBoxNational.setPromptText("Nationality");
        comboBoxNational.setId("comboBoxNational");

        // Error labels
        Label lblFirstNameError = new Label();
        Label lblLastNameError = new Label();
        Label lblDOBError = new Label();
        Label lblGenderError = new Label();
        Label lblPassportIDError = new Label();
        Label lblNationalError = new Label();

        // Set error labels style (red text)
        lblFirstNameError.setStyle("-fx-text-fill: red;");
        lblLastNameError.setStyle("-fx-text-fill: red;");
        lblDOBError.setStyle("-fx-text-fill: red;");
        lblGenderError.setStyle("-fx-text-fill: red;");
        lblPassportIDError.setStyle("-fx-text-fill: red;");
        lblNationalError.setStyle("-fx-text-fill: red;");

        // Add controls to passengerBox
        passengerBox.getChildren().addAll(label, txtFirstName, lblFirstNameError, txtLastName, lblLastNameError,
                dpDOB, lblDOBError, comboBoxGender, lblGenderError, txtPassportID, lblPassportIDError,
                comboBoxNational, lblNationalError);

        passengerBox.getProperties().put("passengerType", passengerType);
        passengerBox.getProperties().put("lblFirstNameError", lblFirstNameError);
        passengerBox.getProperties().put("lblLastNameError", lblLastNameError);
        passengerBox.getProperties().put("lblDOBError", lblDOBError);
        passengerBox.getProperties().put("lblGenderError", lblGenderError);
        passengerBox.getProperties().put("lblPassportIDError", lblPassportIDError);
        passengerBox.getProperties().put("lblNationalError", lblNationalError);

        return passengerBox;
    }

    private void generatePassengerFields(int airCraftTypeId) {
        // Clear existing fields
        vboxPassengerDetails.getChildren().clear();

        // Get number of passengers
        int numberOfAdults = Integer.parseInt(spAdult.getValue().toString());
        int numberOfChildren = Integer.parseInt(spChild.getValue().toString());
        int numberOfInfants = Integer.parseInt(spInfant.getValue().toString());

        calculateMaxSelectableSeats();

        for (int i = 1; i <= numberOfAdults; i++) {
            VBox passengerBox = createPassengerBox("Adult " + i, "Adult");
            vboxPassengerDetails.getChildren().add(passengerBox);

            if (i <= numberOfInfants) {
                VBox infantBox = createPassengerBox("Infant " + i, "Infant");
                vboxPassengerDetails.getChildren().add(infantBox);
            }
        }

        for (int i = numberOfInfants + 1; i <= numberOfChildren + numberOfInfants; i++) {
            VBox passengerBox = createPassengerBox("Child " + (i - numberOfInfants), "Child");
            vboxPassengerDetails.getChildren().add(passengerBox);
        }

        scrollPanePassengerDetails.setContent(vboxPassengerDetails);

        // Load seat layout in the separate ScrollPane
        loadSeatLayout(airCraftTypeId); // Pass the correct aircraft type ID here
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void btnHandleBooking(ActionEvent event) {
        try {
            AllFlightDAO dao = new AllFlightDAO();
            Flight flightsSelected = tvFindFlight.getSelectionModel().getSelectedItem();
            boolean isFieldMissing = false;
            boolean hasErrors = false;
            boolean emptySeat = false;
            if (flightsSelected == null) {
                isFieldMissing = true;
            }

            int numberOfAdults = 0;
            int numberOfChildren = 0;
            List<BookingFlight> validBookings = new ArrayList<>();
            Iterator<String> seatIterator = selectedSeats.iterator();

            for (Node node : vboxPassengerDetails.getChildren()) {
                if (node instanceof VBox) {
                    VBox passengerBox = (VBox) node;
                    TextField txtFirstName = (TextField) passengerBox.lookup("#txtFirstName");
                    TextField txtLastName = (TextField) passengerBox.lookup("#txtLastName");
                    DatePicker dpDOB = (DatePicker) passengerBox.lookup("#dpDOB");
                    ComboBox<String> comboBoxGender = (ComboBox<String>) passengerBox.lookup("#comboBoxGender");
                    TextField txtPassportID = (TextField) passengerBox.lookup("#txtPassportID");
                    ComboBox<String> comboBoxNational = (ComboBox<String>) passengerBox.lookup("#comboBoxNational");
                    TextField txtSeats = (TextField) passengerBox.lookup("#txtSeats");

                    // Reset all error labels
                    Label lblFirstNameError = (Label) passengerBox.getProperties().get("lblFirstNameError");
                    Label lblLastNameError = (Label) passengerBox.getProperties().get("lblLastNameError");
                    Label lblDOBError = (Label) passengerBox.getProperties().get("lblDOBError");
                    Label lblGenderError = (Label) passengerBox.getProperties().get("lblGenderError");
                    Label lblPassportIDError = (Label) passengerBox.getProperties().get("lblPassportIDError");
                    Label lblNationalError = (Label) passengerBox.getProperties().get("lblNationalError");

                    lblFirstNameError.setText("");
                    lblLastNameError.setText("");
                    lblDOBError.setText("");
                    lblGenderError.setText("");
                    lblPassportIDError.setText("");
                    lblNationalError.setText("");

                    String passengerType = (String) passengerBox.getProperties().get("passengerType");
                    boolean passengerValid = true;
                    BookingFlight bookingFlight = new BookingFlight();

                    if (isEmpty(txtFirstName)) {
                        lblFirstNameError.setText("Tên không được để trống");
                        passengerValid = false;
                    }

                    if (isEmpty(txtLastName)) {
                        lblLastNameError.setText("Họ không được để trống");
                        passengerValid = false;
                    }

                    if (dpDOB.getValue() == null) {
                        lblDOBError.setText("Ngày sinh không được để trống");
                        passengerValid = false;
                    } else {
                        LocalDate dob = dpDOB.getValue();
                        int age = Period.between(dob, LocalDate.now()).getYears();
                        switch (passengerType) {
                            case "Infant":
                                if (age >= 2) {
                                    lblDOBError.setText("Infants must be younger than 2 years");
                                    passengerValid = false;
                                }
                                break;
                            case "Child":
                                if (age < 2 || age >= 12) {
                                    lblDOBError.setText("Children must be between 2 and 12 years");
                                    passengerValid = false;
                                }
                                break;
                            case "Adult":
                                if (age < 12) {
                                    lblDOBError.setText("Adults must be 12 years or older");
                                    passengerValid = false;
                                }
                                break;
                        }
                    }

                    if (isEmpty(comboBoxGender)) {
                        lblGenderError.setText("Giới tính không được để trống");
                        passengerValid = false;
                    }

                    if (isEmpty(txtPassportID)) {
                        lblPassportIDError.setText("Số hộ chiếu không được để trống");
                        passengerValid = false;
                    }

                    if (isEmpty(comboBoxNational)) {
                        lblNationalError.setText("Quốc tịch không được để trống");
                        passengerValid = false;
                    }

                    if (!"Infant".equals(passengerType)) {
                        if (selectedSeats.isEmpty()) {
                            emptySeat = true;
                        }
                    }

                    if (passengerValid) {
                        bookingFlight.setFirstName(txtFirstName.getText());
                        bookingFlight.setLastName(txtLastName.getText());
                        bookingFlight.setDOB(dpDOB.getValue());
                        bookingFlight.setGender(comboBoxGender.getValue());
                        bookingFlight.setPassportId(txtPassportID.getText());
                        bookingFlight.setNationality(comboBoxNational.getValue());
                        bookingFlight.setFlightId(flightsSelected.getFlightId());

                        if (selectedSeats.size() == maxSelectableSeats) {
                            if (!"Infant".equals(passengerType)) {
                                String selectedSeatNumber = seatIterator.next(); // Lấy ghế kế tiếp từ iterator
                                try {
                                    int seatId = dao.getSeatIdByNumberAndFlight(flightsSelected.getFlightId(), selectedSeatNumber);
                                    bookingFlight.setSeatId(seatId);
                                    bookingFlight.setTotalPrice(calculateTotalPrice(flightsSelected, selectedSeatNumber, passengerType));
                                    bookingFlight.setSeatNumber(selectedSeatNumber);
                                    bookingFlight.setSeatClass(determineSeatClass(selectedSeatNumber));

                                } catch (SQLException e) {

                                    hasErrors = true;
                                    showAlert("Error", "Invalid Passenger Information", "Lỗi khi chọn ghế: " + e.getMessage());

                                }
                            }
                        } else {
                            emptySeat = true;
                            showAlert("Error", "Invalid Seat Information", "Chọn đủ ghế ");
                        }
                        bookingFlight.setEmail(txtEmail.getText());
                        bookingFlight.setPhone(txtPhone.getText());
                        bookingFlight.setBookingDateTime(LocalDateTime.now());
                        bookingFlight.setBookingStatus("PENDING");
                        bookingFlight.setAirlineName(flightsSelected.getAirlineName());
                        bookingFlight.setFlightNumber(flightsSelected.getFlightNumber());
                        bookingFlight.setFlightStatus(flightsSelected.getFlightStatus());
                        bookingFlight.setGateNumber(flightsSelected.getGateNumber());
                        bookingFlight.setPassengerType(passengerType);

                        if (passengerValid) {
                            validBookings.add(bookingFlight);
                            if ("Adult".equals(passengerType)) {
                                numberOfAdults++;
                            } else if ("Child".equals(passengerType)) {
                                numberOfChildren++;
                            }
                        }
                    } else {
                        hasErrors = true;
                    }
                }
            }

            if (isFieldMissing) {
                showAlert("Error", "Missing Fields", "Please select a flight.");
            } else if (hasErrors) {
                showAlert("Error", "Invalid Passenger Information", "Please correct the errors in the passenger details.");
            } else if (emptySeat) {
                showAlert("Error", "Invalid Seat Information", "Seat is Empty");
            } else {
                try {
                    for (BookingFlight booking : validBookings) {
                        dao.BookingFlight(booking);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Booking Successful");
                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            double totalPrice = validBookings.stream()
                                    .mapToDouble(BookingFlight::getTotalPrice)
                                    .sum();
                            double infantPrice = validBookings.stream()
                                    .filter(b -> "Infant".equals(b.getPassengerType()))
                                    .mapToDouble(BookingFlight::getTotalPrice)
                                    .sum();

                            paymentScene(
                                    validBookings,
                                    flightsSelected.getAirlineName(),
                                    flightsSelected.getOriginAirportCode(),
                                    flightsSelected.getDestinationAirportCode(),
                                    flightsSelected.getFlightNumber(),
                                    flightsSelected.getArrivalTime(),
                                    flightsSelected.getDepartureTime(),
                                    flightsSelected.getFlightDate(),
                                    totalPrice,
                                    infantPrice
                            );
                        }

                    });
                } catch (SQLException e) {
                    showAlert("Error", "Booking Failed", "An error occurred while booking the flight. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi chi tiết
            showAlert("Error", "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    @FXML
    private void btnHandleBook(ActionEvent event) {
        try {
            Flight flightsSelected = tvFindFlight.getSelectionModel().getSelectedItem();
            if (flightsSelected == null) {
                showAlert("Error", "Selected Flight to Booking.");
                apBooking.setVisible(false);
                apToBooking.setVisible(true);
            } else {
                apBooking.setVisible(true);
                apToBooking.setVisible(false);
                txtGetFlightNumber.setText(flightsSelected.getFlightNumber());
                txtGetOrigin.setText(flightsSelected.getOriginAirportCode());
                txtGetDestination.setText(flightsSelected.getDestinationAirportCode());
                txtGetDepartureTime.setText(flightsSelected.getDepartureTime().toString());
                txtGetArrivalTime.setText(flightsSelected.getArrivalTime().toString());
                txtGetAirlineName.setText(flightsSelected.getAirlineName());
                txtGetBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
                txtGetBusinessPrice.setEditable(false);
                txtGetFirtsClassPrice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
                LocalDate flightDate = flightsSelected.getFlightDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = flightDate.format(formatter);
                dpGetDepartureDate.setText(formattedDate);
                int airCraftTypeId = flightsSelected.getAircraftTypeId();
                generatePassengerFields(airCraftTypeId);
            }

            // Hiển thị danh sách ghế
        } catch (Exception e) {
            showAlert("Error", "Unexpected error: " + e.getMessage());
        }
    }

    private LocalDate getDefaultDOB(String passengerType) {
        switch (passengerType) {
            case "Infant":
                return LocalDate.now().minusYears(1); // Infants dưới 2 tuổi, đặt ngày sinh mặc định là 1 năm trước
            case "Child":
                return LocalDate.now().minusYears(2); // Children từ 2 đến 12 tuổi, đặt ngày sinh mặc định là 5 năm trước
            case "Adult":
                return LocalDate.now().minusYears(12); // Adults từ 12 tuổi trở lên, đặt ngày sinh mặc định là 25 năm trước
            default:
                return LocalDate.now();
        }
    }

    @FXML
    private Text txtPaymentName;
    @FXML
    private Text txtDestinationPayment;
    @FXML
    private Text txtOriginPayment;
    @FXML
    private Text txtInfantName;
    @FXML
    private Text txtgetPriceInfant;
    @FXML
    private Text txtGetTotlPricePayment;
    @FXML
    private Text txtVAT;
    @FXML
    private Text txtAirportSecurityFee;
    @FXML
    private Button btnPayment;
    @FXML
    private ScrollPane scrollpaneDetailPrice;
    @FXML
    private AnchorPane acDetailPrice;
    @FXML
    private AnchorPane apPayment;
    @FXML
    private Text txtPassengerType;
    @FXML
    private Text txtSeatClassPayment;
    @FXML
    private Text textArrow;
    @FXML
    private Text textDetails;
    @FXML
    private Text textInfantChargeDomestic;
    @FXML
    private Text textTaxesFees;
    @FXML
    private Text textVAT;
    @FXML
    private Text txtgetPriceSeatClassPayment;
    @FXML
    private Text textAirportSecutity;
    @FXML
    private Text textColon;
    @FXML
    private Button btnBackPayMentToApToBooking;

    private List<BookingFlight> adultsAndChildren = new ArrayList<>();
    private Map<Integer, String> infantMap = new HashMap<>();
    private AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);

    private void paymentScene(List<BookingFlight> bookings, String airlineName, String origin, String destination, String flightNumber, 
            LocalTime arrivalTime, LocalTime departureTime, LocalDate flightDate, double totalPrice, double infantPrice) {
        // Clear previous detail prices
        acDetailPrice.getChildren().clear();
        AllFlightDAO dao = new AllFlightDAO();
        adultsAndChildren.clear();
        infantMap.clear();

        for (BookingFlight booking : bookings) {
            String passengerType = booking.getPassengerType();
            String fullName = booking.getFirstName() + " " + booking.getLastName();

            if ("Infant".equals(passengerType)) {
                infantMap.put(booking.getAccompanyingAdultId(), fullName);
            } else {
                adultsAndChildren.add(booking);
            }
        }
        txtGetFlightNumberPayment.setText(flightNumber);
        txtGetOriginPayment.setText(origin);
        txtGetDestinationPayment.setText(destination);
        txtGetDepartureTimePayment.setText(departureTime.toString());
        txtGetArrivalTimePayment.setText(arrivalTime.toString());
        txtGetAirlineNamePayment.setText(airlineName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = flightDate.format(formatter);
        dpGetDepartureDatePayment.setText(formattedDate);
        // Create and add AnchorPane for each passenger
        int yPosition = 0;
        totalAmount.set(0.0); // Reset total amount

        for (BookingFlight booking : adultsAndChildren) {
            AnchorPane newDetailPricePane = new AnchorPane();
            newDetailPricePane.setPrefSize(618, 666); // Đặt kích thước giống như trong FXML
            newDetailPricePane.setLayoutY(yPosition); // Sử dụng yPosition phù hợp

// Thiết lập các Text nodes
            Text txtPassengerType = new Text("Passenger Type");
            txtPassengerType.setLayoutX(6.0);
            txtPassengerType.setLayoutY(53.0);
            txtPassengerType.setFont(new Font(17));

            Text textColon = new Text(":");
            textColon.setLayoutX(131.0);
            textColon.setLayoutY(52.0);

            Text txtPaymentName = new Text(booking.getFirstName() + " " + booking.getLastName());
            txtPaymentName.setLayoutX(150.0);
            txtPaymentName.setLayoutY(52.0);
            txtPaymentName.setFont(new Font(11));

            Text txtDestinationPayment = new Text(destination);
            txtDestinationPayment.setLayoutX(155.0);
            txtDestinationPayment.setLayoutY(82.0);

            Text textArrow = new Text("-->");
            textArrow.setLayoutX(111.0);
            textArrow.setLayoutY(82.0);

            Text txtOriginPayment = new Text(origin);
            txtOriginPayment.setLayoutX(51.0);
            txtOriginPayment.setLayoutY(82.0);

            Text txtInfantName = new Text();
            txtInfantName.setLayoutX(264.0);
            txtInfantName.setLayoutY(52.0);
            txtInfantName.setFont(new Font(14));

            Text txtGetTotlPricePayment = new Text("Price");
            txtGetTotlPricePayment.setLayoutX(290.0);
            txtGetTotlPricePayment.setLayoutY(340.0);
            txtGetTotlPricePayment.setFont(new Font(18));

            Text txtSeatClassPayment = new Text(booking.getSeatClass());
            txtSeatClassPayment.setLayoutX(42.0);
            txtSeatClassPayment.setLayoutY(152.0);

            Text textDetails = new Text("Details");
            textDetails.setLayoutX(41.0);
            textDetails.setLayoutY(123.0);
            textDetails.setFont(new Font(20));

            Text textInfantChargeDomestic = new Text("Infant charge domestic");
            textInfantChargeDomestic.setLayoutX(45.0);
            textInfantChargeDomestic.setLayoutY(186.0);

            Text textTaxesFees = new Text("Taxes and Fees");
            textTaxesFees.setLayoutX(41.0);
            textTaxesFees.setLayoutY(228.0);
            textTaxesFees.setFont(new Font(19));

            Text textVAT = new Text("VAT");
            textVAT.setLayoutX(40.0);
            textVAT.setLayoutY(256.0);

            Text textAirportSecutity = new Text("Airport Security");
            textAirportSecutity.setLayoutX(40.0);
            textAirportSecutity.setLayoutY(289.0);

            Text txtgetPriceSeatClassPayment = new Text(String.format("%.2f", booking.getTotalPrice()));
            txtgetPriceSeatClassPayment.setLayoutX(242.0);
            txtgetPriceSeatClassPayment.setLayoutY(157.0);

            Text txtgetPriceInfant = new Text(String.format("%.2f", infantPrice));
            txtgetPriceInfant.setLayoutX(241.0);
            txtgetPriceInfant.setLayoutY(191.0);

            double VAT = 0.1;
            double vatAmount = booking.getTotalPrice() * VAT;
            Text txtVAT = new Text(String.format("%.2f", vatAmount));
            txtVAT.setLayoutX(241.0);
            txtVAT.setLayoutY(255.0);

            double airportSecurityFee = 20.00;
            Text txtAirportSecurityFee = new Text(String.format("%.2f", airportSecurityFee));
            txtAirportSecurityFee.setLayoutX(241.0);
            txtAirportSecurityFee.setLayoutY(289.0);

            double passengerTotalPrice = booking.getTotalPrice();
            if ("Adult".equals(booking.getPassengerType()) && infantMap.containsKey(booking.getPassengerId())) {
                passengerTotalPrice += infantPrice;
            }
            passengerTotalPrice += vatAmount + airportSecurityFee;

            // Use an AtomicReference to handle mutable totalAmount
            double finalPassengerTotalPrice = passengerTotalPrice;
            totalAmount.updateAndGet(v -> v + finalPassengerTotalPrice); // Update total amount

            newDetailPricePane.getChildren().addAll(txtPassengerType, textColon, txtPaymentName, txtDestinationPayment, textArrow, txtOriginPayment,
                    txtInfantName, txtGetTotlPricePayment, txtSeatClassPayment, textDetails, textInfantChargeDomestic,
                    textTaxesFees, textVAT, textAirportSecutity, txtgetPriceSeatClassPayment, txtgetPriceInfant, txtVAT, txtAirportSecurityFee);

            // Set data for the new AnchorPane
            String passengerType = booking.getPassengerType();
            String fullName = booking.getFirstName() + " " + booking.getLastName();

            txtPaymentName.setText(fullName);
            txtPassengerType.setText(passengerType);

            if ("Adult".equals(passengerType) && infantMap.containsKey(booking.getPassengerId())) {
                String infantName = infantMap.get(booking.getPassengerId());
                txtInfantName.setText(" + Infant: " + infantName);
                txtGetTotlPricePayment.setText(String.format("%.2f", booking.getTotalPrice() + infantPrice + vatAmount + airportSecurityFee));
                txtInfantName.setVisible(true);
                txtgetPriceInfant.setVisible(true);
                textInfantChargeDomestic.setVisible(true);
            } else {
                txtInfantName.setVisible(false);
                txtgetPriceInfant.setVisible(false);
                textInfantChargeDomestic.setVisible(false);
                txtgetPriceSeatClassPayment.setText(String.format("%.2f", booking.getTotalPrice()));
                txtGetTotlPricePayment.setText(String.format("%.2f", booking.getTotalPrice() + vatAmount + airportSecurityFee));
            }
            if ("Child".equals(passengerType)) {
                txtInfantName.setVisible(false);
                txtgetPriceInfant.setVisible(false);
                textInfantChargeDomestic.setVisible(false);
            }

            Button btnCancel = new Button("Cancel");
            btnCancel.setLayoutX(400.0);
            btnCancel.setLayoutY(320.0);
            btnCancel.setOnAction(event -> {
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirm Cancellation");
                confirmationAlert.setHeaderText("Cancel Booking");
                confirmationAlert.setContentText("Are you sure you want to cancel this booking?");

                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    try {
                        dao.updateBookingStatusToCancel(booking.getPassengerId());
                        System.out.println("Cancelled booking with ID: " + booking.getPassengerId());

                        // Update the total amount
                        double bookingTotal = booking.getTotalPrice() + vatAmount + airportSecurityFee;
                        totalAmount.updateAndGet(v -> v - bookingTotal);
                        txtTotal.setText(String.format("%.2f", totalAmount.get()));

                        // Remove the pane
                        acDetailPrice.getChildren().remove(newDetailPricePane);

                    } catch (SQLException e) {
                        showAlert("Error", "Cancellation Failed", "An error occurred while cancelling the booking. Please try again.");
                    }
                }
            });

            newDetailPricePane.getChildren().add(btnCancel);

            yPosition += 362; // Update yPosition for the next AnchorPane

            acDetailPrice.getChildren().add(newDetailPricePane);
        }

        Button btnCancelAll = new Button("Cancel All");
        btnCancelAll.setOnAction(this::btnHandleCancelAll);

        // Update total price field
        txtTotal.setText(String.format("%.2f", totalAmount.get()));

        apPayment.setVisible(true);
        apBooking.setVisible(false);
    }

    @FXML
    private void btnHandleCancelAll(ActionEvent event) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Cancellation");
        confirmAlert.setHeaderText("Are you sure you want to cancel all bookings?");
        confirmAlert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with cancellation
            try {
                AllFlightDAO dao = new AllFlightDAO();

                for (BookingFlight booking : adultsAndChildren) {
                    dao.updateBookingStatusToCancel(booking.getPassengerId());
                }

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Cancelled All");
                successAlert.setHeaderText("All Bookings Cancelled");
                successAlert.setContentText("All bookings have been cancelled.");
                successAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        acDetailPrice.getChildren().clear();
                        totalAmount.set(0.0);
                        txtTotal.setText(String.format("%.2f", totalAmount.get()));
                        adultsAndChildren.clear();
                        infantMap.clear();
                        apPayment.setVisible(false);
                        apTvFlight.setVisible(true);
                        maxSelectableSeats = 0;
                    }
                });
            } catch (SQLException e) {
                showAlert("Error", "Cancellation Failed", "An error occurred while cancelling all bookings. Please try again.");
            }
        }
    }

    @FXML
    private void btnHandlePayment(ActionEvent event ) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Cancellation");
        confirmAlert.setHeaderText("Are you sure you want to Payment all bookings?");
        confirmAlert.setContentText("This action cannot be undone.");
        if (comboBoxPayment.getValue() == null) {
            showAlert("Error", "Payment Method Required", "Please select a payment method.");
            return; // Dừng xử lý nếu không có phương thức thanh toán được chọn
        }
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, proceed with cancellation
            try {
                AllFlightDAO dao = new AllFlightDAO();

                for (BookingFlight booking : adultsAndChildren) {
                    dao.payment(booking.getPassengerId());
                }

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success Payment");
                successAlert.setHeaderText("All Bookings Payment");
                successAlert.setContentText("All bookings have been Payment.");
                successAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        // Xử lý thêm khi bấm OK (nếu cần)
                        acDetailPrice.getChildren().clear();
                        totalAmount.set(0.0);
                        txtTotal.setText(String.format("%.2f", totalAmount.get()));
                        adultsAndChildren.clear();
                        infantMap.clear();
                        apPayment.setVisible(false);
                        apTvFlight.setVisible(true);
                        maxSelectableSeats = 0;
                    }
                });
            } catch (SQLException e) {
                showAlert("Error", "Cancellation Failed", "An error occurred while payment all bookings. Please try again.");
            }
        }
    }

    @FXML
    private void btnHandlechangeAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(true);
        apTvFlight.setVisible(false);
        apButtonAllBooking.setVisible(true);
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

    private void setupSpinners() {
        // Thiết lập Spinner cho số lượng Adult
        spAdult.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1)); // Giá trị mặc định là 1, tối đa là 10
        spAdult.setEditable(true);

        // Thiết lập Spinner cho số lượng Child
        spChild.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0)); // Giá trị mặc định là 0, tối đa là 10
        spChild.setEditable(true);

        // Thiết lập Spinner cho số lượng Infant
        spInfant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, spAdult.getValue(), 0)); // Giá trị mặc định là 0, tối đa là giá trị của spAdult
        spInfant.setEditable(true);

        // Đảm bảo Spinner chỉ nhận giá trị số
        setupSpinnerConverter(spAdult);
        setupSpinnerConverter(spChild);
        setupSpinnerConverter(spInfant);
    }

    private int calculateTotalPassengers() {
        // Tính toán tổng số hành khách
        int adults = spAdult.getValue();
        int children = spChild.getValue();
        int infant = spInfant.getValue();
        return adults + children + infant; // Cập nhật cách tính tổng hành khách của bạn ở đây
    }

// Khi bạn thay đổi giá trị của Spinner, hãy cập nhật TextField mà không thay đổi trong listener
    private void updateTotal() {
        int totalPassenger = calculateTotalPassengers();
        // Đặt giá trị của TextField chỉ khi cần thiết để tránh vòng lặp
        if (!tTotal.getText().equals(String.valueOf(totalPassenger))) {
            tTotal.setText(String.valueOf(totalPassenger));
        }
    }

    private void updateInfantSpinner() {
        int maxInfant = spAdult.getValue(); // Mỗi Adult có thể có tối đa một Infant
        SpinnerValueFactory<Integer> valueFactory = spInfant.getValueFactory();

        if (valueFactory instanceof SpinnerValueFactory.IntegerSpinnerValueFactory) {
            SpinnerValueFactory.IntegerSpinnerValueFactory factory = (SpinnerValueFactory.IntegerSpinnerValueFactory) valueFactory;
            factory.setMax(maxInfant);
        }

        spInfant.getValueFactory().setValue(Math.min(spInfant.getValue(), maxInfant)); // Đảm bảo số lượng Infant không vượt quá số lượng Adult
    }

    private void updateMaxChildrenAndAdults() {
        int totalAdultsAndChildren = spAdult.getValue() + spChild.getValue();
        int maxAvailableForChildren = 10 - spAdult.getValue(); // Tổng Adult + Child không vượt quá 10

        SpinnerValueFactory<Integer> valueFactory = spChild.getValueFactory();

        if (valueFactory instanceof SpinnerValueFactory.IntegerSpinnerValueFactory) {
            SpinnerValueFactory.IntegerSpinnerValueFactory factory = (SpinnerValueFactory.IntegerSpinnerValueFactory) valueFactory;
            factory.setMax(maxAvailableForChildren);
        }

        if (totalAdultsAndChildren > 10) {
            spChild.getValueFactory().setValue(10 - spAdult.getValue());
        }
    }

    private void setupSpinnerConverter(Spinner<Integer> spinner) {
        spinner.getValueFactory().setConverter(new StringConverter<>() {
            @Override
            public String toString(Integer value) {
                return value.toString();
            }

            @Override
            public Integer fromString(String string) {
                try {
                    return Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    return spinner.getValue();
                }
            }
        });
    }

    @FXML
    private void btnHandleBackAllBooking(ActionEvent event) {
        apPassengerFlight.setVisible(false);
        apTvFlight.setVisible(true);
        apButtonAllBooking.setVisible(false);
    }

    @FXML
    private void btnHandleBackViewPassById(ActionEvent event) {
        apPassByFlight.setVisible(false);
        apTvFlight.setVisible(true);
    }

    private void btnHandleBack(ActionEvent event) {
        apTvFlight.setVisible(true);
        apAdd.setVisible(false);
        apToBooking.setVisible(false);
        clearInputFields();
    }

    @FXML
    private void btnHandleBackadAddToapTvFlight(ActionEvent event) {
        apTvFlight.setVisible(true);
        apAdd.setVisible(false);
        apToBooking.setVisible(false);
        clearInputFields();
    }

    @FXML
    private void btnHandleBackapToBookingtoapTvFlight(ActionEvent event) {
        apTvFlight.setVisible(true);
        apToBooking.setVisible(false);

    }

    @FXML
    private void btnHandleBackapBookingToapToBooking(ActionEvent event) {
        clearInputFields();
        apBooking.setVisible(false);
        apToBooking.setVisible(true);
        // Đặt maxSelectableSeats về 0 khi nhấn Back
        maxSelectableSeats = 0;
        txtgetPrice.setText("Total Price: 0.0");
        // Xóa các ghế đã chọn và đặt lại màu xanh cho tất cả các ghế trong GridPane
        selectedSeats.clear();
        for (Node node : gridPaneSelectSeats.getChildren()) {
            if (node instanceof Label) {
                Label seatLabel = (Label) node;
                String seatNumber = seatLabel.getText();
                if (!seatLabel.getStyle().contains("red")) {
                    seatLabel.setStyle("-fx-background-color: green; -fx-padding: 5; -fx-border-width: 1;");
                }
            }
        }
    }

    @FXML
    private void btnHandleBackPayMentToApToBooking(ActionEvent event) {
        apPayment.setVisible(false);
        apBooking.setVisible(true);
    }

    @FXML
    private void btnHandleRefundByFlightId(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        // Lấy booking đã chọn
        BookingFlight selectedBooking = tvPassengerById.getSelectionModel().getSelectedItem();

        if (selectedBooking == null) {
            // Hiển thị thông báo nếu không có booking nào được chọn
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn một booking để hủy.");
            alert.showAndWait();
            return;
        }

        // Lấy seat_id của booking đã chọn
        int seatId = selectedBooking.getSeatId();

        // Hiển thị hộp thoại xác nhận
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText("Bạn có chắc chắn muốn hủy booking này không?");
        alert.setContentText("Hành động này sẽ hủy luôn booking của Infant đi kèm và không thể khôi phục.");

        // Xử lý kết quả từ hộp thoại xác nhận
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    // Lấy danh sách infants đi kèm
                    List<BookingFlight> infants = dao.getInfantsBySeatId(seatId);

                    // Xóa tất cả các Infant liên quan từ TableView
                    for (BookingFlight infant : infants) {
                        tvPassengerById.getItems().removeIf(b -> b.getPassengerId() == infant.getPassengerId());
                    }

                    // Xóa booking của Adult từ TableView
                    tvPassengerById.getItems().removeIf(b -> b.getSeatId() == seatId);

                    // Xóa tất cả các Infant liên quan từ cơ sở dữ liệu
                    for (BookingFlight infant : infants) {
                        dao.Refund(infant.getSeatId());
                    }

                    // Xóa booking của Adult từ cơ sở dữ liệu
                    dao.Refund(seatId);

                    // Hiển thị thông báo thành công
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Thông báo");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Booking đã được hủy thành công.");
                    successAlert.showAndWait();
                    apPassByFlight.setVisible(true);
                    apPassRefund.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Nếu người dùng không xác nhận, không làm gì cả

            }
        });
    }

    @FXML
    private Text txtNameRefund;
    @FXML
    private Text txtDOBRefund;
    @FXML
    private Text txtGenderRefund;
    @FXML
    private Text txtSeatClassRefund;
    @FXML
    private Text txtSeatNumberRefund;
    @FXML
    private Text txtPassengerTpeRefund1;
    @FXML
    private Text txtPassportIdPassengerRefund;
    @FXML
    private Text txtAirlineNameRefund;
    @FXML
    private Text txtFlightNumberRefund;
    @FXML
    private Text txtFlightDateRefund;
    @FXML
    private Text txtTimeFlightRefund;
    @FXML
    private GridPane gridpaneInfantRefund;
    @FXML
    private Text txtInfantNameRefund;
    @FXML
    private Text txtInfantDOBRefund;
    @FXML
    private Text txtInfantGenderRefund;
    @FXML
    private Text txtPassengerTpeRefund;
    @FXML
    private Text txtPassportIdInfantRefund;
    @FXML
    private Text txtPriceRefund;

    @FXML
    private void btnHandleDetailPass(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        BookingFlight selectedBooking = tvPassengerById.getSelectionModel().getSelectedItem();

        if (selectedBooking == null) {
            showAlert("Alert", "Please select a booking to view details.");
            return;
        }

        // Hiển thị pane chứa thông tin hoàn tiền
        apPassRefund.setVisible(true);
        apPassByFlight.setVisible(false);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        if ("Infant".equals(selectedBooking.getPassengerType())) {
            showInfantDetails(selectedBooking, formatter);
            BookingFlight adult = dao.getAdultByInfantId(selectedBooking.getPassengerId());
            if (adult != null) {
                showAdultDetails(adult, formatter);
                // Gọi calculateRefundPrice() cho người lớn đi kèm
                calculateRefundPrice(adult.getBookingDateTime(), adult.getFlightDate().atTime(adult.getDepartureTime()), adult.getSeatClass());
            } else {
                gridpaneInfantRefund.setVisible(false);
            }
        } else {
            showAdultDetails(selectedBooking, formatter);
            // Gọi calculateRefundPrice() cho người lớn được chọn
            calculateRefundPrice(selectedBooking.getBookingDateTime(), selectedBooking.getFlightDate().atTime(selectedBooking.getDepartureTime()), selectedBooking.getSeatClass());
            List<BookingFlight> infants = dao.getInfantsByAdultId(selectedBooking.getPassengerId());
            if (!infants.isEmpty()) {
                showInfantDetails(infants.get(0), formatter);
            } else {
                gridpaneInfantRefund.setVisible(false);
            }
        }
    }

    private void showInfantDetails(BookingFlight infant, DateTimeFormatter formatter) {
        gridpaneInfantRefund.setVisible(true);
        txtInfantNameRefund.setText(infant.getFirstName() + " " + infant.getLastName());
        txtInfantDOBRefund.setText(infant.getDOB().format(formatter));
        txtInfantGenderRefund.setText(infant.getGender());
        txtPassengerTpeRefund.setText("Infant");
        txtPassportIdInfantRefund.setText(infant.getPassportId());
    }

    private void showAdultDetails(BookingFlight adult, DateTimeFormatter formatter) {
        txtNameRefund.setText(adult.getFirstName() + " " + adult.getLastName());
        txtDOBRefund.setText(adult.getDOB().format(formatter));
        txtGenderRefund.setText(adult.getGender());
        txtSeatClassRefund.setText(adult.getSeatClass());
        txtSeatNumberRefund.setText(adult.getSeatNumber());
        txtPassengerTpeRefund1.setText(adult.getPassengerType());
        txtPassportIdPassengerRefund.setText(adult.getPassportId());
        txtAirlineNameRefund.setText(adult.getAirlineName());
        txtFlightNumberRefund.setText(adult.getFlightNumber());
        LocalDate flightDate = adult.getFlightDate();
        String formattedDate = flightDate.format(formatter);
        txtFlightDateRefund.setText(formattedDate);
        txtTimeFlightRefund.setText(adult.getDepartureTime() + "-->" + adult.getArrivalTime());
    }

    private void calculateRefundPrice(LocalDateTime bookingDateTime, LocalDateTime flightDateTime, String seatClass) {
        // Lấy thời gian hiện tại
        LocalDateTime now = LocalDateTime.now();

        // Tính số giờ còn lại trước giờ bay
        long hoursBeforeFlight = Duration.between(now, flightDateTime).toHours();

        // Khai báo phí hoàn tiền
        double refundPrice = 0.0;

        // Xác định phí hoàn tiền dựa vào thời gian hoàn tiền và loại ghế
        if (hoursBeforeFlight > 24) {
            // Hoàn tiền trước 24 giờ
            switch (seatClass) {
                case "Economy":
                    refundPrice = 20.0;
                    break;
                case "Business":
                    refundPrice = 15.0;
                    break;
                case "FirstClass":
                    refundPrice = 0.0;
                    break;
            }
        } else if (hoursBeforeFlight <= 3) {
            // Không cho hoàn tiền nếu trước 3 giờ
            refundPrice = 0.0;
        } else {
            // Hoàn tiền trước 3 giờ nhưng không thuộc các điều kiện trên
            refundPrice = 0.0;
        }

        // Hiển thị phí hoàn tiền
        txtPriceRefund.setText(String.format("Refund fee: %.2f", refundPrice));
    }

    @FXML
    private void btnHandlePassRefundToPassByFlight(ActionEvent event) {
        apPassRefund.setVisible(false);
        apPassByFlight.setVisible(true);
    }

}
