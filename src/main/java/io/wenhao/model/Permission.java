package io.wenhao.model;

import java.io.Serializable;

public class Permission implements Serializable {
    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    private String name;

}
