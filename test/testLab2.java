import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testLab2 {

    @Test
    public void testCarLoader(){
        CarLoader loader = new CarLoader(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        loader.loadCar(volvo, 0, 0);
        loader.loadCar(saab, 0, 0);
        loader.unloadCar();
        loader.unloadCar();
        assertEquals(volvo.getX(), 0);
        assertEquals(saab.getX(), 0);
    }
    @Test
    public void testRepairShop(){
        int x = 1;
        CarRepairShop<Volvo240> volvoShop = new CarRepairShop<Volvo240>(1, x, 0);
        CarRepairShop<Saab95> saabShop = new CarRepairShop<Saab95>(1, x, 0);
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        volvoShop.loadCar(volvo);
        saabShop.loadCar(saab);
        volvoShop.unloadCar();
        saabShop.unloadCar();
        assertEquals(volvo.getX(), x);
        assertEquals(saab.getX(), x);
    }
    @Test
    public void testLoadCarTransport(){
        CarTransport transporter = new CarTransport();
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        transporter.loadCar(volvo);
        transporter.loadCar(saab);
        assertTrue(transporter.getLoadedCars().get(0).equals(volvo));
        assertTrue(transporter.getLoadedCars().get(1).equals(saab));
        transporter.unloadCar();
        transporter.unloadCar();
        assertTrue(transporter.getLoadedCars().isEmpty());
    }
    @Test
    public void testPlatform(){
        CarTransport transporter = new CarTransport();
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        transporter.loadCar(volvo);
        transporter.loadCar(saab);
        transporter.unloadCar();
        transporter.unloadCar();
        assertEquals(volvo.getY(), -1);
        assertEquals(saab.getY(), -1);
    }
    @Test
    public void testAnglePlatform(){
        Scania scania = new Scania();
        assertEquals(scania.getRampAngle(), 0);
        assertTrue(scania.getPlatformStatus());
        scania.raisePlatform();
        assertTrue(scania.getRampAngle() != 0);
        assertTrue(!scania.getPlatformStatus());
        scania.lowerPlatform();
        assertEquals(scania.getRampAngle(), 0);
    }
}
