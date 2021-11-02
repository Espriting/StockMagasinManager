package tn.magasin.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import tn.magasin.stock.Service.UserService;
import tn.magasin.stock.entity.User;

@SpringBootApplication
public class MagasinStockManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(MagasinStockManagerApplication.class, args);
	}

}
