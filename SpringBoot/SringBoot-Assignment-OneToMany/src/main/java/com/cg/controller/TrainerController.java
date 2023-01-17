package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.TrainerDTO;
import com.cg.entity.Trainer;
import com.cg.exception.NoSuchTrainerFoundException;
import com.cg.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerService service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/get/all")
	public ResponseEntity<List<TrainerDTO>> getAll() {
		List<TrainerDTO> trainers = modelMapper.map(service.findAllTrainer(), new TypeToken<List<TrainerDTO>>() {
		}.getType());
		return ResponseEntity.ok(trainers);
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<TrainerDTO> getById(@PathVariable int id) throws NoSuchTrainerFoundException {
		return ResponseEntity.ok(modelMapper.map(service.findTrainerById(id), TrainerDTO.class));

	}

	@PostMapping("/add")
	public ResponseEntity<TrainerDTO> add(@Valid @RequestBody TrainerDTO trainerDto) {
		Trainer trainer = modelMapper.map(trainerDto, Trainer.class);
		return new ResponseEntity<>(modelMapper.map(service.createTrainer(trainer), TrainerDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<TrainerDTO> update(@Valid @RequestBody TrainerDTO tainerDto, @PathVariable int id)
			throws NoSuchTrainerFoundException {
		Trainer trainer = modelMapper.map(tainerDto, Trainer.class);
		return ResponseEntity.accepted().body(modelMapper.map(service.updateTrainer(trainer), TrainerDTO.class));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteTrainer(id) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
	}
}
