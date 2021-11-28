package tn.magasin.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.magasin.stock.Service.UserService;
import tn.magasin.stock.entity.User;

@EnableSwagger2
@SpringBootApplication
public class MagasinStockManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(MagasinStockManagerApplication.class, args);
	}

}
