package homework.monthschedule;
import homework.Circle;

public class MonthSchedule {
    public Day[] month;
    public String a;
    public MonthSchedule(int day, String a, Day[] month){
        this.month = new Day[day];
    }

    //날짜에 할일 입력
    public void input(int day,String work){
        month[day].set(work);
    }
    //특정 날짜의 할일 반환
    public String view(int day){
        return month[day].get();
    }
    //한달의 모든 일정 반환
    public Day[] viewMonth(){
        return month;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
