package com.web.english.controllers

import com.web.english.models.Categories
import com.web.english.repository.CategoriesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import java.util.*
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.jdbc.core.JdbcTemplate
import javax.activation.DataSource
import java.util.UUID
import com.oracle.util.Checksums.update
import com.web.english.classes.Utility
import java.security.MessageDigest
import org.springframework.beans.factory.annotation.Qualifier



@RestController("/categories")
class CategoriesController (val repository: CategoriesRepository){

    @GetMapping("/create")
    fun save() {

    }

    @PutMapping("/update")
    fun updateCategories(@RequestBody categories: Categories) = repository.save(categories)

    @DeleteMapping("/delete/{id}")
    fun deleteCategories(@PathVariable id: Long) = repository.deleteById(id)

    @GetMapping("/findById/{id}")
    fun getCategories(@PathVariable id: Long): Optional<Categories> = repository.findById(id)

    @GetMapping("/findall")
    fun findAll() : List<Categories> { return repository.findAll() }

    @GetMapping("/findall/sortbycategoryname/desc")
    fun getAllCategoriesAndSort(): List<Categories> {
        val sortByCategoryNameDesc = Sort(Sort.Direction.DESC, "CategoryName")
        return repository.findAll(sortByCategoryNameDesc)
    }

    @GetMapping("/findpaged")
    fun getPaged(
            @RequestParam(value = "page", defaultValue = "0") page: Int,
            @RequestParam(value = "size", defaultValue = "10") size: Int): Page<Categories> {
        val pageable = PageRequest.of(0, 30, Sort.Direction.DESC)
        val page: Page<Categories> = repository.findAll(pageable)
        return page
    }
}
