package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        Student stu = new Student();
        //stu.eat("米饭");
        //stu.study();
        //动态代理
        StudentInterface proxyStu = (StudentInterface) Proxy.newProxyInstance(
                stu.getClass().getClassLoader(),
                new Class[]{StudentInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("study")) {
                            System.out.println("学python");
                            return null;
                        } else {
                            return method.invoke(stu, args);
                        }
                    }
                }
        );
        proxyStu.study();
    }
}
