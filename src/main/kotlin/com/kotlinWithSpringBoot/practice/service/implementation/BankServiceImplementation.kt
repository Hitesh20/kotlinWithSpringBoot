package com.kotlinWithSpringBoot.practice.service.implementation

import com.kotlinWithSpringBoot.practice.Exceptions.ResourceNotFoundException
import com.kotlinWithSpringBoot.practice.model.Bank
import com.kotlinWithSpringBoot.practice.repository.BankRepository
import com.kotlinWithSpringBoot.practice.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BankServiceImplementation(
    @Autowired
    val bankRepository: BankRepository
) : BankService {

    override fun registerBank(bankDetails: Bank): Bank {
        val existingBank: Bank? = bankRepository.findByNameAndLocation(bankDetails.name, bankDetails.location)
        if(existingBank != null) {
            throw Exception("Bank name and location can not be duplicate");
        }
        return bankRepository.save(bankDetails)
    }

    override fun updateBankDetails(id: Int, bankDetails: Any): Bank {
        var bankToUpdate: Bank = bankRepository.findById(id).orElseThrow { ResourceNotFoundException("Bank Resource Not Found for id $id") }
        val bank = bankDetails as Map<String, Any>
        if(bank.containsKey("name")) {
            bank.get("name")?.let { bankToUpdate.name = it.toString() }
        }
        if(bank.containsKey("location")) {
            bank.get("location")?.let {  bankToUpdate.location = it.toString() }
        }
        if(bank.containsKey("transactionFee")) {
            bank.get("transactionFee")?.let { bankToUpdate.transactionFee = it as Double }
        }
        return bankRepository.save(bankToUpdate)
    }

}