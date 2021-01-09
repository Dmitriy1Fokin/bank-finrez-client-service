package ru.fdo.bank.finrez.clientservice.dto

import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ClientIndividualUpdateDto(@field:NotNull val clientId: String,
                                     @field:NotBlank val lastName: String,
                                     @field:NotBlank val firstName: String,
                                     val middleName: String,
                                     @field:NotBlank val citizenship: String,
                                     @field:NotNull val birthday: LocalDate,
                                     @field:NotBlank val passport: String)