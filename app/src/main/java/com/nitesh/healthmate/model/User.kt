package com.nitesh.healthmate.model

data class User(val userId: String, val userPassword: String, val name: String, val userRole: UserRole) {
    override fun toString(): String {
        return "User(userId='$userId', name='$name', userRole=${userRole.name})"
    }
}
