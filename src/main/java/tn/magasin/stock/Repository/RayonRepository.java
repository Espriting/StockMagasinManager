package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Rayon;
@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {
    @Query("SELECT CASE WHEN COUNT(p)>0 THEN TRUE ELSE FALSE END from Produit p join Rayon r on p.rayon.idRayon=?1")
    boolean produitExistInRayon(Long Id);
}