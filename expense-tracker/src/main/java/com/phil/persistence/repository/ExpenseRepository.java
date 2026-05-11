package com.phil.persistence.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.phil.persistence.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
