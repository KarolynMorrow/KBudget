package org.launchcode.KBudget.Models.data;

import org.launchcode.KBudget.Models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends CrudRepository<Bill, Integer> {
}
