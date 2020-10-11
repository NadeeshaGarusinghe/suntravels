package com.Codegen.suntravels.dto;

import com.Codegen.suntravels.model.Contract;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InsertRequest {

    private Contract contract;


    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}


