package de.bnd.coding.sample.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends
        JpaRepository<ChallengeEntity, Integer> {

}
