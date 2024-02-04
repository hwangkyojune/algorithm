package homework.hw7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordGame {
    public static void main(String[] args) {
        WordGame wordGame = new WordGame();

        Dictionary dictionary = wordGame.new Dictionary();
        TestService testService = wordGame.new TestService();

        while(true){
            int option = IoView.readOption();
            if(option==1){
                testService.playTest(dictionary);
            }else if(option==2){
                testService.putWordToDictionary(dictionary);
            }else if(option==3){
                IoView.printTerminate();
                break;
            }
        }

    }


    class TestService{
        public void playTest(Dictionary dictionary){
            IoView.printStartTest();
            while(true){
                AnswerCandidate answerCandidate = dictionary.createAnswerCandidate();
                IoView.printAnswerAsEng(answerCandidate.engAnswer());
                int selectedNum = IoView.readSelectAnswer(answerCandidate.korView());
                if(selectedNum==-1){
                    IoView.printTerminate();
                    break;
                }

                IoView.printCheckAnswerResult(answerCandidate.isAnswer(selectedNum));
            }
        }

        public void putWordToDictionary(Dictionary dictionary){
            while(true){
                String engAndKor = IoView.readWord();
                if(engAndKor.equals("그만")){
                    break;
                }
                dictionary.putWord(Word.createWord(engAndKor));
            }
        }
    }


    class IoView{
        public static Scanner scanner = new Scanner(System.in);

        public static int readOption(){
            System.out.print("1.단어테스트 2.단어삽입 3.종료 : ");
            int option = scanner.nextInt();
            scanner.nextLine();

            return option;
        }
        public static String readWord(){
            System.out.print("영어 한글 입력 : ");
            String input = scanner.nextLine();

            return input;
        }
        public static void printStartTest(){
            System.out.println("단어 테스트 시작 (종료는 -1 입력)");
        }

        public static void printAnswerAsEng(String eng){
            System.out.println(String.format("%s?",eng));
        }

        public static int readSelectAnswer(List<String> problemView){
            Stream.iterate(1,i->i+1).limit(problemView.size())
                    .forEach((i)-> System.out.print(String.format("(%d)%s ",i,problemView.get(i-1))));
            System.out.print(":");

            int selectAnswer = scanner.nextInt();

            return selectAnswer;
        }

        public static void printCheckAnswerResult(boolean isAnswer){
            if(isAnswer){
                System.out.println("정답입니다!!!!");
                return;
            }
            System.out.println("오답입니다.....");
        }

        public static void printTerminate(){
            System.out.println("수고하셨습니다. 단어테스트를 종료합니다.");
        }
    }


    class Dictionary{
        private Vector<Word> dictionary = new Vector<>();

        public Dictionary(){
            List<String> korWords = new ArrayList<>(Arrays.asList("동물,선생님,사람,아기,자동차,행복한,사과,학생,사랑".split(",")));
            List<String> engWords = new ArrayList<>(Arrays.asList("animal,teacher,human,baby,car,happy,apple,student,love".split(",")));

            for(int i=0;i<korWords.size();i++){
                dictionary.add(new Word(korWords.get(i),engWords.get(i)));
            }
        }

        public void putWord(Word word){
            dictionary.add(word);
        }
        public void putWord(String kor,String eng){
            dictionary.add(new Word(kor,eng));
        }

        public List<Integer> selectNumber(int range){
            List<Integer> problemViewIndex = Stream.iterate(0,n->n+1).limit(range).collect(Collectors.toList());
            Collections.shuffle(problemViewIndex);
            return problemViewIndex.subList(0,4);
        }

        public AnswerCandidate createAnswerCandidate(){
            List<Word> problemView = selectNumber(dictionary.size()).stream()
                    .map(i->dictionary.get(i)).collect(Collectors.toList());

            return new AnswerCandidate(problemView);
        }

    }

    class AnswerCandidate {
        private List<Word> problemView;
        private Word answer;
        AnswerCandidate(List<Word> problemView){
            this.problemView = problemView;
            answer = problemView.get((int)(Math.random()*4));
        }

        public String engAnswer(){
            return answer.getEng();
        }

        public boolean isAnswer(int selectedNum){
            return answer.isWord(problemView.get(selectedNum-1).getKor());
        }

        public List<String> korView(){
            List<String> korView = problemView.stream()
                    .map(word->word.getKor()).collect(Collectors.toList());

            return korView;
        }
    }

    class Word{
        private String kor;
        private String eng;

        public Word(String kor, String eng){
            this.kor = kor;
            this.eng = eng;
        }

        public String getKor() {
            return kor;
        }

        public String getEng() {
            return eng;
        }

        public boolean isWord(String kor){
            return this.kor == kor;
        }

        public static Word createWord(String engAndKor){
            String kor = engAndKor.split(" ")[1];
            String eng = engAndKor.split(" ")[0];
            WordGame wordGame = new WordGame();
            return wordGame.new Word(kor,eng);
        }

    }
}
