package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    User getUserByEmailAndPassword(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(Long id);

    User findByNom(String nom);
}