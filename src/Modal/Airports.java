package Modal;

public class Airports {
    private String airportCode;     // Tên biến được sửa thành airportCode
    private String airportName;
    private String city;
    private String country;

    // Constructor đầy đủ tham số
    public Airports(String airportCode, String airportName, String city, String country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    // Constructor mặc định (default), thường dùng khi lấy dữ liệu từ database
    public Airports() {
    }
  
    // Getter cho airportCode
    public String getAirportCode() {
        return airportCode;
    }

    // Setter cho airportCode
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    // Getter cho airportName
    public String getAirportName() {
        return airportName;
    }

    // Setter cho airportName
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    // Getter cho city
    public String getCity() {
        return city;
    }

    // Setter cho city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter cho country
    public String getCountry() {
        return country;
    }

    // Setter cho country
    public void setCountry(String country) {
        this.country = country;
    }

    // Override phương thức toString() để hiển thị thông tin của đối tượng Airports
    @Override
    public String toString() {
        return "Airports{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
