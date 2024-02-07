package com.example.demo1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
    private final StringProperty name;
    private final StringProperty surname;
    private final IntegerProperty age;

    public Persona(String name, String surname, Integer age) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public IntegerProperty ageProperty() {
        return age;
    }
}


