/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author trums
 */
public class Infants {
    private int infantId;
    private int passengerId;
    private int accompanyingAdultId;

    public Infants(int infantId, int passengerId, int accompanyingAdultId) {
        this.infantId = infantId;
        this.passengerId = passengerId;
        this.accompanyingAdultId = accompanyingAdultId;
    }

    public Infants() {
    }

    public int getInfantId() {
        return infantId;
    }

    public void setInfantId(int infantId) {
        this.infantId = infantId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getAccompanyingAdultId() {
        return accompanyingAdultId;
    }

    public void setAccompanyingAdultId(int accompanyingAdultId) {
        this.accompanyingAdultId = accompanyingAdultId;
    }
    
    
    
}
