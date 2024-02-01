package com.kotlinWithSpringBoot.practice.service.implementation

import com.kotlinWithSpringBoot.practice.model.Account
import com.kotlinWithSpringBoot.practice.model.Bank
import com.kotlinWithSpringBoot.practice.repository.AccountRepository
import com.kotlinWithSpringBoot.practice.repository.BankRepository
import com.kotlinWithSpringBoot.practice.service.AccountService
import com.zaxxer.hikari.util.IsolationLevel
import com.zaxxer.hikari.util.IsolationLevel.TRANSACTION_READ_COMMITTED
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountServiceImplementation(
    @Autowired
    private val accountRepository: AccountRepository,
    @Autowired
    private val bankRepository: BankRepository
): AccountService {

    override fun createAccount(account: Account): Account {
        val existingAccount: Account? = accountRepository.findByAccountNumber(account.accountNumber)
        if(existingAccount != null) {
            throw Exception("Account already exists");
        }
        return accountRepository.save(account)
    }

    @org.springframework.transaction.annotation.Transactional
    override fun createAccountTransactional(account: Account): Account {
        val bank = Bank(id = 1000, name = "World Bank ${account.accountNumber}", location = "USA", transactionFee = 100.0)
        bankRepository.save(bank)
        val existingAccount: Account? = accountRepository.findByAccountNumber(account.accountNumber)
        if(existingAccount != null) {
            throw Exception("Account already exists");
        }
        return accountRepository.save(account)
    }

    override fun fetchAll(): MutableList<Account> {
        return accountRepository.findAll()
    }

    override fun fetchRange(min: Int, max: Int): MutableList<Account>? {
        return accountRepository.fetchByRange(min, max)
    }

    override fun fetchRangePositional(min: Int, max: Int): MutableList<Account>? {
        return accountRepository.fetchByRangePositional(min, max)
    }

    override fun nativeQueryExample(acountNumbers: List<String>): List<Account> {
        return accountRepository.findAccountByAccountNumber(acountNumbers)
    }

    override fun selectQuery(): List<Any> {
        return accountRepository.fetchSelectedColumns("123456", "56789", "98765")
    }

    override fun getTotal(): Int {
        return accountRepository.getTotal()
    }

}
