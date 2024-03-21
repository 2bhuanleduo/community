package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
// @Primary 注解用来表示当通过AlphaDao.class 接口名来获取bean时，优先选择当前bean
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String Select() {
        return "Mybatis";
    }
}
