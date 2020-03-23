package com.fullJava.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.fullJava.annotation")
@PropertySource("coachDetails.properties")
public class SportConfig {

	
	//Method name is Bean id
	@Bean
	public FortuneServices myFortuneService(){
		return new MyFortuneService();
	}
	
	@Bean
	public SwimCoach swimCoach(){
		SwimCoach swimCoach=new SwimCoach(myFortuneService());
		return swimCoach;
	}
	
	/*If you are using Spring 4.2 and lower, you will need to add the code to initialize bean for read value from property file
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}*/
}
