import com.dustin.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname SpringTest
 * @Descrption TODO
 * @Date 2021/7/24下午 09:27
 * @Created By Dustin_Peng
 */
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext("spring-mvc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }
}
