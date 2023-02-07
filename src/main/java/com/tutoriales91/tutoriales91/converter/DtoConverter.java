package com.tutoriales91.tutoriales91.converter;


import com.tutoriales91.tutoriales91.model.TutorialCreateDto;
import com.tutoriales91.tutoriales91.model.TutorialListDto;
import com.tutoriales91.tutoriales91.model.domain.Tutorial;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DtoConverter {
	
	private final ModelMapper modelMapper;
	
	public TutorialListDto convertToDto(Tutorial tutorial) {
		return modelMapper.map(tutorial, TutorialListDto.class);
	}
	
	public Tutorial convertToEntity(TutorialCreateDto tutorialDto) {
		return modelMapper.map(tutorialDto, Tutorial.class);
	}

}