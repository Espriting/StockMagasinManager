package tn.magasin.stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.magasin.stock.entity.FeedBack;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}