package com.Codegen.suntravels.dto;

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
