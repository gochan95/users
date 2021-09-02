package com.example.users;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {
    private final UserRepository repository;
    
    UserController(UserRepository repository){
        this.repository = repository;
    }

    @PostMapping("/api/register")
    User newUser(@RequestBody User newUser){
        //save user built from request to repository
        return repository.save(newUser);
    }

    @PostMapping("/api/login")
    User loginUser(@RequestBody User user){
        // find user by username
        User foundUser = repository.findByUsername(user.getUsername());
        // check passwords are the same
        if(foundUser.getPassword().equals(user.getPassword())){
            return foundUser;
        } else {
            // throw exception for username not correct or password incorrect
            throw new UserNotFoundException(user.getUsername());
        }
    }

    @GetMapping("/api/users/{uuid}")
    User getUserInfo(@PathVariable Long uuid){
        // find user info by id
        return repository.findById(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
    }

    @PostMapping("/api/users/{uuid}")
    ResponseEntity<User> updateUserInfo(@RequestBody User newUser, @PathVariable Long uuid){
        // get user from id
        User user = repository.findById(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
        // set newly required info from request
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setPhone(newUser.getPhone());
        // save new info to replace user
        final User updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
