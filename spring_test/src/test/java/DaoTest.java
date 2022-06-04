import com.dustin.dao.RoleDao;
import com.dustin.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Classname DaoTest
 * @Descrption 测试Dao
 * @Date 2021/7/24上午 05:54
 * @Created By Dustin_Peng
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class DaoTest {
    @Autowired
    private RoleDao roleDao;
    @Test
    public void testConnection(){
        List<Role> all = roleDao.findAll();
        System.out.println(all);

    }
}
