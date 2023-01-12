package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>  {

}
