package com.kotlinWithSpringBoot.practice.controller

import com.fasterxml.jackson.databind.util.JSONPObject
import com.kotlinWithSpringBoot.practice.model.Bank
import com.kotlinWithSpringBoot.practice.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bank")
class BankController(
    @Autowired
    private val bankService: BankService
) {

    @PostMapping("/registerBank")
    fun registerBank(@RequestBody bankDetails: Bank): ResponseEntity<Any> {
        val response: Any? = try {
            bankService.registerBank(bankDetails)
        } catch (exception: Exception) {
            exception.message
        }
        val jsonObject: JSONPObject = JSONPObject("message", response);
        return ResponseEntity<Any>(jsonObject, HttpStatus.OK)
    }

    @PatchMapping("/updateBankDetails/{id}")
    fun updateBankDetails(@PathVariable("id") bankId: Int, @RequestBody bankDetails: Any): ResponseEntity<Any> {
        val response: Any? = try {
            bankService.updateBankDetails(bankId, bankDetails)
        } catch (exception: Exception) {
            exception.message
        }
        val jsonObject: JSONPObject = JSONPObject("message", response);
        return ResponseEntity<Any>(jsonObject, HttpStatus.OK)
    }

    @PatchMapping("/updateFees/{id}")
    fun updateBankDetails(@PathVariable("id") bankId: Int, @RequestParam fees: Double): ResponseEntity<Any> {
        val response: Any? = try {
            bankService.updateTransactionFees(bankId, fees)
        } catch (exception: Exception) {
            exception.message
        }
        val jsonObject: JSONPObject = JSONPObject("message", response);
        return ResponseEntity<Any>(jsonObject, HttpStatus.OK)
    }
}