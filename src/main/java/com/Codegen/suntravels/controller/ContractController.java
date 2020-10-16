package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.model.Contract;
import com.Codegen.suntravels.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                     //mapping request data to the defined request handler method.
@RequestMapping("/suntravels")
public class ContractController {
    @Autowired              //automatically assign the properties with the reference
    private ContractDao contractDao;

    @PostMapping("/addContract")     //to add contracts to the system
    @CrossOrigin(origins = "*")
    public String addContract(@RequestBody Contract contract){
        contractDao.save(contract);
        return "Contract is added to the system Successfully";
    }

    @GetMapping("/getContracts")    //to view the all contracts
    public List<Contract> getContracts(){
        return (List<Contract>) contractDao.findAll();
    }

}
