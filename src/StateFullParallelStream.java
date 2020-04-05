import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StateFullParallelStream {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,6,8,5,5,6,5,6,6,2,2,2,2,1,14,5,9,5,6,25,65,65,3);
        List<Integer> result = new ArrayList<>();

        Stream<Integer> integerStream = list.parallelStream();
        integerStream.map(s -> {
            synchronized (result) {
                if (result.size() < 10){
                    result.add(s);
                }
            }
            return s;
        }).forEach(e -> {});
        System.out.println(result);
    }
}
