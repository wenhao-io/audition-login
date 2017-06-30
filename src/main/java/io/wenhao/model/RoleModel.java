package io.wenhao.model;

public class RoleModel {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public RoleModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleModel setName(String name) {
        this.name = name;
        return this;
    }
}