package de.bnd.coding.sample.demo.service;

import de.bnd.coding.sample.demo.data.CarbonFootprintEntity;
import de.bnd.coding.sample.demo.data.CarbonFootprintRepository;
import de.bnd.coding.sample.demo.view.CarbonFootprintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarbonFootprintService {

    private final CarbonFootprintRepository carbonFootprintRepository;

    @Autowired
    public CarbonFootprintService(CarbonFootprintRepository carbonFootprintRepository) {
        this.carbonFootprintRepository = carbonFootprintRepository;
    }

    public CarbonFootprintDto getFootprintById( Integer id) {
        CarbonFootprintEntity carbonFootprintEntity = carbonFootprintRepository.getById(id);
        return new CarbonFootprintDto(carbonFootprintEntity.getName(), carbonFootprintEntity.getFootprint());
    }

    public List<CarbonFootprintDto> getFootprintByName(String name ){
        List<CarbonFootprintEntity> carbonFootprintEntities = carbonFootprintRepository.findByName( name );
        return carbonFootprintEntities
                .stream()
                .map( x -> new CarbonFootprintDto(
                        x.getName(), x.getFootprint()))
                .collect(Collectors.toList());
    }

    public void saveAll(List<CarbonFootprintDto> carbonFootprintDtoList) {
        // saveAll is a method inherited from the JpaRepository.
        carbonFootprintRepository.saveAll(
                carbonFootprintDtoList
                        .stream()
                        // Notice the difference in field access here:
                        // a standard getter reads getLastName, however, here we access a Record
                        //  and the automatically generated methods for its fields.
                        .map(x -> new CarbonFootprintEntity(x.name(), x.footprint())
                        )
                        .collect(Collectors.toList())
        );
    }

}
