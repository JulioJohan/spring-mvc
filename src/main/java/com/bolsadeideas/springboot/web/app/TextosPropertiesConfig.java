package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//Aqui se agregan todas las configuraciones de los properties
@PropertySources({
	//ubicacion de los properties
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
