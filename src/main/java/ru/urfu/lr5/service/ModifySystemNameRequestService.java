package ru.urfu.lr5.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.urfu.lr5.model.Request;
import ru.urfu.lr5.util.DateTimeUtil;

import java.util.Date;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        request.setSource("Service 1");
        request.setSystemTime(DateTimeUtil.getDateFormat().format(new Date()));
        var httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange("http://localhost:8080/feedback", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<>() { });
    }
}
