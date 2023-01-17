package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.TrainerRepo;
import com.cg.entity.Trainer;
import com.cg.exception.NoSuchTrainerFoundException;

@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerRepo repo;

	@Override
	public Trainer createTrainer(Trainer trainer) {
		return repo.save(trainer);
	}

	@Override
	public List<Trainer> findAllTrainer() {
		return repo.findAll();
	}

	@Override
	public Trainer findTrainerById(int id) throws NoSuchTrainerFoundException {
		return repo.findById(id).orElseThrow(() -> new NoSuchTrainerFoundException("invalid id"));
	}

	@Override
	public Trainer updateTrainer(Trainer trainer) throws NoSuchTrainerFoundException {
		findTrainerById(trainer.getTId());
		return repo.save(trainer);
	}

	@Override
	public boolean deleteTrainer(int id) {
		repo.deleteById(id);
		Optional<Trainer> find = repo.findById(id);
		return !(find.isPresent());
	}

}
