package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Commande;
import tn.magasin.stock.entity.Livraison;
import tn.magasin.stock.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    List<Livraison> findByUser(User user);
    @Query(value = "SELECT * FROM livraison L INNER JOIN commande C ON L.commande_id_commande = C.id_commande INNER JOIN facture F ON C.factures_id_facture = F.id_facture and F.user_id =:id " , nativeQuery = true)
    List<Livraison> FindLivraisonByClient(@Param("id") Long id);
  /*  @Query(value = "SELECT * FROM livraison L, commande C where L.id_livraison = C.livraison_id_livraison and  C.etat := b" , nativeQuery = true)
    Optional<Livraison> FindLivraisonByetatCommande(@Param("b") Boolean b);*/
    List<Livraison> findByCommande(Commande commande);
    List<Livraison> findByEtat(boolean etat);
}