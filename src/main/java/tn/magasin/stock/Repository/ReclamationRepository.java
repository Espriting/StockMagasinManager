package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Reclamation;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}