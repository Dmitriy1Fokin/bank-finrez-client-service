package ru.fdo.bank.finrez.clientservice.coreapi.event

import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import java.util.UUID

data class ClientCorpCreatedEvent(val createClientCorpCommandId: UUID, val clientCorpNewDto: ClientCorpNewDto)