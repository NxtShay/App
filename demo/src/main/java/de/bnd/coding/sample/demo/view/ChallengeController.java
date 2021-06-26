package de.bnd.coding.sample.demo.view;


import de.bnd.coding.sample.demo.service.ChallengeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("api/v1/challenge")
public class ChallengeController {

    private final Logger logger = LoggerFactory.getLogger(ChallengeController.class);

    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody ChallengeDto getChallengeById(
            @PathVariable(value = "id") Integer id
    ) {
        logger.info("Received request to get challenge with ID {}", id);
        return challengeService.getChallengeById(id);
    }

    @GetMapping("/size")
    public @ResponseBody Integer getSize( ) {
        logger.info("Received request to get number of challenges{}");
        return challengeService.findAll();
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void uploadChallenge(
            @RequestBody ChallengeDto[] challengeDto
    ) {
        logger.info(
                "Received request to upload {} number of users", challengeDto.length
        );
        challengeService.saveAll(
                Arrays.asList(challengeDto)
        );
    }

}
