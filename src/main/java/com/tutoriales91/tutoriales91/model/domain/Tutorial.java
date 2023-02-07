package com.tutoriales91.tutoriales91.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("tutoriales")

public class Tutorial {

	@Id
	String id;
	
	String title;
	
	String description;
	
	boolean published;
}
