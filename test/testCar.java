import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;
//Hej

public class testCar {
    private Car volvo;
    private Car saab;

    @BeforeEach
    public void init() {
        this.volvo = new Volvo240();
        this.saab = new Saab95();
    }

    @Test
    public void testGasWithValidAmount() {
        double speed1 = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        double speed2 = volvo.getCurrentSpeed();
        assertNotEquals(speed2, speed1);
    }
    
    @Test
    public void testGasWithInvalidAmount() {
        double speed1 = volvo.getCurrentSpeed();
        volvo.gas(-0.5);
        volvo.gas(1.1);
        double speed2 = volvo.getCurrentSpeed();
        assertEquals(speed2, speed1);
    }

    @Test
    public void testBreakWithValidAmount() {
        volvo.gas(1);
        double speed1 = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        double speed2 = volvo.getCurrentSpeed();
        assertNotEquals(speed2, speed1);
    }
    
    @Test
    public void testBreakWithInvalidAmount() {
        double speed1 = volvo.getCurrentSpeed();
        volvo.brake(-0.5);
        volvo.brake(1.1);
        double speed2 = volvo.getCurrentSpeed();
        assertEquals(speed2, speed1);
    }
    
    @Test
    public void testEngine() {
        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }
        assertEquals(volvo.getCurrentSpeed(), volvo.getEnginePower(), 0.0001);
    }

    @Test void testTurnRight() {
        volvo.turnRight();
        saab.turnRight();
        assertEquals(volvo.getDirection(), -Math.PI/3);
        assertEquals(saab.getDirection(), -Math.PI/3);
    
    }

    @Test
    public void testStartEnginge() {
        volvo.startEngine();
        saab.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1);
        assertEquals(saab.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testStopEnginge() {
        volvo.stopEngine();
        saab.stopEngine();
        assertEquals(volvo.getCurrentSpeed(), 0);
        assertEquals(saab.getCurrentSpeed(), 0);
    }
    
    @Test
    public void testMove() {
        volvo.startEngine();
        saab.startEngine();
        volvo.move();
        saab.move();
        double sx = volvo.getX();
        double vx = saab.getX();
        assertEquals(vx, 0.1);
        assertEquals(sx, 0.1);
    }
    
    @Test
    public void testTurnLeft() {
        volvo.turnLeft();
        saab.turnLeft();
        assertEquals(volvo.getDirection(), Math.PI/3);
        assertEquals(saab.getDirection(), Math.PI/3);
    }
    
    @Test
    public void testTurnLeftAndMove() {
        volvo.startEngine();
        saab.startEngine();
        volvo.turnLeft();
        saab.turnLeft();
        volvo.move();
        saab.move();
        float x = (float) (0.1 * Math.cos(Math.PI/3));
        float y = (float) (0.1 * Math.sin(Math.PI/3));
        assertEquals(volvo.getX(), x, 0.0001);
        assertEquals(saab.getX(), x, 0.0001);
        assertEquals(volvo.getY(), y, 0.0001);
        assertEquals(saab.getY(), y, 0.0001);
    }
    
    @Test
    public void testColor() {
        volvo.setColor(Color.red);
        saab.setColor(Color.red);
        assertEquals(volvo.getColor(), Color.red);
        assertEquals(saab.getColor(), Color.red);
    }
}
