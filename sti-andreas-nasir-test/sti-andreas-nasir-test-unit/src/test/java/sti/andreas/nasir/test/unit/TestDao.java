package sti.andreas.nasir.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.andreas.nasir.dao.stiAndreasNasirDao;

public class TestDao {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:sti-Andreas-Nasir-Dao-Impl.xml");

    @Test
    public void testGetConnection(){
        stiAndreasNasirDao stiandreasnasirdao = (stiAndreasNasirDao) context.getBean("sANDao");
        Assert.assertNotNull(stiandreasnasirdao);

    }


}
