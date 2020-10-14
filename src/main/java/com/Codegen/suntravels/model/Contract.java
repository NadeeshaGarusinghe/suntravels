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



}
