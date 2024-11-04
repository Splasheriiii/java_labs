package ru.urfu.lr4.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.lr4.exception.UnsupportedCodeException;
import ru.urfu.lr4.exception.ValidationFailedException;
import ru.urfu.lr4.model.*;
import ru.urfu.lr4.service.ModifyRequestService;
import ru.urfu.lr4.service.ModifyResponseService;
import ru.urfu.lr4.service.ValidationService;
import ru.urfu.lr4.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final ValidationService validationService;

    @Autowired
    public MyController(@Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService,
                        ValidationService validationService) {
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.validationService = validationService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getDateFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("response: {}", response);

        var status = HttpStatus.OK;
        try {
            validationService.isCodeValid(request);
            validationService.isValid(bindingResult);
        } catch (UnsupportedCodeException e) {
            log.error("error: {}", e.toString());
            response.setCode(Codes.FAILURE);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            status = HttpStatus.BAD_REQUEST;
        } catch (ValidationFailedException e) {
            log.error("error: {}", e.toString());
            response.setCode(Codes.FAILURE);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            log.error("error: {}", e.toString());
            response.setCode(Codes.FAILURE);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        modifyResponseService.modify(response);
        modifyRequestService.modify(request);

        log.info("response: {}", response);
        return new ResponseEntity<>(response, status);
    }
}
