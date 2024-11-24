package umc.studymission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import umc.studymission.repository.InquiryRepository.InquiryRepository;
import umc.studymission.repository.UserRepository.UserRepository;

@SpringBootApplication
public class StudymissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudymissionApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			UserRepository userRepository = context.getBean(UserRepository.class);
			InquiryRepository inquiryRepository = context.getBean(InquiryRepository.class);

			System.out.println("=== Users ===");
			userRepository.findAll().forEach(System.out::println);

			System.out.println("=== Inquiries ===");
			inquiryRepository.findAll().forEach(System.out::println);
		};
	}

}
