package inheritance;

public class Student extends People{
    private int score;
    public Student(String name){
        super(name);
    }

    public Student(String name,int score){
        super(name);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
