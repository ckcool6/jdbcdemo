package proxy;

public class Student implements StudentInterface{
    public void study() {
        System.out.println("学Java");
    }

    public void eat(String food) {
        System.out.println("吃" + food);
    }
}
