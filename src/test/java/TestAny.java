import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAny {
    @Test
    public void testArrayList(){
        int nums =10;
        List<Integer> ranks = new ArrayList<>(Arrays.asList(new Integer[nums]));

        System.out.println(ranks.get(2));
    }
}
