package mayidemo.bird.Proxy1;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Slf4j
public class Proxy1 {

    private AInter aInter = new AImpl();

    public AInter getProxy(){
        return (AInter)Proxy.newProxyInstance(Proxy1.class.getClassLoader(), aInter.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getName().equalsIgnoreCase("a")){
                    System.out.println("我是代理 ....");
                    return method.invoke(aInter,args);
                }
                return null;
            }
        });
    }


    public static void main(String[] args) {
        Proxy1 proxy1 = new Proxy1();
        AInter aInter = proxy1.getProxy();
        log.info("proxy1.getProxy() = {}" , aInter.toString());
        aInter.a();
    }


}
