package homework.pj2.car;

import java.util.Map;

public class CarFactory {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car[] cars = new Car[9];

        cars[0] = new Sedan();
        cars[1] = new Sedan(50,"Black", 2000);
        cars[2] = new Sedan(50,"Red", 3000);

        cars[3] = new Bus();
        cars[4] = new Bus(30,"Blue",40);
        cars[5] = new Bus(30,"Yellow",50);

        cars[6] = new Truck();
        cars[7] = new Truck(20,"Gray",10);
        cars[8] = new Truck(20,"White",3);

        System.out.println("=".repeat(36));
        System.out.println("Car 객체수 : "+Car.COUNT);
        System.out.println("Sedan 객체수 : "+Sedan.getSCount());
        System.out.println("Bus 객체수 : "+Bus.getBCount());
        System.out.println("Truck 객체수 : "+Truck.getTCount());

        System.out.println("=".repeat(36));

        carFactory.regulateCarsSpeed(cars);
        carFactory.printCarsState(cars);

        System.out.println("=".repeat(36));

        carFactory.printCompareCarResult(cars);

        System.out.println("=".repeat(36));

        carFactory.printWhatCarsObject(cars);

    }
    public void printWhatCarsObject(Car[] cars){
        printWhatObject(1,cars[1]);
        printWhatObject(4,cars[4]);
        printWhatObject(7,cars[7]);
    }
    public void printWhatObject(int i,Object o){
        if(o instanceof Car){
            System.out.println(String.format("%d 인덱스는 Car의 객체임",i));
        }

        if(o instanceof Sedan){
            System.out.println(String.format("%d 인덱스는 Sedan의 객체임",i));
        }

        if(o instanceof Bus){
            System.out.println(String.format("%d 인덱스는 Bus의 객체임",i));
        }

        if(o instanceof Truck){
            System.out.println(String.format("%d 인덱스는 Truck의 객체임",i));
        }

    }
    public void printCompareCarResult(Car[] cars){
        if(cars[4].compareSpeed(cars[8])>0){
            System.out.println("인덱스 4의 속도가 인덱스 8의 속도보다 빠름");
        }else if(cars[4].compareSpeed(cars[8])==0){
            System.out.println("인덱스 4의 속도와 인덱스 8의 속도는 같음");
        }else {
            System.out.println("인덱스 8의 속도가 인덱스 4의 속도보다 빠름");
        }
    }
    public void printCarsState(Car[] cars){
        for(int i=0; i< cars.length;i++){
            System.out.println(String.format("[%d] %s",i,cars[i].carMember()));
        }
    }

    public void regulateCarsSpeed(Car[] cars){
        for(Car car:cars){
            regulateCarSpeed(car);
        }
    }

    public void regulateCarSpeed(Car car){
        double condition = Math.random();

        if(condition>0.5){
            car.speedDown();
            return;
        }
        car.speedUp();
    }
}
