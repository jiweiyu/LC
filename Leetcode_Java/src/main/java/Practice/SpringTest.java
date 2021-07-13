package Practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args){
        double x = 5;
        System.out.println("hello: " + x * 10);

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
        obj1.setStr("I'm Obj1");
        System.out.println(obj1);


        HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
        System.out.println(obj2);

        System.out.println(obj1.equals(obj2));

        context.registerShutdownHook();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigBean.class);
        HelloWorld javaConfigBean = ctx.getBean(HelloWorld.class);
        javaConfigBean.setStr("test java config");
        System.out.println(javaConfigBean);
    }

}
