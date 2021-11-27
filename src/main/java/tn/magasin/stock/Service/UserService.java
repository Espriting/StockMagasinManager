package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IUserService;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    public  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void ajouterUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> chercherUserByID(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void supprimerUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void supprimerToutLesUsers() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> chercherUser() {
        return userRepository.findAll();
    }

    @Override
    public Boolean getClientByEmailAndPassword(String email, String Password) {
        if(userRepository.getUserByEmailAndPassword(email,Password)!=null) return true;
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User doLogin(String email, String Password) {
        return userRepository.getUserByEmailAndPassword(email,Password);
    }

    @Override
    public void updateUser(User user, long id) {
        User cl=userRepository.findById(id).get();

        if(user.getDateNaissance()!=null) cl.setDateNaissance(user.getDateNaissance());

        if(user.getProfession()!=null)cl.setProfession(user.getProfession());

        if(user.getPassword()!=null)cl.setPassword(user.getPassword());

        if(user.getEmail()!=null)cl.setEmail(user.getEmail());

        if(user.getCategorieClient()!=null)cl.setCategorieClient(user.getCategorieClient());

        userRepository.save(cl);
    }
}
