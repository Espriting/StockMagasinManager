package tn.magasin.stock.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.magasin.stock.IService.IUserService;
import tn.magasin.stock.Repository.RoleRepository;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.entity.Role;
import tn.magasin.stock.entity.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository; // final
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        User user = userRepository.findByNom(nom);


        if (user == null) {
            log.error("User not found in  the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User  found in the database: {}", nom);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getNom()));
        });
        return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(), authorities);
    }

    @Override
    public User ajouterUser(User user) {
        log.info("Saving new user to database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
        log.info("fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Boolean getClientByEmailAndPassword(String email, String Password) {
        if (userRepository.getUserByEmailAndPassword(email) != null) return true;
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User doLogin(String email, String Password) {
        User user1=  userRepository.getUserByEmailAndPassword(email);
        if(passwordEncoder.matches(Password, user1.getPassword())){
           return userRepository.getUserByEmailAndPassword(email);
        }else{
            return  new User();
        }
    }

    @Override
    public User updateUser(User user) {
       // User cl = userRepository.findById(id).get();
//
//        if (user.getDateNaissance() != null) cl.setDateNaissance(user.getDateNaissance());
//
//        if (user.getPassword() != null) cl.setPassword(user.getPassword());
//
//        if (user.getEmail() != null) cl.setEmail(user.getEmail());
//

       return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getNom());

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String nom, String roleName) {
        log.info("Adding role {} to user {} to the database", roleName, nom);

        User user = userRepository.findByNom(nom);
        Role role = roleRepository.findByNom(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User findByNom(String nom) {
        return  userRepository.findByNom(nom);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }


}
