package ru.netology.HomeWork_Map.Javaqa.Services;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String name) {
        super("Игрок: " + name + " не зарегистрирован");
    }

}
