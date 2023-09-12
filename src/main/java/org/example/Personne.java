package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Personne {

    private String firstname;

    private String lastname;

    private LocalDate birthday;

    private boolean active;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isActive() {
        return active;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Personne(String firstname, String lastname, LocalDate birthday, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return active == personne.active && Objects.equals(firstname, personne.firstname) && Objects.equals(lastname, personne.lastname) && Objects.equals(birthday, personne.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthday, active);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", active=" + active +
                '}';
    }
}
