package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.dao.RoomDetailsDao;
import com.Codegen.suntravels.dto.InsertRequest;
import com.Codegen.suntravels.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/suntravels")
public class InsertController {
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private RoomDetailsDao roomDetailsDao;

    @PostMapping("/insertRoomDetails")
    public Contract storeRoomDetais(@RequestBody InsertRequest request){
        return contractDao.save(request.getContract());
    }
   // @GetMapping("/getInfo")
    //public List<MarkedupContract> findAllContracts(){
     //   return contractDao.getJoinInformation();
   // }


}
