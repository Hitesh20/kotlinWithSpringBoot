package com.kotlinWithSpringBoot.practice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Service(
    @Id
    @GeneratedValue
    val id: Int,
    var name: String,
    var price: Double
) {

}