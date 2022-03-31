package org.launchcode.KBudget.Models.data;

import org.hibernate.annotations.SQLUpdate;
import org.launchcode.KBudget.KBudgetApplication;
import org.launchcode.KBudget.Models.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends CrudRepository<Bill, Integer> {

}
