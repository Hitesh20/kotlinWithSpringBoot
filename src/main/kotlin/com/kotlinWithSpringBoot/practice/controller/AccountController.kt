package com.kotlinWithSpringBoot.practice.controller

import com.fasterxml.jackson.databind.util.JSONPObject
import com.kotlinWithSpringBoot.practice.model.Account
import com.kotlinWithSpringBoot.practice.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(
    private val accountService: AccountService
) {
    @PostMapping("/create")
    fun createAccount(@RequestBody account: Account): ResponseEntity<Any> {
        val response = try {
            accountService.createAccount(account)
        } catch (exception: Exception) {
            exception.message
        }
        val jsonObject: JSONPObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/fetchAll")
    fun fetchAll(): ResponseEntity<JSONPObject> {
        val response = accountService.fetchAll()
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/fetchRange")
    fun fetchRange(@RequestParam min: Int, @RequestParam max: Int): ResponseEntity<JSONPObject> {
        val response = accountService.fetchRange(min, max)
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/fetchRangePositional")
    fun fetchRangePositional(@RequestParam min: Int, @RequestParam max: Int): ResponseEntity<JSONPObject> {
        val response = accountService.fetchRangePositional(min, max)
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/nativeQueryExample")
    fun fetchRangePositional(): ResponseEntity<JSONPObject> {
        val accountNumbers = listOf("123456", "56789", "98765")
        val response = accountService.nativeQueryExample(accountNumbers)
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/selectQuery")
    fun selectQuery(): ResponseEntity<JSONPObject> {
        val response = accountService.selectQuery()
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }

    @GetMapping("/getTotal")
    fun getTotal(): ResponseEntity<JSONPObject> {
        val response: Int = accountService.getTotal()
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }



}