package ru.urfu.lr5.service;

import ru.urfu.lr5.model.Positions;

public class QuartalBonusServiceImpl implements QuartalBonusService {
    @Override
    public double calculate(Positions position, double salary, double bonus, int workDays, int totalDays) {
        return position.isManager() ? salary * 3 * bonus / workDays * totalDays : 0.0;
    }
}
