package com.Codegen.suntravels.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomType {

    @Id
    @GeneratedValue
    private int rtypeid;
    private String roomtype;
}