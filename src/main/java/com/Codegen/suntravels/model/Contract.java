package com.Codegen.suntravels.model;

import lombok.*;

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
    @OneToMany(targetEntity = RoomType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cid",referencedColumnName = "cid")
    private List<RoomType> roomtypes;



}
