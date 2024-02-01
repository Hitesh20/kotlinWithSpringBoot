package com.kotlinWithSpringBoot.practice.repository

import com.kotlinWithSpringBoot.practice.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<Account, Int> {
    fun findByAccountNumber(number: String): Account?

    // named parameter example
    // SELECT * FROM EMPLOYEE e WHERE e.id >= min and e.id <= max
    @Query("FROM Account WHERE id >= :min AND id <= :max") // use variables declared in entity class only
    fun fetchByRange(min: Int, max: Int): MutableList<Account>?

    // positional parameter example
    @Query("FROM Account WHERE id >= ?1 AND id <= ?2") // use variables declared in entity class only
    fun fetchByRangePositional(min: Int, max: Int): MutableList<Account>?


    // writing native query
    @Query(value = "Select * from account where account_number in ?1", nativeQuery = true) // here use table name and colums as is... Not of entity // can use named parameters as well
    fun findAccountByAccountNumber(accountNumbers: List<String>): List<Account>

    // fetch selected columns
    @Query("SELECT id, accountNumber FROM Account where accountNumber in (?1, ?2, ?3) order by id desc")
    fun fetchSelectedColumns(acc1: String, acc2: String, acc3: String): List<Any>

    @Query("SELECT count(*) FROM Account")
    fun getTotal(): Int
}