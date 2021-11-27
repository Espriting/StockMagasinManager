package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    User getUserByEmailAndPassword(String email,String password);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(String email);

        User findByNom(String nom);
}