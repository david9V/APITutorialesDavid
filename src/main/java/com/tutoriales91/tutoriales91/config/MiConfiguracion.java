package com.tutoriales91.tutoriales91.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiConfiguracion {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
