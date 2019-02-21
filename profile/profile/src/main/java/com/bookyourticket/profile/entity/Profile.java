package com.bookyourticket.profile.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class Profile {
	@Id
	private int profileId;
	private String password;
	private String fullName;
	// @UniqueElements
	private String emailId;
	@UniqueElements
	private Number contactNumber;
	private UserAddress address;
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private String gender;
	private String maritalStatus;
	private static int profileIdGenerator;
	static {
		profileIdGenerator = 100;
	}
	{
		profileId = ++profileIdGenerator;
	}
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int profileId, String password, String fullName, String emailId, Number contactNumber,
			UserAddress address, LocalDate dateOfBirth, String gender, String maritalStatus) {
		super();
		this.profileId = profileId;
		this.password = password;
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Number getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Number contactNumber) {
		this.contactNumber = contactNumber;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", password=" + password + ", fullName=" + fullName + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + "]";
	}
	

}