/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author trums
 */
public class FlightPrices {

    private int flightPriceId;
    private int flightId;
    private double economyPrice;
    private double businessPrice;
    private double firstClassPrice;

    public FlightPrices() {
    }

    public FlightPrices(int flightPriceId, int flightId, double economyPrice, double businessPrice, double firstClassPrice) {
        this.flightPriceId = flightPriceId;
        this.flightId = flightId;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }

    public int getFlightPriceId() {
        return flightPriceId;
    }

    public void setFlightPriceId(int flightPriceId) {
        this.flightPriceId = flightPriceId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

   
    
    
}
