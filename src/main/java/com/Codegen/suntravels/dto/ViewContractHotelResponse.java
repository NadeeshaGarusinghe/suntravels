package com.Codegen.suntravels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.awt.*;
import java.sql.Date;

/*
* In the database, there is no direct relationship between hotel and contract tables. So when we need to get the hotel data for a parlicular
* contract, we need to do an explicit join. so, when that join done, need a model to return the joined result. for that I used this class.
* */

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
