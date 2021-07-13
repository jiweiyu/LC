package Practice;

import org.springframework.context.annotation.*;

@Configuration
public class JavaConfigBean {

    @Bean
    public HelloWorld javaConfigBean(){
        return new HelloWorld();
    }


}
