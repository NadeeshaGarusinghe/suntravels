package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.dto.ContractHotelResponse;
import com.Codegen.suntravels.dto.MarkedupContractResponse;
import com.Codegen.suntravels.model.Contract;
import com.Codegen.suntravels.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


/*
* this is used to control the data flow into the Contract model object.
* when client makes an HTTP request related to contracts,
* that requests come to this controller and this controller map it and handle the request.
* it calls QueryService class if required.
* in the QueryService class, all the business logic performs.
* it perform the logic on the contract data.
* */

@RestController                     //mapping request data to the defined request handler method.
//@RequestMapping("/suntravels")
public class ContractController {

    @Autowired
    QueryService queryService;

    @Autowired              //automatically assign the properties with the reference
    private ContractDao contractDao;


    @PostMapping("/addContract")     //to add contracts to the system
    @CrossOrigin(origins = "*")
    public String addContract(@RequestBody Contract contract){
        contractDao.save(contract);
        return "Contract is added to the system Successfully!";
    }

    //@GetMapping("/searchResults")
    @RequestMapping(value="/searchResults",method = RequestMethod.GET,params={"checkindate","noofnights","noofroomswithadults"})
    public List<MarkedupContractResponse> searchResults(Date checkindate, int noofnights, int[] noofroomswithadults){
        return queryService.ContractHotelRoomDetailsExplicitJoin(checkindate, noofnights, noofroomswithadults);
    }

    @GetMapping("/getOriginalContracts")
    public List<ContractHotelResponse> getOriginalContracts(){
        List<ContractHotelResponse> contractHotel = new ArrayList<>();
        List<Contract> contracts=contractDao.findAll();
        for (Contract c:contracts){
            ArrayList<String> roomTypes=new ArrayList<>();
            ContractHotelResponse temp=new ContractHotelResponse();
            temp.setContract(c);
            for (int i=0;i<c.getRoomDetails().size();i++){
                String roomType=queryService.getRoomTypes(c.getRoomDetails().get(i).getRtypeid());
                roomTypes.add(i,roomType);
            }
            temp.setRoomTypes(roomTypes);
            String hotelName=queryService.getHotelName(c.getHid(),c.getCid());
            temp.setHotelName(hotelName);
            contractHotel.add(temp);
        }
        return  contractHotel;
    }
}
