package com.example.BookTradingClub.presentation.dto;

import java.util.Objects;

public class UserWithoutDetailsDto {
    private int id;

    private String name;

    public UserWithoutDetailsDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserWithoutDetailsDto)) return false;
        UserWithoutDetailsDto that = (UserWithoutDetailsDto) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "UserWithoutDetailsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
