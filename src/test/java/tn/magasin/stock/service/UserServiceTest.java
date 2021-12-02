package tn.magasin.stock.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.Service.UserService;

@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService us;

    @MockBean
    private UserRepository UserRepository;




    @Test
    public void test(){

        /*try {
            User user=new User();
            Date date= new SimpleDateFormat( "yyyyMMdd" ).parse( "19981105" );
            user.setEmail("amine.azri@esprit.tn");
            user.setNom("xx");
            user.setPrenom("x");
            user.setPassword("amine");
        //    user.setCategorieClient(CategorieClient.ADMIN);
          //  user.setProfession(Profession.Autre.Etudiant);
            user.setDateNaissance(date);
            us.ajouterUser(user);
            String mail = "scolarite1@esprit.tn";
            String mdp = "scolarite1";


            if(user.getEmail().equals(mail) && user.getPassword().equals(mdp)){
                Mockito.when(UserRepository.getUserByEmailAndPassword(mail,mdp)).thenReturn(user);

            }else{
                Mockito.when(UserRepository.getUserByEmailAndPassword(user.getEmail(),user.getPassword())).thenReturn(null);
                if (user.getEmail().equals(mail)){
                    Mockito.when(UserRepository.getUserByEmail(user.getEmail())).thenReturn(user);
                }
            }

            User found = us.doLogin(mail,mdp);

            //assertThat(found.geteMail()).isEqualTo(d.geteMail());
            System.out.println(user.getEmail()+" "+user.getPassword()+" ");

            Optional<User> C1 = us.chercherUserByID(user.getId());
            Assertions.assertNotNull(C1.get().getDateNaissance());
            log.info("le nom du client d'id : "+C1.get().getId()+" est "+ C1.get().getNom());
            log.info("le prenom du client d'id : "+C1.get().getId()+" est "+ C1.get().getPrenom());


        }catch (Exception e){


            System.out.println(e.getMessage());
        }

*/


    }
}
