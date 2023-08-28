package String;

import java.util.*;

public class RemovingDuplicatedChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        sc.close();

        char[] chars = string.toCharArray();
        List<Character> chList = new ArrayList<>();

        for(int i=0;i<chars.length;i++){
            chList.add(new Character(chars[i]));
        }

        Set<Character> set = new LinkedHashSet<>(chList);

        Iterator<Character> iter = set.iterator();

        while(iter.hasNext()){
            System.out.print(iter.next());
        }

    }
}
