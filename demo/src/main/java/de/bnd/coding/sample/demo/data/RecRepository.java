package de.bnd.coding.sample.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecRepository extends
        JpaRepository<RecEntity, Integer> {

    List<RecEntity> findByBasedOn(String basedOn);

    List<RecEntity> findByZipCode(String zipcode);
}
