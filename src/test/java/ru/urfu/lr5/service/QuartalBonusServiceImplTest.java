package ru.urfu.lr5.service;

import org.junit.jupiter.api.Test;
import ru.urfu.lr5.model.Positions;

import static org.junit.jupiter.api.Assertions.*;

class QuartalBonusServiceImplTest {

    @Test
    void calculateManager() {
        assertEquals(57000, new QuartalBonusServiceImpl().calculate(Positions.HR, 100000, 0.2, 60, 57));
    }
    @Test
    void calculateNotManager() {
        assertEquals(0, new QuartalBonusServiceImpl().calculate(Positions.DEV, 100000, 0.2, 60, 57));
    }
}