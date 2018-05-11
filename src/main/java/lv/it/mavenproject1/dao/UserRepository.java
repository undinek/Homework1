package lv.it.mavenproject1.dao;

import java.util.List;
import lv.it.mavenproject1.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByName(String name);
    public List<User> findBySurname(String name);

}
