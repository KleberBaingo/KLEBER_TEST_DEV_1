package com.companies;

public class Company {
    private String name;
    private String segment;

    public Company(String name, String segment) {
        this.name = name;
        this.segment = segment;
    }

    public String getName() {
        return name;
    }

    public String getSegment() {
        return segment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }
}
