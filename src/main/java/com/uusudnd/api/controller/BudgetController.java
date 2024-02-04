package com.uusudnd.api.controller;

import com.uusudnd.api.entity.Budget;
import com.uusudnd.api.exception.BudgetNotFound;
import com.uusudnd.api.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/budget")
public class BudgetController {

    @Autowired
    BudgetRepository budgetRepository;

    // get all
    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudget() {
        List<Budget> budget = new ArrayList<>();
        budgetRepository.findAll().forEach(budget::add);
        return new ResponseEntity<>(budget, HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
        Budget newBudget = new Budget(budget.getFunds(), budget.getGrants(), budget.getComment(), budget.getDate(), budget.getAuthor());
        budgetRepository.save(newBudget);
        return new ResponseEntity<>(newBudget, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Budget> deleteRecord (@PathVariable("id") Long id) {
        Optional<Budget> budgetData = budgetRepository.findById(id);
        if (budgetData.isPresent()) {
            budgetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new BudgetNotFound("Invalid Record Id");
        }
    }
}
