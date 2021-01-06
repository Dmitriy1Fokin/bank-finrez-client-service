package ru.fdo.bank.finrez.clientservice.coreapi.event

import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto

data class ClientCorpUpdatedEvent(val clientCorpUpdateDto: ClientCorpUpdateDto)