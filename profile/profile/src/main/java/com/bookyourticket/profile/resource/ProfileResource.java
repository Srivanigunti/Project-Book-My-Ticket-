package com.bookyourticket.profile.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookyourticket.profile.entity.Profile;
import com.bookyourticket.profile.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileResource {

	@Autowired
	public ProfileService service;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getProfileById(@PathVariable Integer profileId) {
		System.out.println("hello");
		Optional<Profile> profileobject = service.getProfileById(profileId);
		if (!profileobject.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(profileobject.get(), HttpStatus.OK);
	}

	
	@GetMapping("/profile")
	public ResponseEntity<Profile> verifyProfile(@RequestParam Integer number, @RequestParam String password) {
		System.out.println("hello");
		Optional<Profile> profileobject = service.getProfileByMobileNumber(number , password);
		if (!profileobject.isPresent()) {
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		return new ResponseEntity<>(profileobject.get(), HttpStatus.OK);
	}
	
	
	@GetMapping
	public List<Profile> getAllProfiles() {
		return service.getAllProfile();
	}

	@PostMapping
	public Profile addProfile(@RequestBody Profile profile) {
		//System.out.println(profile);
		Profile profile1 = service.addProfile(profile);
		profile1.getProfileId();
		restTemplate.postForEntity("http://localhost:5201/wallets/"+profile1.getProfileId(), null, null);
		return profile1;
	}

	@DeleteMapping
	public void deleteProfile(@RequestParam int profileId) {
		service.deleteProfile(profileId);
	}

	@PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        System.out.println("put Mapping");
        service.updateProfile(profile);
        return new ResponseEntity<Profile>(profile,HttpStatus.OK);
    }
 
    @PutMapping("{profileId}")
    public ResponseEntity<Profile> updateProfileById(@PathVariable Integer profileId) {
        Optional<Profile> profile = service.getProfileById(profileId);
        Profile friendProfile = profile.get();
        service.updateProfile(friendProfile);
        System.out.println(friendProfile);
        
        return new ResponseEntity<Profile>(HttpStatus.OK);
    }

}
