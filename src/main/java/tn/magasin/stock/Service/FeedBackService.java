package tn.magasin.stock.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.magasin.stock.Repository.FeedBackRepository;

@Service
public class FeedBackService {
    public final FeedBackRepository feedBackRepository;
    @Autowired
    public FeedBackService(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }
}
