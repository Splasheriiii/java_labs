package ru.urfu.lr5.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.urfu.lr5.exception.UnsupportedCodeException;
import ru.urfu.lr5.exception.ValidationFailedException;
import ru.urfu.lr5.model.Request;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
    public void isCodeValid(Request request) throws UnsupportedCodeException {
        if (Objects.equals(request.getUid(), "123")) {
            throw new UnsupportedCodeException("Неподдерживаемый код");
        }
    }
}
