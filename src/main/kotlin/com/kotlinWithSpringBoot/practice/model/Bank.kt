package com.kotlinWithSpringBoot.practice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
@Table
@Nullable
data class Bank(
    @Id
    @GeneratedValue
    val id: Int,
    var name: String,
    var location: String,
//    @JsonProperty("transaction_fees")
    var transactionFee: Double
) {

}