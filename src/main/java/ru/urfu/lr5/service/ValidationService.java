package ru.urfu.lr5.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.urfu.lr5.exception.UnsupportedCodeException;
import ru.urfu.lr5.exception.ValidationFailedException;
import ru.urfu.lr5.model.Request;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isCodeValid(Request request) throws UnsupportedCodeException;
}
