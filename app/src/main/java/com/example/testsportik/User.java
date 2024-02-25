package com.example.testsportik;

public class User {
    private String name;
    private String surname;
    private String email;
    // Добавьте остальные данные пользователя, если необходимо

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        // Инициализируйте остальные данные пользователя, если необходимо
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
