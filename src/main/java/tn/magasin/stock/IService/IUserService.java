package tn.magasin.stock.IService;

import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> retrieveAllUser();
    User addUser(User user);
    void deleteUserById(Long Id);
   // Boolean deleteUserByObject(User user);
    User updateUser(User user);
    Optional<User> retrieveUser(Long Id);

}
