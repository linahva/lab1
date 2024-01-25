import java.awt.Color;
import java.awt.geom.Point2D;

abstract class Vehichle implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed = 0; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double direction = 0;
    protected Point2D point;
    protected int carSizeCategory;

    public Vehichle(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.point = new Point2D.Double(0, 0);
        //this.carSizeCategory = 1;
        stopEngine();
    }
    public int getNrDoors() {
        return nrDoors;
    }
    public int getCarSizeCategory() {
        return carSizeCategory;
    }

        public double getEnginePower() {
            return enginePower;
        }

        public double getCurrentSpeed() {
            return currentSpeed;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color clr) {
            color = clr;
        }

        public void startEngine() {
            currentSpeed = 0.1;
        }

        public void stopEngine() {
            currentSpeed = 0;
        }

        @Override
        public void move() {
            point.setLocation(point.getX() + Math.cos(direction) * currentSpeed, point.getY() + Math.sin(direction) * currentSpeed);
        }

        @Override
        public void turnRight() {
            direction += direction-Math.PI/3;
        }

        @Override
        public void turnLeft() {
            direction += direction+Math.PI/3;
        }

        public double getX() {
                return point.getX();
            }

        public double getY() {
            return point.getY();
        }
        public void setLocation(double x, double y){
            point.setLocation(x, y);
        }

        public Point2D getPosition() {
            return point;
        }

        public double getDirection() {
            return direction;
        }

        public abstract double speedFactor();

        public void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

        public void decrementSpeed(double amount) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }

        // TODO fix this method according to lab pm
        //skriv dokumentation
        public void gas(double amount) {
            if (amount >= 0 && amount <= 1){
                incrementSpeed(amount);
            }
                else {
                    try {
                    throw new Exception();
                }
                catch (Exception ex) {
                    System.out.println("Cant have value below 0 or above 1");
                }
            }

        }

        // TODO fix this method according to lab pm
        public void brake(double amount) {
            if (amount >= 0 && amount <= 1){
                decrementSpeed(amount);
            } else {
                try {
                throw new Exception();
            }
            catch (Exception ex) {
                System.out.println("Cant have value below 0 or above 1");
            }
        }
    }
}
