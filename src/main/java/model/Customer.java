package model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Component
public class Customer {
    @NotEmpty(message = "{firstName.empty}")
    @Size(min = 5, max = 45, message = "{firstName.size}")
    private String firstName;

    @NotEmpty(message = "{lastName.empty}")
    @Size(min = 5, max = 45, message = "{lastName.size}")
    private String lastName;

    @Size(min = 10, max = 11, message = "{phone.size}")
    @Pattern(regexp = "^0\\d*", message = "{phone.startWith}")
    @Pattern(regexp = "\\d{10,11}", message = "{phone.numberOnly}")
    private String phone;

    @Min(value = 18, message = "{age.outBound}")
    private int age;

    @Pattern(regexp = "^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "{email.invalid}")
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getAge() == customer.getAge() &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPhone(), getAge(), getEmail());
    }
}
