import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myList.add(i);
        }

        Stream<Integer> sequentialStream = myList.stream();

        Stream<Integer> parallelStream = myList.parallelStream();

        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);

        highNums.forEach(p -> System.out.println("High Nums parallel " + p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential " + p));

        System.out.println(sumIterator(myList));
        System.out.println(sumIteratorStream(myList));
        System.out.println(sumIteratorStream2(myList));

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
        List<Integer> integerList = intStream.collect(Collectors.toList());
        System.out.println(integerList);

        intStream = Stream.of(5, 6, 7, 8);
        Map<Integer, Integer> integerMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
        System.out.println(integerMap);


        Stream<Integer> intStream2 = Stream.of(10, 20, 30, 40);
        Integer[] arr = intStream2.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

        List<Integer> myList2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) myList2.add(i);
        Stream<Integer> sequentialStream2 = myList2.stream();
        Stream<Integer> nums = sequentialStream2.filter(i -> i < 90);
        System.out.print("nums greater than 90=");
        nums.forEach(p -> System.out.print(p + ","));

        System.out.println();
        Stream<String> names = Stream.of("ok", "vk", "fb","ozon");
        System.out.println(names.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList()));


        Stream<String> names2 = Stream.of("abc", "efg", "123456");
        List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted);

        Stream<String> names3 = Stream.of("jij", "Car", "800=");
        List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
        System.out.println(naturalSorted);

        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Davit"),
                Arrays.asList("Axas","Serob"),
                Arrays.asList("Yusuf"),
                Arrays.asList("Den")
        );
        //flat the stream from List<String> to String stream

        Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());
        flatStream.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(5,6,8,9,14);
        Optional<Integer>integerOptional = numbers.stream().reduce((i,j) -> {return i * j;});
        if (integerOptional.isPresent()){
            System.out.println(integerOptional.get());
        }

        System.out.println(numbers.stream().count());

        numbers.forEach(i -> System.out.print(i + ","));

        System.out.println();
        System.out.println(numbers.stream().anyMatch( i -> i == 8));
        System.out.println(numbers.stream().noneMatch(i -> i ==10));
        System.out.println(numbers.stream().allMatch(i -> i < 12));


        Stream<String> names8 = Stream.of("Anya","Didulya","Ennio","Dan");
        Optional<String> firstNameWithD = names8.filter(i -> i.startsWith("D")).findFirst();
        firstNameWithD.ifPresent(System.out::println);



    }

    private static int sumIterator(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    private static int sumIteratorStream(List<Integer> list) {
        return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
    }

    private static int sumIteratorStream2(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).mapToInt(i -> i).sum();
    }

    Stream<Integer> stream = Stream.of(1, 2, 3, 4);
    Stream<Integer> arrayStream = Stream.of(new Integer[]{1, 2, 3, 4,});
    //Compile time error, Type mismatch: cannot convert from Stream<int[]> to Stream<Integer>
    //Stream<Integer> arrayStream = Stream.of(new int[]{1,2,3,4});

    //methods generate() and iterate() for create Stream
    Stream<String> stream1 = Stream.generate(() -> {
        return "abc";
    });
    Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
    //Arrays.stream() and chars()
    LongStream is = Arrays.stream(new long[]{1, 2, 3, 4});
    IntStream is2 = "abc".chars();
}
