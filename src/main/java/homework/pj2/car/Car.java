package homework.pj2.car;

public class Car {
    static int COUNT = 0;
    private int speed;
    private String no;
    private String color;

    public Car(){
        COUNT++;
        System.out.println(COUNT);
    }

    public Car(int speed,String no,String color){
        this.speed = speed;
        this.no = no;
        this.color = color;

        COUNT++;
        System.out.println(COUNT);
    }
    public int getSpeed(){
        return speed;
    }
    public int generateSpeedDifference(){
        return (int)((Math.random())*100/4);
    }

    public void speedUp(){
        speedUp(generateSpeedDifference());
    }

    public void speedUp(int x){
        speed = speed+x;
    }

    public void speedDown(){
        speedDown(generateSpeedDifference());
    }

    public void speedDown(int x){
        if(speed<=x){
            speed = 0;
            return;
        }
        speed-=10;
    }

    public String carMember(){
        return String.format("speed:%4d  no: %-10s color: %-10s",speed,no,color);
    }

    public int compareSpeed(Car other){
        return speed - other.speed;
    }

    public boolean equals(Car other){
        if(speed==other.speed && color.equals(other.speed)){
            return true;
        }
        return false;
    }
}
