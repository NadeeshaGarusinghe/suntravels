package com.Codegen.suntravels.dto;

/**
 * this class is used as a summery of returning the contracts with the calculated markups. In the Query service class the logic for calculate the
 * markups are done and to return only the  necessary prepared data to the user, used this model
 */



public class MarkedupContractResponse {
    private String name;
    private String roomtype;
    private double markedupprice;
    private boolean availabilitystatus;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public double getMarkedupprice() {
        return markedupprice;
    }

    public void setMarkedupprice(double markedupprice) {
        this.markedupprice = markedupprice;
    }

    public boolean isAvailabilitystatus() {
        return availabilitystatus;
    }

    public void setAvailabilitystatus(boolean availabilitystatus) {
        this.availabilitystatus = availabilitystatus;
    }
}
