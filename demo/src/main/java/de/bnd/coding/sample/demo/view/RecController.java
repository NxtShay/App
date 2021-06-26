package de.bnd.coding.sample.demo.view;

import de.bnd.coding.sample.demo.service.RecService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("api/v1/recommondation")
public class RecController {

     private final Logger logger = LoggerFactory.getLogger(RecController.class);

     private final RecService recService;

     @Autowired
     public RecController(RecService recService) {
         this.recService = recService;
     }

    @GetMapping("/id/{id}")
    public @ResponseBody
    RecDto getRecommondationById(
            @PathVariable(value = "id") Integer id
    ) {
        logger.info("Received request to get recommondation with ID {}", id);
        return recService.getRecommondationById(id);
    }

    @GetMapping("/basedon/{basedon}")
    public @ResponseBody RecDto[] getRecommondationBasedOn(
            @PathVariable(value = "basedon") String basedon
    ) {
        logger.info("Received request to get recommondation based on {}", basedon);
        return recService.getRecommondationBasedOn(basedon).toArray(new RecDto[0]);
    }

    @GetMapping("/zipcode/{zipcode}")
    public @ResponseBody RecDto[] getRecommondationZipCode(
            @PathVariable(value = "zipcode") String zipcode
    ) {
        logger.info("Received request to get recommondation for {}", zipcode);
        return recService.getRecommondationZipCode(zipcode).toArray(new RecDto[0]);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void uploadRecommondation(
            @RequestBody RecDto[] recDto
    ) {
        logger.info(
                "Received request to upload {} number of recommondations", recDto.length
        );
        recService.saveAll(
                Arrays.asList(recDto)
        );
    }



}
