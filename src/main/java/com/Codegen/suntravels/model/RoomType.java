package com.Codegen.suntravels.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomType {
    @Id
    @GeneratedValue
    private int rid;
    private String rtype;
    private String rprice;
    private String maxadults;
    private String noofrooms;


}
