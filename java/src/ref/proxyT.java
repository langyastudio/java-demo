package ref;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyT {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("morning"))
                {
                    System.out.println("morning " + args[0]);
                }

                return null;
            }
        };

        Hello ins = (Hello)Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);

        ins.morning("hello");
    }
}

interface Hello{
    void morning(String name);
}