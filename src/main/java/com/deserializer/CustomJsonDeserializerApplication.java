package com.deserializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.deserializer.processor.FileProcessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class CustomJsonDeserializerApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ApplicationContext context = SpringApplication.run(CustomJsonDeserializerApplication.class, args);
		FileProcessor processo = context.getBean(FileProcessor.class);
		processo.readFile();
	}

}
