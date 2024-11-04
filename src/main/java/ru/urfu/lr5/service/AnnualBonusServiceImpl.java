package ru.urfu.lr5.service;

import org.springframework.stereotype.Service;
import ru.urfu.lr5.model.Positions;

import java.util.Calendar;
import java.util.Date;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        return salary * bonus * (Calendar.getInstance().get(Calendar.YEAR) % 4 == 0 ? 366 : 365) * positions.getPositionCoefficient() / workDays;
    }
}
