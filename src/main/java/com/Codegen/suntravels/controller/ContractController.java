package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.dto.ContractHotelResponse;
import com.Codegen.suntravels.dto.ContractResponse;
import com.Codegen.suntravels.model.Contract;
import com.Codegen.suntravels.model.Hotel;
import com.Codegen.suntravels.model.RoomDetails;
import com.Codegen.suntravels.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return "Contract is added to the system Successfully";
    }

    @GetMapping("/getContracts}")    //to view the all contracts
    public List<Contract> getContracts(){
        return (List<Contract>) contractDao.findAll();
    }
   @RequestMapping(value="/findContracts",method = RequestMethod.GET,params={"checkindate","noofnights","noofroomswithadults"})
    public  List<Contract> findContracts(String checkindate,int noofnights,int noofroomswithadults){
       return (List<Contract>) contractDao.findAll();

   }

    @GetMapping("/getOriginalContracts")
    public List<ContractHotelResponse> getOriginalContracts(){
        List<ContractHotelResponse> ch = new ArrayList<>();
        List<Contract> i=contractDao.findAll();
        for (Contract c:i){
            //String[] roomTypes=new String[10];
            ArrayList<String> roomTypes=new ArrayList<>();
            ContractHotelResponse temp=new ContractHotelResponse();
            temp.setContract(c);
            for (int j=0;j<c.getRoomDetails().size();j++){
                String k=queryService.getRoomTypes(c.getRoomDetails().get(j).getRtypeid());
                roomTypes.add(j,k);
            }
            temp.setRoomTypes(roomTypes);
            String hotelName=queryService.getHotelName(c.getHid(),c.getCid());
            temp.setHotelName(hotelName);
            ch.add(temp);
        }
        return  ch;


    }



}
