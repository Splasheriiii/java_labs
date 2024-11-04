package ru.urfu.lr5.service;

import org.springframework.stereotype.Service;
import ru.urfu.lr5.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
