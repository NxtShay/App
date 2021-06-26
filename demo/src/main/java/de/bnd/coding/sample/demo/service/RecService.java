package de.bnd.coding.sample.demo.service;

import de.bnd.coding.sample.demo.data.RecEntity;
import de.bnd.coding.sample.demo.data.RecRepository;
import de.bnd.coding.sample.demo.view.RecDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecService {

    private final RecRepository recRepository;

    @Autowired
    public RecService(RecRepository recRepository) {
        this.recRepository = recRepository;
    }

    public RecDto getRecommondationById(Integer id) {
        RecEntity recEntity = recRepository.getById(id);
        return new RecDto(recEntity.getRecommondation(), recEntity.getBasedOn(), recEntity.getZipCode());
    }

    public void saveAll(List<RecDto> recDtoList) {
        // saveAll is a method inherited from the JpaRepository.

        recRepository.saveAll(
                recDtoList
                        .stream()
                        // Notice the difference in field access here:
                        // a standard getter reads getLastName, however, here we access a Record
                        //  and the automatically generated methods for its fields.
                        .map(x -> new RecEntity(x.recommondation(), x.basedOn(), x.zipCode())
                        )
                        .collect(Collectors.toList())
        );
    }

    public List<RecDto> getRecommondationBasedOn(String basedOn) {
        List<RecEntity> recEntities = recRepository.findByBasedOn(basedOn);
        return recEntities
                .stream()
                .map( x -> new RecDto(x.getRecommondation(), x.getBasedOn(), x.getZipCode()))
                .collect(Collectors.toList());
    }

    public List<RecDto> getRecommondationZipCode(String zipcode) {
        List<RecEntity> recEntities = recRepository.findByZipCode(zipcode);
        return recEntities
                .stream()
                .map( x -> new RecDto(x.getRecommondation(), x.getBasedOn(), x.getZipCode()))
                .collect(Collectors.toList());
    }
}
