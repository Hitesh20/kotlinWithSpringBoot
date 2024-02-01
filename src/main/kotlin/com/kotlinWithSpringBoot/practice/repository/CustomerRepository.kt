package com.kotlinWithSpringBoot.practice.repository

import com.kotlinWithSpringBoot.practice.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Int> {
}