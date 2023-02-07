package com.tutoriales91.tutoriales91.service;

import java.util.List;
import java.util.Optional;

import com.tutoriales91.tutoriales91.model.domain.Tutorial;

public interface TutorialesService {
	
	public Tutorial saveTutorial(Tutorial tutorial);
	
	public List<Tutorial> listAllTutorials();
	
	public Optional<Tutorial> findById(String id);

	public void deleteTutorial(String id);
	
	public void deleteAll();
	
	public List<Tutorial> listByTitle(String title);
	
	public List<Tutorial> listByPublished(boolean published);
}
