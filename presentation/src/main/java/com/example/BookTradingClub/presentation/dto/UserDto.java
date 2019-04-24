package com.example.BookTradingClub.presentation.dto;

import java.util.Objects;

public class UserDto {

    private int id;

    private String name;

    private String firstName;

    private String lastName;

    private String city;

    private String country;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto user = (UserDto) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(city, user.city) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName, lastName, city, country);
    }
}
