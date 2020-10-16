package com.Codegen.suntravels.controller;
import com.Codegen.suntravels.dao.RoomTypeDao;
import com.Codegen.suntravels.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                     //mapping request data to the defined request handler method.
@RequestMapping("/suntravels")
public class RoomTypeController {

    @Autowired              //automatically assign the properties with the reference
    private RoomTypeDao roomTypeDao;


    @PostMapping("/addRoomType")     //to add contracts to the system
    @CrossOrigin(origins = "*")
    public String addContract(@RequestBody RoomType roomType){
        roomTypeDao.save(roomType);
        return "roomType is added to the system Successfully";
    }

    @GetMapping("/getRoomTypes")    //to view the all contracts
    public List<RoomType> getContracts(){
        return (List<RoomType>) roomTypeDao.findAll();
    }
}