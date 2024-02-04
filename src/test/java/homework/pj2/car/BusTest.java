package homework.pj2.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    @Test
    void speedUp(){
        Car bus = new Bus();
        Car car = new Car();
        car.speedUp();
        bus.speedUp();

        System.out.println(car.carMember());
        System.out.println(car.getSpeed());
        System.out.println(bus.getSpeed());
    }

    @Test
    void tabTest(){
        System.out.println(String.format("%-20sabcde","가나다라마바사아자카차"));
        System.out.println(String.format("%-20svdsvsdsadas","가나다라마바사아자카차"));
        System.out.println("sssss\tdsad");
    }

}