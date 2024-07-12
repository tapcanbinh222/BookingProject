/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author trums
 */
public class AircraftTypes {

    private int aircraftTypeId;
    private String aircraftTypeName;
    private int economy_seats;
    private int premium_economy_seats;
    private int business_seats;

    public int getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(int aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public String getAircraftTypeName() {
        return aircraftTypeName;
    }

    public void setAircraftTypeName(String aircraftTypeName) {
        this.aircraftTypeName = aircraftTypeName;
    }


    public int getEconomy_seats() {
        return economy_seats;
    }

    public void setEconomy_seats(int economy_seats) {
        this.economy_seats = economy_seats;
    }

    public int getPremium_economy_seats() {
        return premium_economy_seats;
    }

    public void setPremium_economy_seats(int premium_economy_seats) {
        this.premium_economy_seats = premium_economy_seats;
    }

    public int getBusiness_seats() {
        return business_seats;
    }

    public void setBusiness_seats(int business_seats) {
        this.business_seats = business_seats;
    }


}
