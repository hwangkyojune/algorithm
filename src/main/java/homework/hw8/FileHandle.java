package homework.hw8;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class FileHandle {
    public static List<String> properties = Arrays.asList("name","kor","eng","math");
    public static void main(String[] args) {
        FileHandle fileHandle = new FileHandle();
        try{
            FileWriter fileWriter = new FileWriter("D:\\algorithm\\src\\main\\java\\homework\\hw8\\student");
            Scanner scanner = new Scanner(System.in);
            fileWriter.write(properties.stream().reduce("",(string,property)->string+String.format("%-5s",property))+"\n");
            while(true) {
                String onePeopleProperty = fileHandle.readOnePeople(scanner);
                if (onePeopleProperty == null) {
                    break;
                }
                fileWriter.write(onePeopleProperty);
                fileWriter.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        try{
            FileReader fileReader = new FileReader("D:\\algorithm\\src\\main\\java\\homework\\hw8\\student");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            System.out.println(String.format("%s%5s%5s",line,"sum","ave"));
            while((line = bufferedReader.readLine())!=null){
                int sum = fileHandle.sum(line);
                double avg = fileHandle.avg(line);
                System.out.println(String.format("%s%-5d%.1f",line,sum,avg));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String readOnePeople(Scanner scanner){
        StringBuffer stringBuffer = new StringBuffer();
        for(String property:properties){
            String propertyContent = readOneProperty(scanner,property);
            if(propertyContent.equals("그만")){
                return null;
            }
            stringBuffer.append(String.format("%-5s",propertyContent));
        }
        stringBuffer.append("\n");
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }

    public String readOneProperty(Scanner scanner,String property){
        System.out.print(String.format("%s :",property));

        return scanner.nextLine();
    }

    public List<Integer> lintToList(String line){
        List<Integer> scores = Arrays.stream(line.split("\\s+"))
                .skip(1)
                .map(Integer::parseInt).collect(Collectors.toList());

        return scores;
    }

    public int sum(String line){
        List<Integer> integers = lintToList(line);

        return integers.stream().mapToInt(Integer::valueOf).sum();
    }

    public double avg(String line){
        List<Integer> integers = lintToList(line);

        return integers.stream().mapToInt(Integer::valueOf).sum()/(double)integers.size();
    }
}
