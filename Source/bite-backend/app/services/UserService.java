package services;


import entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }
}