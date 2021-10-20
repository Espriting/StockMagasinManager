package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.Accompte;
@Repository
public interface AccompteRepository extends JpaRepository<Accompte, Long> {


}