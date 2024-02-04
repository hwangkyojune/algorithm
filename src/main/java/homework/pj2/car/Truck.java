package homework.pj2.car;

public class Truck extends Car{
    private static int tCount;
    private int ton;
    public Truck(){
        tCount++;
    }

    public Truck(int speed,String color,int ton){
        super(speed,String.format("03-%03d",tCount),color);
        this.ton = ton;
        tCount++;
    }

    @Override
    public void speedUp() {
        speedUp(generateSpeedDifference());
    }

    @Override
    public void speedUp(int x) {
        if(x+super.getSpeed()>80){
            super.speedUp(80-super.getSpeed());
            return;
        }
        super.speedUp(x);
    }

    @Override
    public String carMember() {
        return String.format("%s %6s:%5d",super.carMember(),"ton",ton);
    }

    public static int getTCount(){
        return tCount;
    }
}
