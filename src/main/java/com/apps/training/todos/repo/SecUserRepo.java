package com.apps.training.todos.repo;

import com.apps.training.todos.entity.SecUser;
import com.apps.training.todos.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecUserRepo extends JpaRepository<SecUser, Integer> {
    public List<SecUser> findByUserName(String userName);
}
