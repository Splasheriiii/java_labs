package ru.urfu.lr5.service;

import org.junit.jupiter.api.Test;
import ru.urfu.lr5.model.Positions;

import javax.swing.text.Position;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        var pos = Positions.HR;
        var bonus = 2.0;
        var workDays = 243;
        var salary = 100000.0;
        var res = new AnnualBonusServiceImpl().calculate(pos, salary, bonus, workDays);
        var expected = Calendar.getInstance().get(Calendar.YEAR) % 4 == 0 ? 361481.48148148146 : 360493.8271604938;
        assertEquals(expected, res);
    }
}