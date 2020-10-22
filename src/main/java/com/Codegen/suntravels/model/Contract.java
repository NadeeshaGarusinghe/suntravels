package com.Codegen.suntravels.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contract {

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
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

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }

    @Id
    @GeneratedValue
    private int cid;
    private int hid;
    private Date startdate;
    private Date enddate;
    @Column(columnDefinition = "Double default 15.00")
    private double markup=15;
    @OneToMany(targetEntity = RoomDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cid",referencedColumnName = "cid")
    private List<RoomDetails> roomDetails;

    //public List<Contract> findMarkupedValue(String checkindate,int noofnights,int noofroomwithadults) {
       // for (int i=0;i<2;i++){


        //}
  //  }

}
