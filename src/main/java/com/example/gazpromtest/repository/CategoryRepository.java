package com.example.gazpromtest.repository;

import com.example.gazpromtest.model.Category;
import com.example.gazpromtest.model.CountForCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new com.example.gazpromtest.model.CountForCategory(c.category, COUNT(c.category))" + "FROM Category AS c GROUP BY c.category")
    List<CountForCategory> getStatisticCategories();
}
