package com.tutoriales91.tutoriales91.repository;

import java.util.List;

import com.tutoriales91.tutoriales91.model.domain.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialesRepository extends MongoRepository<Tutorial, String>{
	
	List<Tutorial> findByTitleContaining(String title);
	
	List<Tutorial> findByPublished(boolean published);
	
}
