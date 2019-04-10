package com.web.english.repository

import com.web.english.models.Categories
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository: JpaRepository<Categories, Long> {
    @Query(value = "SELECT * FROM Categories", nativeQuery = true)
    fun findAllCategories(listOfCategories: List<String>) {}
}