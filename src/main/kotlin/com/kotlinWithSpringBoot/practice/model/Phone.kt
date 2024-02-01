package com.kotlinWithSpringBoot.practice.model

import jakarta.persistence.*

@Entity
class Phone(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,
    var phoneNumber: String
) {
}