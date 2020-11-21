package pl.sda.zdjavapol4.jav_demo;


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
    }
}
