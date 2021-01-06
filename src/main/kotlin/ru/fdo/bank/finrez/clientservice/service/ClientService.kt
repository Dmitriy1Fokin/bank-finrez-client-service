package ru.fdo.bank.finrez.clientservice.service

import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import java.util.*
import java.util.concurrent.CompletableFuture

interface ClientService {
    fun createClientCorp(clientCorpNewDto: ClientCorpNewDto): CompletableFuture<UUID>
    fun updateClientCorp(clientCorpUpdateDto: ClientCorpUpdateDto): CompletableFuture<UUID>
}