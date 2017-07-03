package io.wenhao.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class User implements Serializable {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private String sex;
    private String school;
    private String grade;
    private String experience;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<Role> getRole() {
        return role;
    }

    public User setRole(List<Role> role) {
        this.role = role;
        return this;
    }

    private List<Role> role;

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public User setSchool(String school) {
        this.school = school;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public User setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public User setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(email, user.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .toHashCode();
    }
}