package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Facture;
import tn.magasin.stock.entity.Livraison;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
 @Query(value = "SELECT * FROM commande c , facture f where c.factures_id_facture = f.id_facture AND f.id_facture = :fact" , nativeQuery = true)
 Optional<Commande> FindByFactures(@Param("fact") Long fact);
 @Query(value = "SELECT * FROM commande C ,facture F where c.factures_id_facture = F.id_facture and F.user_id =:id " , nativeQuery = true)
 Optional<Commande> FindCommandeByClient(@Param("id") Long id);
}