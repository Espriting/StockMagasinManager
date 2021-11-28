package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
   

}