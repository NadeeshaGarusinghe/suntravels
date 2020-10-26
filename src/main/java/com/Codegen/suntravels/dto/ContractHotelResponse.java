package com.Codegen.suntravels.dto;

import com.Codegen.suntravels.model.Contract;
import lombok.*;
import java.util.ArrayList;

/*
* this is like a summary of what should be displayed when the user request for view original
* contracts
* */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractHotelResponse {
    private Contract contract;
    private String hotelName;
    ArrayList<String> roomTypes;
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<String> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(ArrayList<String> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

