package inheritance;

public class Professor extends People{
    private String subject;
    public Professor(String name,String subject){
        //부모 생성자 호출, 부모 생성자는 인수가 필요하므로 생략하면 안됨
        super(name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
