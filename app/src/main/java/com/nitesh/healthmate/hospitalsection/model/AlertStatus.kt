package com.nitesh.healthmate.hospitalsection.model

enum class AlertStatus {
    PENDING,        // created but not accepted
    ACCEPTED,       // hospital accepted
    IN_PROGRESS,       // hospital accepted
    DISPATCHED,     // ambulance sent
    ARRIVING,       // patient en route
    ADMITTED,       // reached hospital
    COMPLETED,      // treatment done
    CANCELLED,
    REJECTED
}