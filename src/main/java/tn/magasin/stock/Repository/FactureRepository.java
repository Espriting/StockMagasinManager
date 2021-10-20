package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}