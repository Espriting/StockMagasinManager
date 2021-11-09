package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;

import java.util.Optional;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    @Query(value = "SELECT * FROM Livraison L where L.user_id = :id" , nativeQuery = true)
    Optional<Livraison> FindByLivreur(@Param("id") Long id);

}