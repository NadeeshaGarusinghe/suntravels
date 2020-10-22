package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dto.ContractResponse;
import com.Codegen.suntravels.dto.MarkedupContractResponse;
import com.Codegen.suntravels.dto.ViewContractHotelResponse;
import com.Codegen.suntravels.dto.ViewContractRoomTypeRespose;
import com.Codegen.suntravels.model.Contract;
import com.Codegen.suntravels.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QueryController {

    @Autowired
    QueryService queryService;

    @GetMapping("/joinQuery1")
    public List<ViewContractHotelResponse> getQuery1(){
        return queryService.HotelContractExplicitJoin();
    }

    @GetMapping("/joinQuery2")
    public List<ViewContractRoomTypeRespose> getQuery2(){
        return queryService.ContractRoomTypeImplicitJoin();
    }

    //@GetMapping("/joinQuery3")
    @RequestMapping(value="/joinQuery3",method = RequestMethod.GET,params={"checkindate","noofnights","noofroomswithadults"})
    public List<MarkedupContractResponse> getQuery3(Date checkindate, int noofnights, int[] noofroomswithadults){
        return queryService.CHCRExplicitJoin(checkindate, noofnights, noofroomswithadults);
    }

    @GetMapping("/contractData")
    public List<Contract> getStudentData()
    {
        return queryService.contractAllData();

    }


}
