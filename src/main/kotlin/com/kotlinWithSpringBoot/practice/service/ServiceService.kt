package com.kotlinWithSpringBoot.practice.service

import com.kotlinWithSpringBoot.practice.model.Customer
import org.springframework.stereotype.Service

@Service
interface ServiceService {
    fun addServiceToEmployee(serviceId: Int, customerId: Int): Customer?
}