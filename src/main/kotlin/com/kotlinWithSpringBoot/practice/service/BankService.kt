package com.kotlinWithSpringBoot.practice.service

import com.kotlinWithSpringBoot.practice.model.Bank
import org.springframework.stereotype.Service

@Service
interface BankService {
    fun registerBank(bankDetails: Bank): Bank
    fun updateBankDetails(id: Int, bankDetails: Any): Bank
    fun updateTransactionFees(bankId: Int, fees: Double)
}