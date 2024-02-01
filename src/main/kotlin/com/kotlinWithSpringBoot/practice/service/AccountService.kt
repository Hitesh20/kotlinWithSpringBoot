package com.kotlinWithSpringBoot.practice.service

import com.kotlinWithSpringBoot.practice.model.Account
import com.mysql.cj.exceptions.MysqlErrorNumbers
import org.springframework.stereotype.Service

@Service
interface AccountService {
    fun createAccount(account: Account): Account
    fun fetchAll(): MutableList<Account>?
    fun fetchRange(min: Int, max: Int): MutableList<Account>?
    fun fetchRangePositional(min: Int, max: Int): MutableList<Account>?
    fun nativeQueryExample(acountNumbers: List<String>): List<Account>
    fun selectQuery(): List<Any>
    fun getTotal(): Int
}