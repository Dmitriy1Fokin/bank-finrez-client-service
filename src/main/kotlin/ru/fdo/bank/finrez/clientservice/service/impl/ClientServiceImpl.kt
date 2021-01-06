package ru.fdo.bank.finrez.clientservice.service.impl

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Service
import ru.fdo.bank.finrez.clientservice.coreapi.command.CreateClientCorpCommand
import ru.fdo.bank.finrez.clientservice.coreapi.command.UpdateClientCorpCommand
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import ru.fdo.bank.finrez.clientservice.service.ClientService
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Service
class ClientServiceImpl(private val commandGateway: CommandGateway) : ClientService {

    override fun createClientCorp(clientCorpNewDto: ClientCorpNewDto): CompletableFuture<UUID> =
        commandGateway.send(CreateClientCorpCommand(UUID.randomUUID().toString(), clientCorpNewDto))

    override fun updateClientCorp(clientCorpUpdateDto: ClientCorpUpdateDto): CompletableFuture<UUID> =
        commandGateway.send(UpdateClientCorpCommand(clientCorpUpdateDto.clientId, clientCorpUpdateDto))

}