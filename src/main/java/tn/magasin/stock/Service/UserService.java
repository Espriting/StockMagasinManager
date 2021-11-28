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
    public final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> retrieveAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long Id) {
        userRepository.deleteById(Id);
    }


    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> retrieveUser(Long Id) {


        return userRepository.findById(Id);
    }
}
