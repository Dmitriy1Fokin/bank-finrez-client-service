package ru.fdo.bank.finrez.clientservice.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.service.ClientService
import java.util.UUID
import java.util.concurrent.CompletableFuture

import javax.validation.Valid


@RestController
@RequestMapping("/client")
class ClientController(private val clientService: ClientService) {

    @PostMapping("/create")
    fun createClient(@Valid @RequestBody clientCorpNewDto : ClientCorpNewDto) : CompletableFuture<UUID> =
        clientService.createClientCorp(clientCorpNewDto)
}