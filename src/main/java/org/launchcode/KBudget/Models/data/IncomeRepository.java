package org.launchcode.KBudget.Models.data;

import org.launchcode.KBudget.Models.Income;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Integer> {
}
