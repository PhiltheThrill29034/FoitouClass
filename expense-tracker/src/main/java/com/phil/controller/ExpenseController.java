package com.phil.controller;

import com.phil.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.phil.persistence.entity.Expense;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService service;


    public ExpenseController(ExpenseService service){
        this.service = service;
    }

    @GetMapping("/expenses")
    public List<Expense> showExpenses() {
        return service.getAllExpenses();
    }

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense){
        service.addExpense(expense);
        StringBuilder sb = new StringBuilder();
        sb.append("Expense added:\n");
        sb.append("Title: ").append(expense.getTitle()).append("\n");
        sb.append("Amount: ").append(expense.getAmount()).append("\n");
        System.out.println(sb.toString());
        return service.addExpense(expense);
    }



}