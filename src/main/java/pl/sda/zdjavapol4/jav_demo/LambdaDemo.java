package pl.sda.zdjavapol4.jav_demo;


import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("From MyRunnable class");
    }
}

interface MyInterface{
    void justDoIt();
}
@FunctionalInterface
interface StringToInt{
    int nameLenght(String name);
   default int nameAndSurnameLenght(String name, String surname){
       return -1;
   }
}

public class LambdaDemo {
    public static void main(String[] args) {
        Runnable job = new MyRunnable();

        job.run();

        Runnable job3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("From annonymous Runnable");
            }
        };
        job3.run();

        Runnable job2 = () -> {
            System.out.println("Hello from runnable lambda!!!");
        };

        MyInterface nike2 = () -> {
            System.out.println("hello from lambda");
        };
        StringToInt myName = (name) -> name.length();
        System.out.println(myName.nameAndSurnameLenght("Blazej", "Karnecki"));
        System.out.println(myName.nameLenght("Blazej"));


        Stream<Object> objects = Stream.of("mariusz", "marek", "adrianna", "zenon", "rysiek", "halina");
        Stream<String> names = Stream.of("mariusz", "marek", "adrianna", "zenon", "rysiek", "halina");


        names.filter(name -> name.length() > 6)
                .map(s -> s.length())
                .forEach(integer -> System.out.println("from Stream<String> name lenght: " + integer));

        objects.filter(o -> o instanceof String)
                .map(o -> (String)o)
                .map(s -> s.length())
                .forEach(integer -> System.out.println("name lenght: " + integer));
    }
}
