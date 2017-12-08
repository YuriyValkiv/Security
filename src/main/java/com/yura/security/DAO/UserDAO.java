package com.yura.security.DAO;

import com.yura.security.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        if (user != null) session.delete(user);
    }

    public User getUser(int id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("name", name));
        List <User> user = criteria.list();
        return user;
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.clear();
        session.close();
    }

    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User userInDB = (User) session.get(User.class, user.getId());

        userInDB.setName(user.getName());
        userInDB.setFirstName(user.getFirstName());
        userInDB.setemail(user.getemail());
        userInDB.setPassword(user.getPassword());

        session.save(userInDB);
    }
}
