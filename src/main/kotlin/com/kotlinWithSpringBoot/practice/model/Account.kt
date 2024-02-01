package com.kotlinWithSpringBoot.practice.model

import jakarta.annotation.Nullable
import jakarta.persistence.*

@Entity
@Table
//@Nullable
data class Account(
    @Id
    @GeneratedValue
    private val id: Int,

    val accountNumber: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_fk_id") // creates foreign key in Account
//    @JoinTable(name = "account_customer",
//        joinColumns = @JoinColumn(name = "account_id"),
//        inverseJoinColumns = @JoinColumn(name = "customer_id")
//    )
    val customer: Customer,

//    @ManyToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "bank_fk_id")
//    val bank: Bank,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "phone_fk_id") // create foreign key on many side, i.e. Phone Side
    val phones: Array<Phone>

) {
}