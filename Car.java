import java.awt.*;
import java.awt.geom.Point2D;

abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private Point2D point;


    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        //this.currentSpeed = currentSpeed;
        this.modelName = modelName;
        this.point = new Point(0,0);
        stopEngine();
    }

        public int getNrDoors() {
            return nrDoors;
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
            newX =
            point = new Point2D(, y)
            yforward += getCurrentSpeed();
            point.y -=  getCurrentSpeed();
        }

        @Override
        public void turnRight() {

        }

        @Override
        public void turnLeft() {
            point.x -= getCurrentSpeed();
        }

        public double getX() {
                return point.getX();
            }

        public double getY() {
            return point.getY();
        }

        public Point getPosition() {
            return point;
        }

        public double getDirection() {
            direction = sqrt()
        }

        public abstract double speedFactor();
        public void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

        public void decrementSpeed(double amount) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
        // TODO fix this method according to lab pm
        public void gas(double amount) {
            if (amount >= 0 && amount <= 1)
                incrementSpeed(amount);
        }

        // TODO fix this method according to lab pm
        public void brake(double amount) {
            if (amount >= 0 && amount <= 1)
                decrementSpeed(amount);
        }
    }

