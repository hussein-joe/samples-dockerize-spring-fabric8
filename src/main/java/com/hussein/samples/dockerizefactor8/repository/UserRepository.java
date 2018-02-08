package com.hussein.samples.dockerizefactor8.repository;

import com.hussein.samples.dockerizefactor8.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
