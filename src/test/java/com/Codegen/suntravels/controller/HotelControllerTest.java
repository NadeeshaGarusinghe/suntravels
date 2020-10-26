package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.HotelDao;
import com.Codegen.suntravels.model.Hotel;
import com.Codegen.suntravels.model.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelController.class)
class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HotelDao hotelDao;

    @Test
    public void getHotelsShouldReturnListOfHotels() throws Exception{
        List<Hotel> hotelList=new ArrayList<>();
        Hotel hotel=new Hotel();
        Location location=new Location();
        location.setLocaionid(1);
        location.setParent("Colombo");
        location.setParent("no:20,Drarmapala Mawatha");
        hotel.setHid(1);
        hotel.setLocation(location);
        hotel.setName("Galadhari");
        hotel.setPhone("09999999999");
        hotelList.add(0,hotel);
        when(hotelDao.findAll()).thenReturn(hotelList);
        MvcResult mvcResult =mockMvc.perform(get("/getHotels")).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("[{\"hid\":1,\"name\":\"Galadhari\",\"phone\":\"09999999999\",\"location\":{\"locaionid\":1,\"parent\":\"no:20,Drarmapala Mawatha\",\"child\":null}}]",contentAsString);
    }

    @Test
    public void addHotelTest() throws  Exception{
        Hotel hotel=new Hotel();
        hotel.setPhone("0770098987");
        hotel.setName("hilton");
        hotel.setHid(1);
        Location location=new Location();
        location.setParent("Colombo");
        location.setLocaionid(1);
        location.setChild("Dharmapala Mawatha");
        hotel.setLocation(location);

        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(hotel);
        when(hotelDao.save(hotel)).thenReturn(hotel);

        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/addHotel")
        .contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("saved the hotel details ",contentAsString);
    }



}