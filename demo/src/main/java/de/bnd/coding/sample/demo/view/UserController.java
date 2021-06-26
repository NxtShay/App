package de.bnd.coding.sample.demo.view;

import de.bnd.coding.sample.demo.data.UserEntity;
import de.bnd.coding.sample.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

// Is a special variant of the @Component annotation which tells Spring to create this as a singleton
@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    // Used for logging. Is automatically filled by Spring
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Here we want to use our Service to perform the "business logic"
    private final UserService userService;

    // Autowired will fetch the correct dependencies from all present singletons.
    // See https://de.wikipedia.org/wiki/Dependency_Injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody UserDto getUserById(
            @PathVariable(value="id") Integer id
    ) {
        logger.info("Received request to get user with ID {}", id);
        return userService.getUserById(id);
    }

    // ResponseBody will tell Java to include the Object returned by this method as the body of the response.
    // The according object needs to have a valid JSON representation, which is done
    //  via the Jackson library. This is automatically done by Spring when using the according Records.
    @GetMapping("/name/{name}")
    public @ResponseBody UserDto[] getUserByLastName(
            @PathVariable(value="name") String name
    ) {
        logger.info("Received request to get user with lastname {}", name);
        return userService.getUserByLastName(name).toArray(new UserDto[0]);
    }

    @GetMapping("/username/{username}")
    public @ResponseBody UserDto getUserByUserName(
            @PathVariable(value="username") String name
    ) {
        logger.info("Received request to get user with username {}", name);
        return userService.getUserByUserName(name);
    }

    @GetMapping("/password/{password}")
    public @ResponseBody String getPasswordByUserName(
            @PathVariable(value="password") String name
    ) {
        logger.info("Received request to get user with lastname {}", name);
        return userService.getPasswordByUser(name);
    }

    // Same thing happens here with the Request Body
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void uploadUsers(
            @RequestBody UserDto[] userDto
    ) {
        logger.info(
                "Received request to upload {} number of users", userDto.length
        );
        userService.saveAll(
                Arrays.asList(userDto)
        );
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateUser(
            @RequestBody UserDto userDto
    ) {
        logger.info(
                "Received request to update information for user"
        );
        userService.updateUserData(userDto);
    }


}
