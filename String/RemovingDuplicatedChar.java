package String;

import java.util.*;

public class RemovingDuplicatedChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        sc.close();

        char[] chars = string.toCharArray();

//        List<Character> cs = Arrays.asList(chars);
        List<Character> cs = Arrays.asList(new Character[]{'c','d'});



        List<char[]> ct = Arrays.asList(chars);



        List<char> hs = new ArrayList<Character>(Arrays.asList(chars));

        System.out.println(hs.toArray());


    }
}
