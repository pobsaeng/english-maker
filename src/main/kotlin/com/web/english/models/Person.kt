package com.web.english.models

public class Person {
    constructor(firstName: String)
    constructor(firstName: String, lastName: String, age: Int)

    fun printHello(name: Any?, title: String?): Unit {
        println(name)
        println(title)

        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
    }
}

