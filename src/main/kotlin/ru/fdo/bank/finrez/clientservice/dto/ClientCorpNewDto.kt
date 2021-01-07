package ru.fdo.bank.finrez.clientservice.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class ClientCorpNewDto(@field:NotBlank val name: String,
                            @field:NotBlank val orgForm: String,
                            @field:NotBlank val abbreviatedName: String,
                            @field:Pattern(regexp = "[0-9]{10}", message = "Incorrect value") val inn: String,
                            @field:Pattern(regexp = "[0-9]{9}", message = "Incorrect value") val kpp: String,
                            @field:Pattern(regexp = "[0-9]{13}", message = "Incorrect value") val ogrn: String,
                            @field:Pattern(regexp = "[0-9]{10}", message = "Incorrect value") val okpo: String,
                            @field:Pattern(regexp = "[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}", message = "Incorrect value") val okved: String,
                            @field:NotBlank val addressU: String,
                            @field:NotBlank val addressF: String,
                            @field:Email val email: String)