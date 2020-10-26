package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.HotelDao;
import com.Codegen.suntravels.dao.RoomTypeDao;
import com.Codegen.suntravels.model.Hotel;
import com.Codegen.suntravels.model.Location;
import com.Codegen.suntravels.model.RoomType;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomTypeController.class)
class RoomTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RoomTypeDao roomTypeDao;


    @Test
    public void addRoomTypeTest() throws  Exception{
        RoomType roomType=new RoomType();
        roomType.setRtypeid(1);
        roomType.setRoomtype("Cabana");


        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(roomType);
        when(roomTypeDao.save(roomType)).thenReturn(roomType);

        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/addRoomType")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("roomType is added to the system Successfully",contentAsString);
    }



    @Test
    public void getRoomTypesTest() throws Exception{
        List<RoomType> roomTypeList=new ArrayList<>();
        RoomType roomType=new RoomType();
        roomType.setRtypeid(1);
        roomType.setRoomtype("cabana");
        roomTypeList.add(0,roomType);
        when(roomTypeDao.findAll()).thenReturn(roomTypeList);
        MvcResult mvcResult =mockMvc.perform(get("/getRoomTypes")).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("[{\"rtypeid\":1,\"roomtype\":\"cabana\"}]",contentAsString);
    }

}