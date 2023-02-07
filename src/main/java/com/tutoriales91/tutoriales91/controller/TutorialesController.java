package com.tutoriales91.tutoriales91.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutoriales91.tutoriales91.converter.DtoConverter;
import com.tutoriales91.tutoriales91.model.TutorialCreateDto;
import com.tutoriales91.tutoriales91.model.TutorialListDto;
import com.tutoriales91.tutoriales91.model.domain.Tutorial;
import com.tutoriales91.tutoriales91.service.impl.TutorialesServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TutorialesController {

	private final TutorialesServiceImpl tutorialesServiceImpl;

	private final DtoConverter dtoConverter;

	@PostMapping("/tutorials")
	public ResponseEntity<?> createTutorial(@RequestBody TutorialCreateDto tutorialDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(tutorialesServiceImpl.saveTutorial(dtoConverter.convertToEntity(tutorialDto)));
	}

	@GetMapping("/tutorials")
	public ResponseEntity<?> listAllTutorials() {
		List<Tutorial> result = tutorialesServiceImpl.listAllTutorials();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<TutorialListDto> dtoList = result.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}

	@GetMapping("/tutorials/id/{id}")
	public ResponseEntity<?> listById(@PathVariable String id) {
		Optional<Tutorial> opt = tutorialesServiceImpl.findById(id);
		try {
			Tutorial t = opt.get();
			return ResponseEntity.ok(t);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/tutorials/title/{title}")
	public ResponseEntity<?> listByTitleContaining(@PathVariable String title) {
		List<Tutorial> result = tutorialesServiceImpl.listByTitle(title);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<TutorialListDto> dtoList = result.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	
	@GetMapping("/tutorials/published/{published}")
	public ResponseEntity<?> listByPubklished(@PathVariable boolean published) {
		List<Tutorial> result = tutorialesServiceImpl.listByPublished(published);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<TutorialListDto> dtoList = result.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<?> updateTutorial(@RequestBody TutorialCreateDto tutorialDto, @PathVariable String id) {
		Optional<Tutorial> opt = tutorialesServiceImpl.findById(id);
		try {
			Tutorial t = opt.get();
			t.setDescription(tutorialDto.getDescription());
			t.setPublished(tutorialDto.isPublished());
			t.setTitle(tutorialDto.getTitle());
			return ResponseEntity.ok(tutorialesServiceImpl.saveTutorial(t));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("tutorials/{id}")
	public void deleteTutorialById(@PathVariable String id) {
		tutorialesServiceImpl.deleteTutorial(id);
	}

	@DeleteMapping("tutorials")
	public void deleteAll() {
		tutorialesServiceImpl.deleteAll();
	}

}
