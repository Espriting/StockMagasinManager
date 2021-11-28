package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Commande;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}