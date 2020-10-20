package com.Codegen.suntravels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewContractHotelResponse {
    private String name;
    private int cid;
    private Date startdate;
    private Date enddate;
    private double markup;
    private int locationid;
    private String phone;



}
