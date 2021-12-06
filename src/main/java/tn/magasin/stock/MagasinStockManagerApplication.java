package tn.magasin.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.magasin.stock.Service.UserService;
import tn.magasin.stock.entity.Role;
import tn.magasin.stock.entity.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class MagasinStockManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(MagasinStockManagerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


   /* @Bean

  
    CommandLineRunner run(UserService us) {
        return args -> {
            us.saveRole(new Role(null, "ROLE_USER"));
            us.saveRole(new Role(null, "MANAGER"));
            us.saveRole(new Role(null, "ROLE_ADMIN"));
            us.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            Date date = new SimpleDateFormat("yyyyMMdd").parse("19981105");
            us.ajouterUser(new User(null, "Travolta", "John", date, "Travolta@outlook.fr", "1234",null, new ArrayList<>()));
            us.ajouterUser(new User(null, "Will", "Smith", date, "Will@live.de", "12345",null,new ArrayList<>()));
            us.ajouterUser(new User(null, "Jim", "Carry", date, "Jim@gmail.com", "0123456",null, new ArrayList<>()));
            us.ajouterUser(new User(null, "Arnold", "schwarzenegger", date, "Arnold@live.fr", "00000",null, new ArrayList<>()));



            us.addRoleToUser("Travolta", "ROLE_USER");
            us.addRoleToUser("Will", "ROLE_ADMIN");
            us.addRoleToUser("Jim", "ROLE_USER");
            us.addRoleToUser("Arnold", "ROLE_SUPER_ADMIN");


        };



    }
*/
}





