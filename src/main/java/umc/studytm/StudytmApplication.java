package umc.studytm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class StudytmApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudytmApplication.class, args);
	}

}
