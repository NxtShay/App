package de.bnd.coding.sample.demo.view;

import de.bnd.coding.sample.demo.service.CarbonFootprintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/api/v1/footprint")
public class CarbonFootprintController {

    private final Logger logger = LoggerFactory.getLogger(CarbonFootprintController.class);

    private final CarbonFootprintService carbonFootprintService;

    @Autowired
    public  CarbonFootprintController(CarbonFootprintService carbonFootprintService) {
        this.carbonFootprintService = carbonFootprintService;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody CarbonFootprintDto getFootprintById(
            @PathVariable(value = "id") Integer id
    ) {
        logger.info("Received request to get carbon footprint with ID {}", id);
        return carbonFootprintService.getFootprintById(id);
    }

    @GetMapping("name/{name}")
    public @ResponseBody CarbonFootprintDto[] getFootprintByName(
            @PathVariable(value="name") String name
    ) {
        logger.info("Received request to get footprint by name {}", name);
        return carbonFootprintService.getFootprintByName(name).toArray(new CarbonFootprintDto[0]);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void uploadFootprint(
            @RequestBody CarbonFootprintDto[] carbonFootprintDtos
    ) {
        logger.info(" Received request to upload {} number of footprints", carbonFootprintDtos.length);
        carbonFootprintService.saveAll( Arrays.asList(carbonFootprintDtos) );
    }



}
