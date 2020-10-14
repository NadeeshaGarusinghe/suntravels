package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeDao extends JpaRepository<RoomDetails,Integer> {
}
