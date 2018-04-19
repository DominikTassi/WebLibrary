package org.web.library;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web.core.exceptions.NoUserException;
import org.web.core.model.User;
import org.web.core.service.UserService;

import java.sql.SQLException;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") int id) throws NoUserException, SQLException {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUserByName(@PathVariable(value = "name") String name) throws NoUserException, SQLException {
        return userService.getUser(name);
    }


}
