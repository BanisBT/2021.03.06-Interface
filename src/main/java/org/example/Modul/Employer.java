package org.example.Modul;

public class Employer {
    private String name;
    private EmployersRole role;
    private int likes;

    public Employer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Darbuotojo vardas  |  pareigos  | pagirimu skaicius " + '\n' +
                name + " | " + role + " | " + likes + '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployersRole getRole() {
        return role;
    }

    public void setRole(EmployersRole role) {
        this.role = role;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
