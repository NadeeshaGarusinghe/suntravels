package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.Hotel;
import com.Codegen.suntravels.model.RoomDetails;
import org.springframework.data.repository.CrudRepository;

public interface RoomDetailsDao extends CrudRepository<RoomDetails,Integer> {
}
