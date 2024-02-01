package com.kotlinWithSpringBoot.practice.repository

import com.kotlinWithSpringBoot.practice.model.Bank
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BankRepository: JpaRepository<Bank, Int> {
    fun findByName(name: String): Bank?
    fun findByNameAndLocation(name: String, location: String): Bank?
    @Query("UPDATE Bank SET transactionFee = :fees WHERE id = :bankId")
    @Modifying // for non select query... we have to provide this annotation
    @Transactional // for non select query... we have to provide this annotation
    fun updateTransactionFees(bankId: Int, fees:Double)
}