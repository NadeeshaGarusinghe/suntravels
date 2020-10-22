package com.Codegen.suntravels.model;

import lombok.*;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomDetails {
    @Id
    @GeneratedValue
    private int rdetailsid;
    private double rprice;
    private int maxadults;
    private int availablerooms;
    private int rtypeid;

    public int getRdetailsid() {
        return rdetailsid;
    }

    public void setRdetailsid(int rdetailsid) {
        this.rdetailsid = rdetailsid;
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

    public int getRtypeid() {
        return rtypeid;
    }

    public void setRtypeid(int rtypeid) {
        this.rtypeid = rtypeid;
    }
}
