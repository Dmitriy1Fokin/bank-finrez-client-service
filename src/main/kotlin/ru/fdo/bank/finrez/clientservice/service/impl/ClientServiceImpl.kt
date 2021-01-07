package ru.fdo.bank.finrez.clientservice.service.impl

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Service
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import ru.fdo.bank.finrez.clientservice.service.ClientService
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.CreateClientCorpCommand
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.UpdateClientCorpCommand
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Service
class ClientServiceImpl(private val commandGateway: CommandGateway) : ClientService {

    override fun createClientCorp(clientCorpNewDto: ClientCorpNewDto): CompletableFuture<UUID> =
        commandGateway.send(CreateClientCorpCommand(UUID.randomUUID().toString(),
                clientCorpNewDto.name,
                clientCorpNewDto.orgForm,
                clientCorpNewDto.abbreviatedName,
                clientCorpNewDto.inn,
                clientCorpNewDto.kpp,
                clientCorpNewDto.ogrn,
                clientCorpNewDto.okpo,
                clientCorpNewDto.okved,
                clientCorpNewDto.addressU,
                clientCorpNewDto.addressF,
                clientCorpNewDto.email))

    override fun updateClientCorp(clientCorpUpdateDto: ClientCorpUpdateDto): CompletableFuture<UUID> =
        commandGateway.send(UpdateClientCorpCommand(clientCorpUpdateDto.clientId,
                clientCorpUpdateDto.name,
                clientCorpUpdateDto.orgForm,
                clientCorpUpdateDto.abbreviatedName,
                clientCorpUpdateDto.inn,
                clientCorpUpdateDto.kpp,
                clientCorpUpdateDto.ogrn,
                clientCorpUpdateDto.okpo,
                clientCorpUpdateDto.okved,
                clientCorpUpdateDto.addressU,
                clientCorpUpdateDto.addressF,
                clientCorpUpdateDto.email))

}