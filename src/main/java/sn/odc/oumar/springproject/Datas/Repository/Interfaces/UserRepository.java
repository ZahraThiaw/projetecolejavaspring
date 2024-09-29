package sn.odc.oumar.springproject.Datas.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.odc.oumar.springproject.Datas.Entity.User;

import java.util.Optional;

public interface UserRepository extends BaseInterface<User, Long> {

    Optional<User> findByEmail(String email);
   // User save(User user);
    
}
