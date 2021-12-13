package tn.magasin.stock.IService;

import tn.magasin.stock.entity.Role;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User ajouterUser(User user);
    Optional<User> chercherUserByID(long id);
    void supprimerUser(long id);
    void supprimerToutLesUsers();
    List<User> chercherUser();//Get all users
    Boolean getClientByEmailAndPassword(String email,String Password);
    User getUserByEmail(String email);
    User doLogin(String email,String Password);
    User  updateUser(User user );
    Role saveRole(Role role);
    void addRoleToUser(String nom,String roleName);


    User getUserById(Long id);
}
