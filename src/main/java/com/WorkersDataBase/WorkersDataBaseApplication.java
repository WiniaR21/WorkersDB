package com.WorkersDataBase;

import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@CssImport(value = "./themes/components/styles.css", themeFor = "vaadin-grid")
@CssImport(value = "./themes/components/main.css")
@CssImport(value = "./themes/components/content.css",themeFor = "content")
public class WorkersDataBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkersDataBaseApplication.class, args);
	}

}
