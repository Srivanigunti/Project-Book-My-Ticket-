package com.bookyourticket.profile.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookyourticket.profile.entity.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Integer> {

	Optional<Profile> findByContactNumberAndPassword(Integer number, String password);

}