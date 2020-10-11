package com.Codegen.suntravels.dao;

import com.Codegen.suntravels.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContractDao extends JpaRepository<Contract,Integer> {
}
