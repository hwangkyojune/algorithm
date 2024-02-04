package homework.pj2.car;

public class Bus extends Car{
    private static int bCount=0;
    private int people;
    public Bus(){
        bCount++;
    }
    public Bus(int speed,String color,int people){
        super(speed,String.format("02-%03d",bCount+1),color);
        this.people = people;
        bCount++;
    }

    @Override
    public void speedUp() {
        int speedDifference = generateSpeedDifference();
        speedUp(speedDifference);
    }

    @Override
    public void speedUp(int x) {
        if(x+getSpeed()>100){
            super.speedUp(100-getSpeed());
            return;
        }
        super.speedUp(x);
    }

    @Override
    public String carMember() {
        return String.format("%s %6s:%5d",super.carMember(),"people",people);
    }

    public static int getBCount(){
        return bCount;
    }
}
