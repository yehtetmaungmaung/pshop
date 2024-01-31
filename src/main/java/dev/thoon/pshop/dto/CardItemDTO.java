package dev.thoon.pshop.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CardItemDTO {
    
    @NotEmpty(message = "firstName cannot be empty")
    @Size(max = 50, message = "max size = 50")
    private String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    @Size(max = 50,message = "max size  = 50  ")
    private String lastName;
    
    @NotEmpty(message = "streetAddress cannot be empty")
    @Size(max = 200,message = "max size  = 200  ")
    private String streetAddress;

    @NotEmpty(message = "town cannot be empty")
    @Size(max = 50,message = "max size  = 50 ")
    private String town;

    private String zipCode;

    @Email
    private String email;
    @NotEmpty(message = "phone cannot be empty")
    @Pattern(regexp = "^([0-9]+)$", message = "phone must be numeric")
    private String phone;

    @NotEmpty
    private Map<Long, Integer> products = new LinkedHashMap<>();

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Map<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Integer> products) {
        this.products = products;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardItemDTO that = (CardItemDTO) o;
        return Objects.equals(products, that.products) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(streetAddress, that.streetAddress) &&
                Objects.equals(town, that.town) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, firstName, lastName, streetAddress, town, email, phone);
    }
}
