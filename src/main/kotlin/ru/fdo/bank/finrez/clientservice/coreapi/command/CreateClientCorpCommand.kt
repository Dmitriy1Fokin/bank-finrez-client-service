package ru.fdo.bank.finrez.clientservice.coreapi.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import java.util.UUID

data class CreateClientCorpCommand(@TargetAggregateIdentifier val createClientCorpCommandId: UUID,
                                   val clientCorpNewDto: ClientCorpNewDto)
