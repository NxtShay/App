package de.bnd.coding.sample.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Is a special variant of the @Component annotation which tells Spring to create this as a singleton
@Repository
// by inheriting from a JpaRepository we get access to a certain number of methods
public interface UserRepository extends
        JpaRepository<UserEntity, Integer> {

    List<UserEntity> findByLastName(String lastName);

    UserEntity findByUserName(String userName);

}
