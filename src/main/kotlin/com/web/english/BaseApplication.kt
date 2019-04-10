package com.web.english

import com.web.english.classes.Utility
import com.web.english.models.Categories
import com.web.english.repository.CategoriesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource
import org.springframework.boot.CommandLineRunner


@SpringBootApplication
class EnglishMakerApplication {
    @Bean
    fun run(repository: CategoriesRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            println("CommandLineRunner1")
//            repository.save(Categories(null, "Tutorial 1"))
//            repository.save(Categories(null, "Tutorial 2"))
//            repository.save(Categories(null, "Tutorial 3"))
//            repository.save(Categories(null, "Tutorial 4"))
//            repository.save(Categories(null, "Tutorial 5"))

            repository.findAll().forEach(::println)
        }
    }

//    @Bean
//    fun init(repository: CategoriesRepository): CommandLineRunner {
//        return CommandLineRunner { args ->
//            println("CommandLineRunner2")
//            //            repository.save(Categories(null, "Tutorial 1"))
////            repository.save(Categories(null, "Tutorial 2"))
////            repository.save(Categories(null, "Tutorial 3"))
////            repository.save(Categories(null, "Tutorial 4"))
////            repository.save(Categories(null, "Tutorial 5"))
//
//            repository.findAll().forEach(::println)
//        }
//    }
}

fun main(args: Array<String>) {
    runApplication<EnglishMakerApplication>(*args)

//    var util = Utility()
//    println(util.randomText(5))

//    var map = Utility().readTextToMap("D:\\SpringOK\\english-maker\\src\\main\\resources\\message.text", null)
//    map.forEach{(k, v) -> println("key=$k, value=$v")}

//    val numbers = listOf(1, 2, 3, 4)
//    val strings = listOf("one", "two","three", "OK")
//    val numStrList = numbers.zip(strings)
//    println(numStrList)

//    val numbers = listOf(1, 2, 3)
//    val zipWithNextList = numbers.zipWithNext{a, b -> "${a} + ${b} = ${a + b}"}
//    println(zipWithNextList)

//    val map = mutableMapOf<String, String>()
//    map.put("db.username", "username")
//    map.put("db.password", "password")
//    map.put("db.driver", "org.postgresql.Driver")
//    map.put("db.url", "jdbc:postgresql://localhost/testdb")
//    val propertiesOfMap = map.toProperties()
//    propertiesOfMap.forEach{(k, v) -> println("key=$k, value=$v")}



}