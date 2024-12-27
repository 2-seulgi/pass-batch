package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@EnableBatchProcessing
@SpringBootApplication
public class PathBatchApplication {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;

	public PathBatchApplication(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
	}


	@Bean
	public Step passStep() {
		// StepBuilder 인스턴스를 JobRepository를 이용해 직접 생성
		return new StepBuilder("passStep", jobRepository)
				.tasklet((contribution, chunkContext) -> {
					System.out.println("Passing through step...");
					return RepeatStatus.FINISHED;
				}, transactionManager)
				.build();
	}

	@Bean
	public Job passJob(JobRepository jobRepository, Step passStep) {
		return new JobBuilder("myJob", jobRepository)
				.start(passStep)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(PathBatchApplication.class, args);
	}

}
