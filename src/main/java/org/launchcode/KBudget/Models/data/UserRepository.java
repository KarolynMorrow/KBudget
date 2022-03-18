package org.launchcode.KBudget.Models.data;

import org.launchcode.KBudget.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
