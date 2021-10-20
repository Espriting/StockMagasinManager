package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Livraison;
@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
}