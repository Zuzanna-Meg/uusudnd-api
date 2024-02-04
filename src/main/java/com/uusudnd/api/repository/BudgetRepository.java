package com.uusudnd.api.repository;

import com.uusudnd.api.entity.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
}
