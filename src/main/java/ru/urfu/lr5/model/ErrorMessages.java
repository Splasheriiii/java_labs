package ru.urfu.lr5.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {

    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Неподдерживаемый ключ"),
    UNKNOWN("Произошла непредвиденная ошибка");

    private final String description;
    ErrorMessages(String description) {
        this.description = description;
    }

    @JsonValue
    public String getName() {
        return description;
    }
}
