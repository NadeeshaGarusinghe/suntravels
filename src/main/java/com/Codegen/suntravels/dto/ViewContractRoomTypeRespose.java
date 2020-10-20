package com.Codegen.suntravels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewContractRoomTypeRespose {
    private int cid;
    private double markup;
    private Date startdate;
    private Date enddate;
    private double rprice;
    private int maxadults;
    private int availablerooms;
}
