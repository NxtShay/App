package de.bnd.coding.sample.demo.service;

import de.bnd.coding.sample.demo.data.ChallengeEntity;
import de.bnd.coding.sample.demo.data.ChallengeRepository;
import de.bnd.coding.sample.demo.view.ChallengeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public ChallengeDto getChallengeById(Integer id) {
        ChallengeEntity challengeEntity = challengeRepository.getById(id);
        return new ChallengeDto(challengeEntity.getChallenge(), challengeEntity.getCategory(), challengeEntity.getScore());
    }


    public void saveAll(List<ChallengeDto> challengeDtoList) {
        // saveAll is a method inherited from the JpaRepository.

        challengeRepository.saveAll(
                challengeDtoList
                        .stream()
                        // Notice the difference in field access here:
                        // a standard getter reads getLastName, however, here we access a Record
                        //  and the automatically generated methods for its fields.
                        .map(x -> new ChallengeEntity(x.challenge(), x.category(), x.score())
                        )
                        .collect(Collectors.toList())
        );
    }

    public Integer findAll() {
        return challengeRepository.findAll().size();
    }
}
