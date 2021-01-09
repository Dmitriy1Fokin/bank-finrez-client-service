package ru.fdo.bank.finrez.clientservice.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualUpdateDto
import ru.fdo.bank.finrez.clientservice.service.ClientService
import java.util.UUID
import java.util.concurrent.CompletableFuture

import javax.validation.Valid


@RestController
@RequestMapping("/client/cmd")
class ClientController(private val clientService: ClientService) {

    @PostMapping("/create/corp")
    fun createClientCorp(@Valid @RequestBody clientCorpNewDto : ClientCorpNewDto) : CompletableFuture<UUID> =
        clientService.createClientCorp(clientCorpNewDto)

    @PutMapping("/update/corp")
    fun updateClientCorp(@Valid @RequestBody clientCorpUpdateDto: ClientCorpUpdateDto) : CompletableFuture<UUID> =
            clientService.updateClientCorp(clientCorpUpdateDto)

    @PostMapping("/create/ind")
    fun createClientIndividual(@Valid @RequestBody clientIndividualNewDto : ClientIndividualNewDto) : CompletableFuture<UUID> =
            clientService.createClientIndividual(clientIndividualNewDto)

    @PutMapping("/update/ind")
    fun updateClientIndividual(@Valid @RequestBody clientIndividualUpdateDto: ClientIndividualUpdateDto) : CompletableFuture<UUID> =
            clientService.updateClientIndividual(clientIndividualUpdateDto)
}