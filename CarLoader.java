import java.util.ArrayList;

public class CarLoader{

    private ArrayList<Car> loadedCars;
    private int capacity;

    public CarLoader(int capacity) {
        loadedCars = new ArrayList<Car>(capacity);
        this.capacity=capacity;
    }

    public void loadCar(Car car, double x, double y){
        if (!carProximity(car, x, y)){
            System.out.println("Car to far away to load");
            return;
        } else if (car.getCarSizeCategory()>1){
            System.out.println("Car to big to load");
            return;
        }
        if (loadedCars.size() < capacity){
            loadedCars.add(car);
            car.setLocation(x, y);
        } else {
            System.out.println("Can't load more cars");
        }
    }

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    private boolean carProximity(Car car, double x, double y){
        double xCar = car.getX();
        double yCar = car.getY();
        double dist = Math.sqrt(Math.pow(xCar-x,2)+Math.pow(yCar-y,2));
        return dist < 1.5;
    }
    public void unloadCar(Car car) {
            if (loadedCars.size()>0 && loadedCars.get(loadedCars.size()-1)==car){
                loadedCars.remove(car);
                car.setLocation(car.getX(), car.getY()-1);
            } else {
                throw new IllegalArgumentException("that car is not on top of the truck or doesnt exist");
            }
    }
}
