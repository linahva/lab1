public class CarTransportPlatform implements Platform{
    private boolean isRampDown;
    CarTransportPlatform(){
        isRampDown = true;
    }
    public void rampDown(){
        isRampDown = true;
    }
    public void rampUp(){
        isRampDown = false;
    }
    public boolean isRampDown(){
        return isRampDown;
    }
}
