package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.DetailFacture;
import tn.magasin.stock.entity.Facture;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {
    List<DetailFacture>findByFactures(Optional<Facture> facture);
}
