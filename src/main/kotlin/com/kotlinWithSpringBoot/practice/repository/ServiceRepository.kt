package com.kotlinWithSpringBoot.practice.repository

import com.kotlinWithSpringBoot.practice.model.Service
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository: JpaRepository<Service, Int> {
}