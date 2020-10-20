package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.HotelDao;
import com.Codegen.suntravels.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController                     //mapping request data to the defined request handler method.
//@RequestMapping("/suntravels")      //maps the specific request path onto a controller
public class HotelController {

    @Autowired              //automatically assign the properties with the reference
    private HotelDao hotelDao;


    @PostMapping("/addHotel")           //to add a hotel details to the system
    public String addHotel(@RequestBody Hotel hotel){

        hotelDao.save(hotel);
        return "saved the hotel details ";
    }
    @GetMapping("/getHotels")             //to view all the hotels in the system
    public List<Hotel> getHotels(){
        return (List<Hotel>) hotelDao.findAll();
    }
}
