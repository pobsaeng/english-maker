package com.web.english.models

public class Customer(val name: String){

    init {
        println("First initializer block that prints ${name}!")
    }

    constructor(name: String, parent: Person) : this(name) {

    }

}