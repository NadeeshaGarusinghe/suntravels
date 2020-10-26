package com.Codegen.suntravels.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/*
* this is the class for Contract. This will create a table named "contract" in the mysql database
*
*
* */
@Entity                                       //specifies that the class is an entity and is mapped to a database table
@Table(name="contract")                        //that database table name is "contract"
@Getter                                        //generate getters for private fields
@Setter                                        ////generate setters for private fields
@NoArgsConstructor                              //generate a constructor with no parameters
@AllArgsConstructor                               //generates a constructor with 1 parameter for each field in the class
@ToString                                          //generates the toString method automatically. By default, Lombok uses all non-static fields in the implementation of toString
public class Contract {

    @Id                                           // indicate the cid field is the primary key of contract entity
    @GeneratedValue                               //automatically assign values to cid
    private int cid;
    private int hid;
    private Date startdate;
    private Date enddate;
    @Column(columnDefinition = "Double default 15.00")                         //set the default value for markup
    private double markup=15;
    @OneToMany(targetEntity = RoomDetails.class,cascade = CascadeType.ALL)          //onetomany relationship
    @JoinColumn(name = "cid",referencedColumnName = "cid")                            //indicate the contract is the owner of this relationship
    private List<RoomDetails> roomDetails;


    //getters and setters
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

    //public List<Contract> findMarkupedValue(String checkindate,int noofnights,int noofroomwithadults) {
       // for (int i=0;i<2;i++){


        //}
  //  }

}
