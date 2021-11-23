package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Facture;

import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}

