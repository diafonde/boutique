package madsi.dia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.BOUTIQUES.model"})
public class DiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaApplication.class, args);
	}

}
