package tn.magasin.stock.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.magasin.stock.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByNom(String nom);

}
