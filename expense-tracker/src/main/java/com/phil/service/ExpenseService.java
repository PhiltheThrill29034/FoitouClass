package com.phil.service;

import com.phil.persistence.entity.Expense;
import com.phil.persistence.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository){
        this.repository=repository;
    }

    public Expense addExpense(Expense ex) {
        if (ex.getAmount()<0){
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        return repository.save(ex); //returns saved entity
    }

    public List<Expense> getAllExpenses(){ return repository.findAll(); }



}
