package tn.magasin.stock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class MagasinStockManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagasinStockManagerApplication.class, args);
	}

}
