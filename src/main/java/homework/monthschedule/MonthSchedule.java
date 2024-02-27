package homework.monthschedule;
import java.util.Scanner;

public class MonthSchedule {
    public Day[] month;
    public String a;
    public MonthSchedule(int day){
        this.month = new Day[day];
    }

    //날짜에 할일 입력
    public void input(int day,String work){
        Day newDay = new Day();
        newDay.set(work);
        month[day] = newDay;
    }
    //특정 날짜 객체 반환
    public Day view(int day){
        return this.month[day];
    }
    //한달의 모든 일정 반환
    public Day[] viewMonth(){
        return month;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("4월의 스케줄 관리 프로그램");
        MonthSchedule ms = new MonthSchedule(30);
        while(true){
            System.out.println("1.할일입력 2.할일보기 3.전체할일보기 4.종료");
            System.out.println("할일 입력");
            int workType = sc.nextInt();
            if(workType==1){
                //할일 입력
                System.out.print("날짜 입력 : ");
                int date = sc.nextInt();
                sc.nextLine();
                System.out.print("할 일 입력 : ");
                String work = sc.nextLine();
                ms.input(date,work);
            }else if (workType==2) {
                System.out.print("날짜 입력 : ");
                int date = sc.nextInt();
                sc.nextLine();
                Day day = ms.view(date);
                if(day ==null){
                    System.out.println(date+"일 : 할 일이 없습니다.");
                }else{
                    System.out.println(date+"일 : "+day.get()+" 입니다.");
                }
            }else if(workType==3){
                Day[] days = ms.viewMonth();
                for(int i=0;i< days.length;i++){
                    if(days[i]!=null){
                        System.out.println(i+"일 : "+days[i].get()+" 입니다.");
                    }
                }
            }else if(workType==4){
                break;
            }
        }
    }
}
