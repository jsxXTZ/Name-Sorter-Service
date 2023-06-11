package com.sort.name.model;

import java.util.Comparator;

public class Name {
    private String lastName;
    private String givenName;

    public Name() {}

    public Name(String lastName, String givenName, String fullName) {
        this.lastName = lastName;
        this.givenName = givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGivenName() { return givenName; }

    public void setGivenName(String givenName) { this.givenName = givenName; }

    public static Comparator<Name> compareByLastName = new Comparator<>() {
        public int compare(Name one, Name other) {
            return one.lastName.compareTo(other.lastName);
        }
    };
}

