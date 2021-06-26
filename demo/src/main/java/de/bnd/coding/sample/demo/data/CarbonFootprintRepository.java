package de.bnd.coding.sample.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarbonFootprintRepository extends
        JpaRepository<CarbonFootprintEntity, Integer> {

    List<CarbonFootprintEntity> findByName(String name );

}
