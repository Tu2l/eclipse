package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Integer> {

}
