package Moduuli6.Moduuli6_4.Model;

public class Pet {

    private double x;
    private double y;

    private double targetX;
    private double targetY;


    public double getLocationX(){
        return x;
    }

    public double getLocationY(){
        return y;
    }

    public double getTargetX() {
        return targetX;
    }

    public double getTargetY() {
        return targetY;
    }

    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void updateTargetLocation(double x, double y){
        this.targetX = x;
        this.targetY = y;
    }


}
