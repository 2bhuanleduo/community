package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("1045965658@qq.com", "TEST", "NEW");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "SJJ");
        String content = templateEngine.process("/mail/demo", context);

        System.out.println(content);
        mailClient.sendMail("1045965658@qq.com", "HTML", content);
    }

}
