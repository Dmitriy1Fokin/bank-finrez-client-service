package ru.fdo.bank.finrez.clientservice.service

import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualUpdateDto
import java.util.*
import java.util.concurrent.CompletableFuture

interface ClientService {
    fun createClientCorp(clientCorpNewDto: ClientCorpNewDto): CompletableFuture<UUID>
    fun updateClientCorp(clientCorpUpdateDto: ClientCorpUpdateDto): CompletableFuture<UUID>
    fun createClientIndividual(clientIndividualNewDto: ClientIndividualNewDto): CompletableFuture<UUID>
    fun updateClientIndividual(clientIndividualUpdateDto: ClientIndividualUpdateDto): CompletableFuture<UUID>
}