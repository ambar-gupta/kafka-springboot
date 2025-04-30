package com.ambar.KafkaProject.json;

public class User {
    private String name;
    private int age;

    // Default constructor (VERY IMPORTANT for JSON serialization)
    public User() {}

    // Constructor with parameters
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (required for JSON mapping)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString (optional but good for logging)
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + '}';
    }
}

