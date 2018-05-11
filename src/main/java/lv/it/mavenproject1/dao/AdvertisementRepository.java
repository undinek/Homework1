package lv.it.mavenproject1.dao;

import java.util.List;
import lv.it.mavenproject1.domain.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {

    public List<Advertisement> findByAuthor(String author);
}
