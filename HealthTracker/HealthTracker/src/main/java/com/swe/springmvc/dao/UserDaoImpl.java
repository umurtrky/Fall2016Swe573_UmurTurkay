package com.swe.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 
import com.swe.springmvc.model.User;
 
 
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
     
    public User findById(int id) {
        User user = getByKey(id);
        if(user!=null){
            //Hibernate.initialize(user.getUserRoles());
        }
        return user;
    }
 
    public User findByUsername(String username) {
        logger.info("Username : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            //Hibernate.initialize(user.getUserRoles());
        }
        return user;
    }
 
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
        return users;
    }
 
    public void save(User user) {
        persist(user);
    }
 
    public void deleteByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        delete(user);
    }
 
}
