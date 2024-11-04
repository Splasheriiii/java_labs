package ru.urfu.lr4.service;

import org.springframework.stereotype.Service;
import ru.urfu.lr4.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
