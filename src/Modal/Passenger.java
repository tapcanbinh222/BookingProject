package Modal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passenger {

    private int passengerId;         // Thay đổi tên biến để phù hợp với Java naming conventions
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String gender;
    private String passportId;
    private String nationality;

    // Constructors
    public Passenger() {
    }

    public Passenger(int passengerId, String firstName, String lastName, LocalDate DOB, String gender, String passportId, String nationality) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.gender = gender;
        this.passportId = passportId;
        this.nationality = nationality;
    }

    // Getter và setter cho các trường dữ liệu
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFormattedFlightDate() {
        return DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


}
