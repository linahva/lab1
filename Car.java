import java.awt.*;

abstract class Car extends Vehichle{
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName, 1);
    }
}

