package com.cg.service;

import java.util.List;

import com.cg.entity.Trainer;
import com.cg.exception.NoSuchTrainerFoundException;

public interface TrainerService {
	Trainer createTrainer(Trainer trainer);

	List<Trainer> findAllTrainer();

	Trainer findTrainerById(int id) throws NoSuchTrainerFoundException;

	Trainer updateTrainer(Trainer trainer) throws NoSuchTrainerFoundException;

	boolean deleteTrainer(int id);
}
