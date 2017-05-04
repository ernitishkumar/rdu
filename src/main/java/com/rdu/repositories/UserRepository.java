package com.rdu.repositories;

import com.rdu.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by NITISH on 04-05-2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    public User findByUsername(String username);

    public User findByUsernameAndPassword(String username,String password);
}
