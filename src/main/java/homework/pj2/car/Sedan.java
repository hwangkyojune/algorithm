package homework.pj2.car;

public class Sedan extends Car{
    private static int sCount=0;
    private int cc;
    public Sedan(){
        sCount++;
    }

    public Sedan(int speed,String color,int cc){
        super(speed,String.format("01-%03d",sCount+1),color);
        this.cc =cc;
        sCount++;
    }

    @Override
    public void speedUp() {
        speedUp(generateSpeedDifference());
    }

    @Override
    public void speedUp(int x) {
        if(getSpeed()+x>200){
            super.speedUp(200-getSpeed());
            return;
        }
        super.speedUp(x);
    }

    @Override
    public String carMember() {
        return String.format("%s %6s:%5d",super.carMember(),"cc",cc);
    }

    public static int getSCount(){
        return sCount;
    }
}
