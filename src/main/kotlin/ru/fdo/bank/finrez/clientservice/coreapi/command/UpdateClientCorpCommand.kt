package ru.fdo.bank.finrez.clientservice.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto

data class UpdateClientCorpCommand(@TargetAggregateIdentifier val clientId: String,
                                   val clientCorpUpdateDto: ClientCorpUpdateDto)
