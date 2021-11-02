package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    @Query("SELECT CASE WHEN COUNT(u)>0 THEN TRUE ELSE FALSE END FROM Fournisseur u where u.code=?1")
    boolean selectExistsFournisseur(String code);
}