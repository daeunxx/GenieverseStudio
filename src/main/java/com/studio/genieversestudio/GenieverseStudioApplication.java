package com.studio.genieversestudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GenieverseStudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenieverseStudioApplication.class, args);
	}

}
