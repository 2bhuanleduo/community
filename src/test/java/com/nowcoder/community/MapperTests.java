package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder102@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("zhangfei");
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setSalt("abc");
        user.setEmail("abc@163.com");
        user.setHeaderUrl("http://nowcoder.com/test.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
    }

    @Test
    public void testUpdate() {
        int row = userMapper.updateStatus(150, 1);
        System.out.println(row);

        row = userMapper.updateHeader(150, "http://nowcoder.com/test123.png");
        System.out.println(row);

        row = userMapper.updatePassword(150, "root");
        System.out.println(row);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testDiscussPost() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post: list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }


    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(121);
        loginTicket.setStatus(0);
        loginTicket.setTicket("abc");
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        String ticket = "abc";
        System.out.println(loginTicketMapper.selectByTicket(ticket));

        loginTicketMapper.updateStatus(ticket, 1);
        System.out.println(loginTicketMapper.selectByTicket(ticket));
    }

}
