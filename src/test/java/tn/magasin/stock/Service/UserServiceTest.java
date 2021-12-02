package tn.magasin.stock.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tn.magasin.stock.Repository.FournisseurRepository;
import tn.magasin.stock.Repository.UserRepository;
import tn.magasin.stock.entity.User;
import tn.magasin.stock.enumeration.Role;


class UserServiceTest {
    @Autowired
    private UserRepository underTest;
    private static final Logger l = LogManager.getLogger(FournisseurRepository.class);


   /* @Test
    void retrieveAllUser() {
        l.info(underTest.retrieveAllUser().toString());

    }*/

    @Test
    void addUser() {
        User user=new User();
        user.setNom("monam");
        user.setPrenom("ben gouta");
        user.setEmail("monam.bengoua@gmail.com");
        user.setRole(Role.ADMIN);
        System.out.println(user.toString());
        underTest.save(user);
        /*if(underTest.addUser(user)==null)
        l.warn("user is not added");
        else l.info("user add with success");*/
    }
/*
    @Test
    void deleteUserById() {
        Long id=12l;
        underTest.deleteUserById(id);

    }*/

   /* @Test
    void updateUser() {
        User user=new User();
        user.setEmail("monam.bengouta@esprit.tn");
        user.setId(1l);
        l.info(underTest.updateUser(user));
    }*/

   /* @Test
    void retrieveOneUser() {

        l.info(underTest.userRepository.findById(1l));
    }*/
}