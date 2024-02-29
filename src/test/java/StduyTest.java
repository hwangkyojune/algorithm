import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StduyTest {
    @Test
    public void indexOfTest(){
        String intString = "66666";
        System.out.println(intString.indexOf("666"));
        System.out.println(intString.lastIndexOf("666"));
    }

    @Test
    public void integerArraySort(){
        Integer[] integerArray = {1,2,3,4,5,6,7,8,9};

        Arrays.sort(integerArray,(e1,e2)->Integer.compare(e2,e1));

        System.out.println(Arrays.toString(integerArray));
    }
}
