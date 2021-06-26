package de.bnd.coding.sample.demo.service;

import de.bnd.coding.sample.demo.data.UserEntity;
import de.bnd.coding.sample.demo.data.UserRepository;
import de.bnd.coding.sample.demo.view.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Is a special variant of the @Component annotation which tells Spring to create this as a singleton
@Service
public class UserService {

    // Here we want to use the repository to store data
    private final UserRepository userRepository;

    // Autowired will fetch the correct dependencies from all present singletons.
    // See https://de.wikipedia.org/wiki/Dependency_Injection
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // For a more detailed description of the Service layer, check the Readme

    public UserDto getUserById( Integer id ) {
        // getById is a method inherited from the JpaRepository.
        UserEntity userEntity = userRepository.getById(id);
        return new UserDto(userEntity.getUserName(),
                userEntity.getUserPassword(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getZipCode(),
                userEntity.getPeopleInHouse(), userEntity.getHeating(), userEntity.getElectricity(),
                userEntity.getCar(), userEntity.getKilometers(), userEntity.getHolidayCar(),
                userEntity.getHolidayPlane(), userEntity.getHolidayTrain(), userEntity.getFood(),
                userEntity.getPvSystem(), userEntity.getRecyclingGlass(), userEntity.getRecyclingPlastic(),
                userEntity.getRecyclingPaper(), userEntity.getRecyclingMetal(), userEntity.getRecyclingFoodwaste(),
                userEntity.getWashing(), userEntity.getFootPrint(), userEntity.getUserScore());
    }

    public String getPasswordByUser( String userName ) {
        // getById is a method inherited from the JpaRepository.
        UserEntity userEntity = userRepository.findByUserName(userName);
        return userEntity.getUserPassword();
    }

    public List<UserDto> getUserByLastName( String lastName ) {
        List<UserEntity> userEntities = userRepository.findByLastName(lastName);
        // This is a so called Lambda Expression - easy to use for operations on Lists
        return userEntities
                .stream()
                .map( x -> new UserDto(x.getUserName(), x.getUserPassword(), x.getFirstName(), x.getLastName(), x.getZipCode(),
                        x.getPeopleInHouse(), x.getHeating(), x.getElectricity(), x.getCar(),
                        x.getKilometers(), x.getHolidayCar(), x.getHolidayPlane(), x.getHolidayTrain(),
                        x.getFood(), x.getPvSystem(), x.getRecyclingGlass(), x.getRecyclingPlastic(),
                        x.getRecyclingPaper(), x.getRecyclingMetal(), x.getRecyclingFoodwaste(),
                        x.getWashing(), x.getFootPrint(), x.getUserScore()))
                .collect(Collectors.toList());
    }

    public UserDto getUserByUserName( String userName ) {
        UserEntity userEntity = userRepository.findByUserName(userName);
        // This is a so called Lambda Expression - easy to use for operations on Lists
        return new UserDto(userEntity.getUserName(),
                userEntity.getUserPassword(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getZipCode(),
                userEntity.getPeopleInHouse(), userEntity.getHeating(), userEntity.getElectricity(),
                userEntity.getCar(), userEntity.getKilometers(), userEntity.getHolidayCar(),
                userEntity.getHolidayPlane(), userEntity.getHolidayTrain(), userEntity.getFood(),
                userEntity.getPvSystem(), userEntity.getRecyclingGlass(), userEntity.getRecyclingPlastic(),
                userEntity.getRecyclingPaper(), userEntity.getRecyclingMetal(), userEntity.getRecyclingFoodwaste(),
                userEntity.getWashing(), userEntity.getFootPrint(), userEntity.getUserScore());
    }


    public void saveAll(List<UserDto> userDtoList) {
        // saveAll is a method inherited from the JpaRepository.

        userRepository.saveAll(
                userDtoList
                        .stream()
                        // Notice the difference in field access here:
                        // a standard getter reads getLastName, however, here we access a Record
                        //  and the automatically generated methods for its fields.
                        .map(x -> new UserEntity(x.userName(), x.userPassword(), x.firstName(),x.lastName())
                        )
                        .collect(Collectors.toList())
        );
    }

    public void updateUserData(UserDto userDto) {
        UserEntity oldUserEntity = userRepository.findByUserName(userDto.userName());
        if (userDto.zipCode() != null) {
            if(!userDto.zipCode().equals(oldUserEntity.getZipCode())) {
                oldUserEntity.setZipCode(userDto.zipCode());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.peopleInHouse() != null) {
            if (!userDto.peopleInHouse().equals(oldUserEntity.getPeopleInHouse())) {
                oldUserEntity.setPeopleInHouse(userDto.peopleInHouse());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.heating() != null) {
            if (!userDto.heating().equals(oldUserEntity.getHeating())) {
                oldUserEntity.setHeating(userDto.heating());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.electricity() != null) {
            if (!userDto.electricity().equals(oldUserEntity.getElectricity())) {
                oldUserEntity.setElectricity(userDto.electricity());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.car() != null) {
            if (!userDto.car().equals(oldUserEntity.getCar())) {
                oldUserEntity.setCar(userDto.car());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.kilometers() != null) {
            if (!userDto.kilometers().equals(oldUserEntity.getKilometers())) {
                oldUserEntity.setKilometers(userDto.kilometers());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.holidayCar() != null) {
            if (!userDto.holidayCar().equals(oldUserEntity.getHolidayCar())) {
                oldUserEntity.setHolidayCar(userDto.holidayCar());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.holidayPlane() != null) {
            if (!userDto.holidayPlane().equals(oldUserEntity.getHolidayPlane())) {
                oldUserEntity.setHolidayPlane(userDto.holidayPlane());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.food() != null) {
            if (!userDto.food().equals(oldUserEntity.getFood())) {
                oldUserEntity.setFood(userDto.food());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.pvSystem() != null) {
            if (!userDto.pvSystem().equals(oldUserEntity.getPvSystem())) {
                oldUserEntity.setPvSystem(userDto.pvSystem());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.recyclingGlass() != null) {
            if (!userDto.recyclingGlass().equals(oldUserEntity.getRecyclingGlass())) {
                oldUserEntity.setRecyclingGlass(userDto.recyclingGlass());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.recyclingPlastic() != null) {
            if (!userDto.recyclingPlastic().equals(oldUserEntity.getRecyclingPlastic())) {
                oldUserEntity.setRecyclingPlastic(userDto.recyclingPlastic());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.recyclingPaper() != null) {
            if (!userDto.recyclingPaper().equals(oldUserEntity.getRecyclingPaper())) {
                oldUserEntity.setRecyclingPaper(userDto.recyclingPaper());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.recyclingMetal() != null) {
            if( !userDto.recyclingMetal().equals(oldUserEntity.getRecyclingMetal())) {
                oldUserEntity.setRecyclingMetal(userDto.recyclingMetal());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.recyclingFoodwaste() != null) {
            if( !userDto.recyclingFoodwaste().equals(oldUserEntity.getRecyclingFoodwaste())) {
                oldUserEntity.setRecyclingFoodwaste(userDto.recyclingFoodwaste());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.washing() != null) {
            if( !userDto.washing().equals(oldUserEntity.getWashing())) {
                oldUserEntity.setWashing(userDto.washing());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.footPrint() != null) {
            if( !userDto.footPrint().equals(oldUserEntity.getFootPrint())) {
                oldUserEntity.setFootPrint(userDto.footPrint());
                userRepository.save(oldUserEntity);
            }
        }
        if (userDto.userScore() != null) {
            if( !userDto.userScore().equals(oldUserEntity.getUserScore())) {
                if(oldUserEntity.getUserScore() == null){
                    oldUserEntity.setUserScore(userDto.userScore());
                } else {
                    oldUserEntity.setUserScore(userDto.userScore() + oldUserEntity.getUserScore());
                }
                userRepository.save(oldUserEntity);
            }
        }
    }
}
