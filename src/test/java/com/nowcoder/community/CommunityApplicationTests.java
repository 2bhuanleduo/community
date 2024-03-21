package com.nowcoder.community;

import com.nowcoder.community.config.AlphaConfig;
import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.AlphaDaoHibernateImpl;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 获取Spring容器并赋给本地applicationContext变量
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {
        System.out.println(this.applicationContext);
        // 通过接口名称来获取bean
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.Select());
        // 通过实现类名称获取bean
        AlphaDaoHibernateImpl alphaDaoHibernate = applicationContext.getBean(AlphaDaoHibernateImpl.class);
        System.out.println(alphaDaoHibernate.Select());
        // 当在实现类中使用 @Repository("alphaDaoHibernate")注解为AlphaDaoHibernateImpl实现类设置名称后，
        // 可以使用"alphaDaoHibernate"名称来获取bean
        alphaDao = applicationContext.getBean("alphaDaoHibernate", AlphaDao.class);
        System.out.println(alphaDao.Select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig() {
        // 主动获取外部第三方依赖包的方式
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    @Qualifier("alphaDaoHibernate")
    private AlphaDao alphaDaoHibernate;

    @Autowired
    private AlphaService alphaService;

    @Test
    public void testDI() {
        System.out.println(alphaDao.Select());
        System.out.println(alphaDaoHibernate.Select());
        System.out.println(alphaService);
    }


}
