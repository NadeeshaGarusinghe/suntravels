package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractDao extends JpaRepository<Contract,Integer> {
    @Override
    List<Contract> findAll();

    //@Query("SELECT new com.Codegen.suntravels.dto.MarkedupContract(c.markup, r.rprice) FROM Contract c JOIN c.roomDetails r")
    //public List<MarkedupContract> getJoinInformation();

    //@Query("SELECT new com.Codegen.suntravels.dto.ViewContractResponse(c.markup, c.startdate,c.enddate,c.roomDetails,h.name) FROM Contract c JOIN c.hotel h")
    //public List<ViewContractRespose> getJoinInformation();

}
