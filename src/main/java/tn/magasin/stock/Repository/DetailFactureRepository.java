package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.DetailFacture;
@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {
}