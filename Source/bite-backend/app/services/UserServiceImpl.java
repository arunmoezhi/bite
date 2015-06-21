package services;
import models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(String userId) {
        User usr = new User();
        usr.userId = "12345";
        usr.name = "Daniel Jebakumar";
        usr.email = "me@daniepaul.com";
        usr.dob = "1986-01-10";
        usr.gender = 'M';
        return usr;
    }

    @Override
    public User getUser(String userName, String password) {
        User usr = new User();
        usr.userId = "12345";
        usr.name = "Daniel Jebakumar";
        usr.email = "me@daniepaul.com";
        usr.dob = "1986-01-10";
        usr.gender = 'M';
        return usr;
    }
}
