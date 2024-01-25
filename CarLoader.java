import java.util.ArrayList;

public class CarLoader<T extends Car>{

    private ArrayList<T> loadedCars;
    private int capacity;

    public CarLoader(int capacity) {
        loadedCars = new ArrayList<T>(capacity);
        this.capacity=capacity;
    }

    public void loadCar(T car, double x, double y){
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

    public ArrayList<T> getLoadedCars() {
        return loadedCars;
    }

    private boolean carProximity(T car, double x, double y){
        double xCar = car.getX();
        double yCar = car.getY();
        double dist = Math.sqrt(Math.pow(xCar-x,2)+Math.pow(yCar-y,2));
        return dist < 1.5;
    }
    public void unloadCar(T car) {
            if (loadedCars.size()>0 && loadedCars.get(loadedCars.size()-1)==car){
                loadedCars.remove(car);
                car.setLocation(car.getX()+1, car.getY()+1);
            } else {
                System.out.println("Can't unload car that doesnt exist or is not last in line");
            }
    }
}
