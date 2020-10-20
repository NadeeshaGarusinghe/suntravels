package com.Codegen.suntravels.services;

import com.Codegen.suntravels.dto.ContractResponse;
import com.Codegen.suntravels.dto.MarkedupContractResponse;
import com.Codegen.suntravels.dto.ViewContractHotelResponse;
import com.Codegen.suntravels.dto.ViewContractRoomTypeRespose;

import java.util.Date;
import java.util.List;

public interface IQueryService {
    List<ViewContractHotelResponse> HotelContractExplicitJoin();
    List<ViewContractRoomTypeRespose> ContractRoomTypeImplicitJoin();
    public List<MarkedupContractResponse> CHCRExplicitJoin(Date checkindate, int noofnights, int noofroomswithadults);
}

