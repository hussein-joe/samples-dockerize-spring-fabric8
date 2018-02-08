package com.hussein.samples.dockerizefactor8.controller;

import com.hussein.samples.dockerizefactor8.dto.UserDto;
import com.hussein.samples.dockerizefactor8.model.User;
import com.hussein.samples.dockerizefactor8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.*;

@RestController
@RequestMapping("/samples/users/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDto> loadUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(u->new UserDto(u.getId(), u.getUserName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{count}")
    public void addUsers(@PathVariable("count") int count) {
        userRepository.save(LongStream.range(1, count).mapToObj(i->new User("User_" + i))
                .collect(Collectors.toList()));
    }
}
