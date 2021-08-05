package com.api.mongo.springbootmongodb.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "bootcamps")
public class BootcampModel extends BaseModel{
	
	@Id
	private String id;
	private String name;
	private String description;
	private String website;
	private String phone;
	private String email;
	private String address;
	private String location;
	private int coordinates; 
	private String formattedAddress;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private List<String> careers;
	private int averageRating;
	private int averageCost;
	private String photo;
	private boolean housing;
	private boolean jobAssistance;
	private boolean jobGuarantee;
	private boolean acceptGi;
	private Date createdAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int coordinates) {
		this.coordinates = coordinates;
	}
	public String getFormattedAddress() {
		return formattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public List<String> getCareers() {
		return careers;
	}
	public void setCareers(List<String> careers) {
		this.careers = careers;
	}
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
	public int getAverageCost() {
		return averageCost;
	}
	public void setAverageCost(int averageCost) {
		this.averageCost = averageCost;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isHousing() {
		return housing;
	}
	public void setHousing(boolean housing) {
		this.housing = housing;
	}
	public boolean isJobAssistance() {
		return jobAssistance;
	}
	public void setJobAssistance(boolean jobAssistance) {
		this.jobAssistance = jobAssistance;
	}
	public boolean isJobGuarantee() {
		return jobGuarantee;
	}
	public void setJobGuarantee(boolean jobGuarantee) {
		this.jobGuarantee = jobGuarantee;
	}
	public boolean isAcceptGi() {
		return acceptGi;
	}
	public void setAcceptGi(boolean acceptGi) {
		this.acceptGi = acceptGi;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return String.format(
				"BootcampModel [id=%s, name=%s, description=%s, website=%s, phone=%s, email=%s, address=%s, location=%s, coordinates=%s, formattedAddress=%s, street=%s, city=%s, state=%s, zipcode=%s, careers=%s, averageRating=%s, averageCost=%s, photo=%s, housing=%s, jobAssistance=%s, jobGuarantee=%s, acceptGi=%s, createdAt=%s]",
				id, name, description, website, phone, email, address, location, coordinates, formattedAddress, street,
				city, state, zipcode, careers, averageRating, averageCost, photo, housing, jobAssistance, jobGuarantee,
				acceptGi, createdAt);
	}
	
	

}
