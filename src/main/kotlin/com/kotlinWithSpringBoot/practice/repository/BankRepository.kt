package com.kotlinWithSpringBoot.practice.repository

import com.kotlinWithSpringBoot.practice.model.Bank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BankRepository: JpaRepository<Bank, Int> {
    fun findByName(name: String): Bank?
    fun findByNameAndLocation(name: String, location: String): Bank?
}