package io.wenhao.controller;

import io.wenhao.common.Error;
import io.wenhao.exception.UserConflictException;
import io.wenhao.model.UserModel;
import io.wenhao.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody UserModel userModel) {
        int count = userService.addUser(userModel);
        if (count == 0) {
            Error error = new Error(0, userModel.getEmail());
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 响应状态，HTTP 状态码 204
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public UserModel updateUser(@RequestBody UserModel userModel) {
        return userService.updateUser(userModel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 响应状态，HTTP 状态码 204
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
    }

    @ExceptionHandler(UserConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody
    Error userConflict(UserConflictException e) {
        return new Error(4, e.getEmail());
    }
}