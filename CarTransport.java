import java.awt.Color;
import java.util.ArrayList;

public class CarTransport extends Truck implements Loadable<Car>{
    private CarLoader<Car> loadedCars;
    private CarPlatform carPlatform;

    CarTransport(){
        super(2, Color.BLACK, 500, "CarTransport");
        loadedCars = new CarLoader<Car>(3);
        carPlatform = new CarPlatform();
    }
    
    @Override
    public void move() {
        if (!getPlatformStatus()){
            super.move();
            for (Car car : loadedCars.getLoadedCars()){
                car.setLocation(getX(), getY());
            }
        } else {
            System.out.println("Can't move while truck bed is raised");
        }
    }
    public void raisePlatform(){
        if (getCurrentSpeed()>0){
            System.out.println("Can't raise platform while moving");
        } else {
            carPlatform.rampUp();
        }
    }
    public void lowerPlatform(){
        if (getCurrentSpeed()>0){
            System.out.println("Can't lower platform while moving");
        } else {
            carPlatform.rampDown();
        }
    }
    public void loadCar(Car car){
        if (!getPlatformStatus()){
            loadedCars.loadCar(car, getX(), getY());
        } else {
            System.out.println("Can't load car while truck bed is raised");
        }
    }
    public void unloadCar(Car car){
        if (!getPlatformStatus()){
            loadedCars.unloadCar(car);
        } else {
            System.out.println("Can't unload car while truck bed is raised");
        }
    }
    public ArrayList<Car> getLoadedCars() {
        return loadedCars.getLoadedCars();
    }

    public boolean getPlatformStatus(){
        return carPlatform.isRampDown();
    }
}
