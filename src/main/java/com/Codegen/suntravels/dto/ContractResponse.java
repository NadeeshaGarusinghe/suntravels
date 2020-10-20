package com.Codegen.suntravels.dto;

import com.Codegen.suntravels.model.Location;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractResponse {
    private int cid;
    private double markup;
    private Date startdate;
    private Date enddate;
    private double rprice;
    private int maxadults;
    private int availablerooms;
    private int rtyeid;
    private String name;
    private String phone;
    private Location location;
    private String roomtype;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public int getMaxadults() {
        return maxadults;
    }

    public void setMaxadults(int maxadults) {
        this.maxadults = maxadults;
    }

    public int getAvailablerooms() {
        return availablerooms;
    }

    public void setAvailablerooms(int availablerooms) {
        this.availablerooms = availablerooms;
    }

    public int getRtyeid() {
        return rtyeid;
    }

    public void setRtyeid(int rtyeid) {
        this.rtyeid = rtyeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
}
