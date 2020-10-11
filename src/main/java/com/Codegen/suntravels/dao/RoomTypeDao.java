package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoomTypeDao extends JpaRepository<RoomType,Integer> {
}
