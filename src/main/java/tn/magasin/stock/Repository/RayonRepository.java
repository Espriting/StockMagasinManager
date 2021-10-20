package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Rayon;
@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {
}