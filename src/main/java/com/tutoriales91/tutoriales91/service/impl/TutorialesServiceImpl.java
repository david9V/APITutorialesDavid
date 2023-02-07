package com.tutoriales91.tutoriales91.service.impl;

import java.util.List;
import java.util.Optional;

import com.tutoriales91.tutoriales91.repository.TutorialesRepository;
import com.tutoriales91.tutoriales91.service.TutorialesService;
import org.springframework.stereotype.Service;

import com.tutoriales91.tutoriales91.model.domain.Tutorial;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TutorialesServiceImpl implements TutorialesService {
	
	private final TutorialesRepository tutorialesRepository ;
	
	public Tutorial saveTutorial(Tutorial tutorial) {
		return tutorialesRepository.save(tutorial);
	}

	@Override
	public List<Tutorial> listAllTutorials() {
		return tutorialesRepository.findAll();
	}

	@Override
	public Optional<Tutorial> findById(String id) {
		return tutorialesRepository.findById(id);
	}

	@Override
	public void deleteTutorial(String id) {
		tutorialesRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		tutorialesRepository.deleteAll();
	}

	@Override
	public List<Tutorial> listByTitle(String title) {
		return tutorialesRepository.findByTitleContaining(title);
	}

	@Override
	public List<Tutorial> listByPublished(boolean published) {
		return tutorialesRepository.findByPublished(published);
	}

}
