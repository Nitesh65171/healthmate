package com.nitesh.healthmate.model

data class Customer(val customerId: String? = null, val name: String? = null,
                    val address: String, val diagnosis: String? = null, val email: String? = null,
                    val phone: String? = null, val age: Int, val diagnosisSeverityCode: Int? = 1, val treatmentSummary: String? = null)
