package com.phil.controller;

import com.phil.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import com.phil.persistence.entity.Expense;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService service;


    public ExpenseController(ExpenseService service){
        this.service = service;
    }

//    💡 Rule of thumb
//
//    Create an endpoint when:
//
//    the frontend/user needs some action or data from backend
    //endpoint: a combinatin of HTTP method + a path
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
        sb.append("Category: ").append(expense.getCategory()).append("\n");
        System.out.println(sb.toString());
        return service.addExpense(expense);
    }

    @GetMapping("/expenses/total")
    public double getSum(){
            return service.getTotal();
    }

    @DeleteMapping("expenses/{id}")
    public void deleteExpense(@PathVariable Long id){
        service.deleteExpense(id);
    }




}