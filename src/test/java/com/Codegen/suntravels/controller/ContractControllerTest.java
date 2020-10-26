package com.Codegen.suntravels.controller;

import com.Codegen.suntravels.dao.ContractDao;
import com.Codegen.suntravels.dto.ContractHotelResponse;
import com.Codegen.suntravels.dto.MarkedupContractResponse;
import com.Codegen.suntravels.model.Contract;
import com.Codegen.suntravels.model.Hotel;
import com.Codegen.suntravels.model.RoomDetails;
import com.Codegen.suntravels.services.QueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContractController.class)
class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContractDao contractDao;

    @MockBean
    private QueryService queryService;

    Contract contract=new Contract();


    @BeforeEach
    public  void createContractList(){
        RoomDetails roomDetail=new RoomDetails();
        roomDetail.setAvailablerooms(2);
        roomDetail.setMaxadults(3);
        roomDetail.setRprice(30);
        roomDetail.setRtypeid(1);
        List<RoomDetails> roomDetails=new ArrayList<>();
        roomDetails.add(roomDetail);
        contract.setHid(1);
        contract.setMarkup(30);
        contract.setStartdate(new Date(2020-10-10));
        contract.setEnddate(new Date(2020-12-30));
        contract.setRoomDetails(roomDetails);
    }


    @Test
    public void addContractTest() throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(contract);
        when(contractDao.save(contract)).thenReturn(contract);
        MvcResult mvcResult =mockMvc.perform(post("/addContract").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andReturn();

        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("Contract is added to the system Successfully!",contentAsString);
    }


    @Test
    public void getOriginalContractsTest() throws Exception{
        List<ContractHotelResponse> contractHotelResponses=new ArrayList<ContractHotelResponse>();
        ContractHotelResponse contractHotelResponse=new ContractHotelResponse();
        String hotelName="Galadhari";
        ArrayList<String> roomTypes=new ArrayList<>();
        roomTypes.add(0,"Standard");
        contractHotelResponse.setContract(contract);
        contractHotelResponse.setHotelName(hotelName);
        contractHotelResponse.setRoomTypes(roomTypes);
        contractHotelResponses.add(0,contractHotelResponse);
        System.out.println(contractHotelResponses);
        MvcResult mvcResult =mockMvc.perform(get("/getOriginalContracts")).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("[]",contentAsString);
    }


    @Test
    public void getOriginalContractsTest1() throws Exception{
        List<Contract> contractList=new ArrayList<>();
        List<ContractHotelResponse> contractHotelResponses=new ArrayList<ContractHotelResponse>();
        ContractHotelResponse contractHotelResponse=new ContractHotelResponse();
        contractList.add(contract);
        when(contractDao.findAll()).thenReturn(contractList);
        String hotelName="Galadhari";
        ArrayList<String> roomTypes=new ArrayList<>();
        roomTypes.add(0,"Standard");
        contractHotelResponse.setContract(contract);
        contractHotelResponse.setHotelName(hotelName);
        contractHotelResponse.setRoomTypes(roomTypes);
        System.out.println(contractHotelResponse);
        contractHotelResponses.add(0,contractHotelResponse);
        MvcResult mvcResult =mockMvc.perform(get("/getOriginalContracts")).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("[{\"contract\":{\"cid\":0,\"hid\":1,\"startdate\":\"1970-01-01T00:00:02.000+00:00\",\"enddate\":\"1970-01-01T00:00:01.978+00:00\",\"markup\":30.0,\"roomDetails\":[{\"rdetailsid\":0,\"rprice\":30.0,\"maxadults\":3,\"availablerooms\":2,\"rtypeid\":1}]},\"hotelName\":null,\"roomTypes\":[null]}]",contentAsString);
    }

    /*@Test
    public void SearchResultsTest() throws Exception {
        List<MarkedupContractResponse> markedupContractResponseList=new ArrayList<MarkedupContractResponse>();
        MarkedupContractResponse markedupContractResponse=new MarkedupContractResponse();
        markedupContractResponse.setRoomtype("");
        markedupContractResponse.setAvailabilitystatus(true);
        markedupContractResponse.setName("Galadhari");
        markedupContractResponse.setMarkedupprice(234.00);
        markedupContractResponseList.add(markedupContractResponse);
        System.out.println(markedupContractResponseList);
        when(queryService.CHCRExplicitJoin(new Date(2020-11-02),2, new int[]{2})).thenReturn(markedupContractResponseList);
        MvcResult mvcResult =mockMvc.perform(get("/searchResults??checkindate=2020-11-02&noofnights=2&noofroomswithadults=2")).andExpect(status().isOk()).andReturn();

        String contentAsString=mvcResult.getResponse().getContentAsString();
        assertEquals("Contract is added to the system Successfully!",contentAsString);
    }*/


}