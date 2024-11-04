package ru.urfu.lr4.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.urfu.lr4.exception.UnsupportedCodeException;
import ru.urfu.lr4.exception.ValidationFailedException;
import ru.urfu.lr4.model.Request;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isCodeValid(Request request) throws UnsupportedCodeException;
}
