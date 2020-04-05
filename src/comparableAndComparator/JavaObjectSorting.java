package comparableAndComparator;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaObjectSorting {
    public static void main(String[] args) {
        int [] intArr = {5,91,10,45};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        String[] strArr = {"c","a","e","b","d"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        List<String> stringList = new ArrayList<>();
        stringList.add("B");
        stringList.add("E");
        stringList.add("A");
        stringList.add("D");
        stringList.add("C");

        Collections.sort(stringList);
        for (String s : stringList) {
            System.out.println(" " + s);
        }
    }
}
