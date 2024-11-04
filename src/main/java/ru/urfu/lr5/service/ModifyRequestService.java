package ru.urfu.lr5.service;

import org.springframework.stereotype.Service;
import ru.urfu.lr5.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
