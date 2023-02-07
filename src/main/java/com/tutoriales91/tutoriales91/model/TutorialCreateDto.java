package com.tutoriales91.tutoriales91.model;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TutorialCreateDto {
		
	@Id
	String id;
	
	String title;
		
	String description;
		
	boolean published;
}
