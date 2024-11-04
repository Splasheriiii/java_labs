package ru.urfu.lr5.service;

import ru.urfu.lr5.model.Positions;

public interface QuartalBonusService {
    double calculate(Positions position, double salary, double bonus, int workDays, int totalDays);
}
