import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

    public static void main(String[] args) {
        //creating sample Collection
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            myList.add(i);
        }
        //this is a while
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()){
            int i = it.next();
            System.out.println("Iterator vlue >>>> " + i);
        }
        //this is a forEach
        for (int i : myList) {
            System.out.println("Iterator vlue >>>> " + i);
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println("forEach anonymous class Value::"+integer);
            }
        });

        //traversing through forEach method of Iterable with anonymous class by Lambda
        myList.forEach(integer -> System.out.println("forEach anonymous class Value::"+integer));

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }

    //Consumer implementation that can be reused
    static class MyConsumer implements Consumer<Integer>{

        @Override
        public void accept(Integer integer) {
            System.out.println("Consumer impl value >>>> " + integer);
        }
    }
}
