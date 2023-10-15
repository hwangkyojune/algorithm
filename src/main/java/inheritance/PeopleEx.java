package inheritance;

public class PeopleEx {
    public static void main(String[] args) {
        People[] p = new People[2];
        p[0] = new Student("홍길동",90);
        p[1]= new Professor("김철수","자바");
        People p1 = new People("강아지");
    }
}
