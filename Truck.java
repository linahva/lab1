import java.awt.Color;

abstract class Truck extends Vehichle{

    Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.carSizeCategory = 2;
    }
    
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    @Override
    public void startEngine() {
        if (getPlatformStatus()){
            super.startEngine();
        } else {
            System.out.println("Truck bed is raised, can't start engine");
        }
    }
    abstract public boolean getPlatformStatus();
}
