package com.nowcoder.community.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("alphaDaoHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String Select() {
        return "Hibernate";
    }
}
