package dyliang.config;

import dyliang.condition.MyCondition1;
import dyliang.domain.Book;
import dyliang.domain.Person;
import dyliang.domain.Player;
import dyliang.service.AccountService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Configuration
//@ComponentScan(basePackages = {"dyliang"},
//        useDefaultFilters = false,
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})}
//)

//@ComponentScan(basePackages = {"dyliang"},
//        useDefaultFilters = false,
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {AccountService.class}),
//                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}
//)
//@ComponentScan(basePackages = {"dyliang"})
@Import(value = {Book.class, Player.class})
public class MyConfig1 {

    @Bean("person")
    @Scope(value = "SCOPE_PROTOTYPE")
    @Lazy
    @Conditional(MyCondition1.class)
    public Person person(){
//        return new Person().builder().name("Kobe").age(24).build();
        return new Person();
    }

//    @Bean("book")
//    @Scope(value = "SCOPE_PROTOTYPE")
//    @Conditional(MyCondition1.class)
//    public Book book(){
//        return new Book();
//    }
//
//    @Bean("player")
//    @Conditional(MyCondition1.class)
//    public Player player(){
//        return new Player();
//    }

}
