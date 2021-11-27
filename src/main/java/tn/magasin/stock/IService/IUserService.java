package tn.magasin.stock.IService;

import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void ajouterUser(User user);
    Optional<User> chercherUserByID(long id);
    void supprimerUser(long id);
    void supprimerToutLesUsers();
    List<User> chercherUser();
    Boolean getClientByEmailAndPassword(String email,String Password);
    User getUserByEmail(String email);
    User doLogin(String email,String Password);
    void  updateUser(User user, long id );

}
