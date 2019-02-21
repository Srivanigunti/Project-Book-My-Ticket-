package com.bookyourticket.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookyourticket.profile.entity.Profile;

@Service
public interface ProfileService {

	Optional<Profile> getProfileById(int profileId);

	List<Profile> getAllProfile();

	Profile addProfile(Profile profile);

	void deleteProfile(Integer profileId);

	//String changePassword(String password, int profileId);

	void updateProfile(Profile profile);

	Optional<Profile> getProfileByMobileNumber(Integer number, String password);

	//void updatePassword(Profile profile);

}