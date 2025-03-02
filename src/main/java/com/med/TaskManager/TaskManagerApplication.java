package com.med.TaskManager;

import com.med.TaskManager.dao.entity.Task;
import com.med.TaskManager.dao.repository.TaskRepository;
import com.med.TaskManager.enums.Flag;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOriginPatterns(List.of("http*"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}





	@Bean
	public CommandLineRunner init(TaskRepository taskRepository) {

		return args -> {
			Task task1 = new Task();
			task1.setName("Complete Project Proposal");
			task1.setDescription("Write and submit the project proposal by the deadline.");
			task1.setStartTime(LocalDateTime.of(2023, 10, 1, 10, 0));
			task1.setEndTime(LocalDateTime.of(2023, 10, 1, 12, 0));
			task1.setDone(false);
			task1.setFlag(Flag.HIGH_PRIORITY);
			taskRepository.save(task1);

			Task task2 = new Task();
			task2.setName("Prepare Presentation");
			task2.setDescription("Create slides for the upcoming team meeting.");
			task2.setStartTime(LocalDateTime.of(2023, 10, 2, 14, 0));
			task2.setEndTime(LocalDateTime.of(2023, 10, 2, 16, 0));
			task2.setDone(false);
			task2.setFlag(Flag.MEDIUM_PRIORITY);
			taskRepository.save(task2);

			Task task3 = new Task();
			task3.setName("Review Code");
			task3.setDescription("Review and provide feedback on the latest pull request.");
			task3.setStartTime(LocalDateTime.of(2023, 10, 3, 9, 0));
			task3.setEndTime(LocalDateTime.of(2023, 10, 3, 11, 0));
			task3.setDone(true);
			task3.setFlag(Flag.LOW_PRIORITY);
			taskRepository.save(task3);

		};
	}

}
