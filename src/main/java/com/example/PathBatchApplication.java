package com.example;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class PathBatchApplication {

	private final JobBuilderFactory jobBuilderFactory;

	private final StepBuilderFactory  stepBuilderFactory;

	public PathBatchApplication(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Step passStep(){
		return stepBuilderFactory.get("passStep");
	}

	public static void main(String[] args) {
		SpringApplication.run(PathBatchApplication.class, args);
	}

}
