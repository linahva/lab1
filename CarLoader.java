import java.util.ArrayList;

public class CarLoader {

    private ArrayList<Car> loadedCars = new ArrayList<Car>();
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
                car.setLocation(car.getX()+1, car.getY()+1);
            } else {
                System.out.println("Can't unload car that doesnt exist or is not last in line");
            }
    }
}
