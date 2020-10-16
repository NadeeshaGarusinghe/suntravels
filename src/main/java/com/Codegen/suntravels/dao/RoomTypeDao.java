package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.RoomDetails;
import com.Codegen.suntravels.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeDao extends JpaRepository<RoomType,Integer> {
}
