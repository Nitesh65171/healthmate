package com.nitesh.healthmate.hospitalsection.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlertRequest(

    val alertId: String,                     // unique alert id
    val patientId: String?,                  // linked customer/patient id
    val patientName: String?,                // quick display
    val age: Int?,

    val severityLevel: Int,                  // 1=Normal 2=Urgent 3=Emergency
    val emergencyType: String?,              // accident, cardiac, trauma etc
    val diagnosis: String?,                  // optional quick diagnosis

    val description: String?,                // user entered notes
    val symptoms: List<String>?,             // structured symptoms

    val latitude: Double,                    // live location
    val longitude: Double,
    val address: String?,                    // fallback readable location

    val contactNumber: String?,              // patient or relative
    val alternateContact: String?,

    val requestedHospitalId: String?,        // preferred hospital
    val assignedHospitalId: String?,         // after acceptance

    val assignedDoctorId: String?,           // after assignment
    val assignedAmbulanceId: String?,        // if ambulance required

    val status: AlertStatus,                 // request state
    val createdAt: Long,                     // timestamp
    val acceptedAt: Long?,
    val completedAt: Long?,

    val requiresAmbulance: Boolean = false,
    val requiresICU: Boolean = false,

    val attachments: List<String>?           // image/audio/video URLs
): Parcelable
