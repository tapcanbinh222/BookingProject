package Modal;

public class Seats {

    private int seatId;
    private int aicraftTypeId;
    private String seatNumber;
    private boolean isAvailable;

    public Seats() {}

    public Seats(int seatId, int aicraftTypeId, String seatNumber, boolean isAvailable) {
        this.seatId = seatId;
        this.aicraftTypeId = aicraftTypeId;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }



   
 public boolean getIsAvailable() { // Phương thức getter cho isAvailable
        return isAvailable;
    }

    public void setIsAvailable(boolean available) { // Phương thức setter cho isAvailable
        this.isAvailable = available;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getAicraftTypeId() {
        return aicraftTypeId;
    }

    public void setAicraftTypeId(int aicraftTypeId) {
        this.aicraftTypeId = aicraftTypeId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

  
   

    
}
