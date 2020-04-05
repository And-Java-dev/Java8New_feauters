package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaExpressionExample {

//    () -> {}                     // No parameters; void result
//
//() -> 42                     // No parameters, expression body
//() -> null                   // No parameters, expression body
//() -> { return 42; }         // No parameters, block body with return
//() -> { System.gc(); }       // No parameters, void block body

//Complex block body with multiple returns
//() -> {
//  if (true) return 10;
//  else {
//    int result = 15;
//    for (int i = 1; i < 10; i++)
//      result *= i;
//    return result;
//  }
//}
//
//(int x) -> x+1             // Single declared-type argument
//(int x) -> { return x+1; } // same as above
//(x) -> x+1                 // Single inferred-type argument, same as below
//x -> x+1                   // Parenthesis optional for single inferred-type case
//
//(String s) -> s.length()   // Single declared-type argument
//(Thread t) -> { t.start(); } // Single declared-type argument
//s -> s.length()              // Single inferred-type argument
//t -> { t.start(); }          // Single inferred-type argument
//
//(int x, int y) -> x+y      // Multiple declared-type parameters
//(x,y) -> x+y               // Multiple inferred-type parameters
//(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
//(x, int y) -> x+y          // Illegal: can't mix inferred and declared types


    //Method and Constructor References

//System::getProperty
//System.out::println
//"abc"::length
//ArrayList::new
//int[]::new

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,0,50,600,200,152,14,20,23,63,655,222,10,52,36);
        //sum of all numbers
       int i = sumWithCondition(numbers, n-> true);
        //sum of all even numbers
      int d =  sumWithCondition(numbers,n-> n%2==0);
        //sum of all numbers greater than 5
       int a = sumWithCondition(numbers, n-> n > 5);
        System.out.println(i + " " + d + " " + a);
    }

    public static int sumWithCondition(List<Integer>numbers, Predicate<Integer>predicate){
        return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
    }


    //Traditional approach
//    private static boolean isPrime(int number) {
//        if(number < 2) return false;
//        for(int i=2; i<number; i++){
//            if(number % i == 0) return false;
//        }
//        return true;
//    }

    //method isPrime by lambda
    private static boolean isPrime ( int number){
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
    }

}
