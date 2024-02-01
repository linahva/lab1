import java.awt.geom.Point2D;
import java.util.ArrayList;

class CarRepairShop<T extends Car> implements Loadable<T>{
    private CarLoader loadedCars;
    private Point2D shopLocation;

    CarRepairShop(int capacity, double x, double y) {
        shopLocation = new Point2D.Double(x, y);
        loadedCars = new CarLoader(capacity);
    }
    private double shopX() {
        return shopLocation.getX();
    }
    private double shopY() {
        return shopLocation.getY();
    }
    public void unloadCar(T car) {
        loadedCars.unloadCar(car);
    }
    public void loadCar(T car) {
        loadedCars.loadCar(car, shopX(), shopY());
    }
    public ArrayList<Car> getLoadedCars() {
        return loadedCars.getLoadedCars();
    }
}