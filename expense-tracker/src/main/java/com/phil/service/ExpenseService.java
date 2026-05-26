package com.phil.service;

import com.phil.persistence.entity.Expense;
import com.phil.persistence.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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

    public double getTotal(){
        List<Expense> expenses = repository.findAll();
        double sum = 0 ;

        for (Expense e : expenses){
            sum += e.getAmount();
        }


        return (double) Math.round(sum * 100) /100;
    }

    public void deleteExpense(Long id) {
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Expense not found");
        }

        repository.deleteById(id);
    }



}
