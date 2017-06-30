package io.wenhao.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserModel {
    private String id;
    private String name;
    private String password;
    private String salt;
    private String email;
    private String sex;
    private String school;
    private String grade;
    private String experience;

    public String getSex() {
        return sex;
    }

    public UserModel setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public UserModel setSchool(String school) {
        this.school = school;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public UserModel setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public UserModel setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public UserModel setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        return new EqualsBuilder()
                .append(email, userModel.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .toHashCode();
    }
}