package com.kotlinWithSpringBoot.practice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
@Table
@Nullable
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Int,
    val name: String,
    @ManyToMany(cascade = [CascadeType.ALL])
    var services: List<Service>?,
//
//    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "customer")
//    val account: Account
) {
}