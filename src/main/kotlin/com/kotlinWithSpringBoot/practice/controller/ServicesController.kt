package com.kotlinWithSpringBoot.practice.controller

import com.fasterxml.jackson.databind.util.JSONPObject
import com.kotlinWithSpringBoot.practice.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service")
class ServicesController(
    @Autowired
    val service: ServiceService
) {

    @PostMapping("/addService")
    fun addServices(@RequestParam serviceId: Int, @RequestParam customerId: Int): ResponseEntity<JSONPObject> {
        val response = try { service.addServiceToEmployee(serviceId, customerId) } catch (exception: Exception) {
            exception.message
        }
        val jsonObject = JSONPObject("message", response)
        return ResponseEntity(jsonObject, HttpStatus.OK)
    }
}