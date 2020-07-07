import dyliang.config.MyConfig1;
import dyliang.domain.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringAnnotationTest {

    @Test
    public void testConfig1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig1.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
//
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);
    }

}
