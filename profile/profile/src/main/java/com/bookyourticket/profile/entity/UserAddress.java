package com.bookyourticket.profile.entity;

public class UserAddress {
	private String houseNumber;
	private String streetName;
	private String district;
	private String state;
	private String country;

	public UserAddress() {
		super();
	}

	public UserAddress(String houseNumber, String streetName, String district, String state, String country) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.district = district;
		this.state = state;
		this.country = country;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", streetName=" + streetName + ", district=" + district
				+ ", state=" + state + ", country=" + country + "]";
	}

}
