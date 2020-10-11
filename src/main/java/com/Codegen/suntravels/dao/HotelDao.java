package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.Hotel;
import org.springframework.data.repository.CrudRepository;


public interface HotelDao extends CrudRepository<Hotel,Integer> {   //<model object type,type of the primary key of that object>



}
