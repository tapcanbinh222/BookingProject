package Modal;

public class Seats {

    private int seatId;
    private int aicraftTypeID;
    private String seatNumber;
    private boolean isAvailable;

    public Seats() {}

    public Seats(int seatId, int aicraftTypeID, String seatNumber, boolean isAvailable) {
        this.seatId = seatId;
        this.aicraftTypeID = aicraftTypeID;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }



   
 public boolean getIsAvailable() { // Phương thức getter cho isAvailable
        return isAvailable;
    }

    public void setIsAvailable(boolean available) { // Phương thức setter cho isAvailable
        isAvailable = available;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getAicraftTypeID() {
        return aicraftTypeID;
    }

    public void setAicraftTypeID(int aicraftTypeID) {
        this.aicraftTypeID = aicraftTypeID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

  
   

    
}
