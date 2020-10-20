package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.Location;
import com.Codegen.suntravels.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location,Integer> {
}
