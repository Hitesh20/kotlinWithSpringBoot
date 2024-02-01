package com.kotlinWithSpringBoot.practice.service.implementation

import com.kotlinWithSpringBoot.practice.model.Customer
import com.kotlinWithSpringBoot.practice.model.Service
import com.kotlinWithSpringBoot.practice.repository.CustomerRepository
import com.kotlinWithSpringBoot.practice.repository.ServiceRepository
import com.kotlinWithSpringBoot.practice.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired

@org.springframework.stereotype.Service
class ServiceServiceImplementation(
    @Autowired
    val serviceRepository: ServiceRepository,
    @Autowired
    val customerRepository: CustomerRepository
): ServiceService {
    override fun addServiceToEmployee(serviceId: Int, customerId: Int): Customer? {
        val customer = customerRepository.findById(customerId).get()
        val service = serviceRepository.findById(serviceId).get()
        var allServices = customer.services ?: mutableListOf<Service>()
        allServices.addLast(service)
        customer.services = allServices
        return customerRepository.save(customer)
    }

}