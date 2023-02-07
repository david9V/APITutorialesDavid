package com.tutoriales91.tutoriales91.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TutorialListDto {

	@Id
	String id;
	String title;
		
	String description;
		
	boolean published;
}
