package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.HotelDao;
import com.Codegen.suntravels.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController                     //mapping request data to the defined request handler method.
@RequestMapping("/suntravels")      //maps the specific request path onto a controller
public class HotelController {

    @Autowired              //automatically assign the properties with the reference
    private HotelDao hotelDao;

    @PostMapping("/addHotel")
    public String bookTicket(@RequestBody List<Hotel> hotel){
        hotelDao.saveAll(hotel);
        return "saved the hotel details ";
    }

    @GetMapping("/getHotel")
    public boolean getHotel(Hotel hotel){
        return  hotelDao.equals(hotel);
    }
}
