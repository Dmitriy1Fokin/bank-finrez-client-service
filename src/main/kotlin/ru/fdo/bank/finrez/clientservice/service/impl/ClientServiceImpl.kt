package ru.fdo.bank.finrez.clientservice.service.impl

import org.axonframework.commandhandling.gateway.CommandGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientCorpUpdateDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualNewDto
import ru.fdo.bank.finrez.clientservice.dto.ClientIndividualUpdateDto
import ru.fdo.bank.finrez.clientservice.service.ClientService
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.CreateClientCorpCommand
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.CreateClientIndividualCommand
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.UpdateClientCorpCommand
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.UpdateClientIndividualCommand
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Service
class ClientServiceImpl(private val commandGateway: CommandGateway) : ClientService {

    private val logger: Logger = LoggerFactory.getLogger(ClientServiceImpl::class.java)

    override fun createClientCorp(clientCorpNewDto: ClientCorpNewDto): CompletableFuture<UUID> {
        logger.debug("triggered createClientCorp: $clientCorpNewDto")
        return commandGateway.send(CreateClientCorpCommand(UUID.randomUUID().toString(),
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
    }

    override fun updateClientCorp(clientCorpUpdateDto: ClientCorpUpdateDto): CompletableFuture<UUID> {
        logger.debug("triggered updateClientCorp: $clientCorpUpdateDto")
        return commandGateway.send(UpdateClientCorpCommand(clientCorpUpdateDto.clientId,
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

    override fun createClientIndividual(clientIndividualNewDto: ClientIndividualNewDto): CompletableFuture<UUID> {
        logger.debug("triggered createClientIndividual: $clientIndividualNewDto")
        return commandGateway.send(CreateClientIndividualCommand(UUID.randomUUID().toString(),
                clientIndividualNewDto.lastName,
                clientIndividualNewDto.firstName,
                clientIndividualNewDto.middleName,
                clientIndividualNewDto.citizenship,
                clientIndividualNewDto.birthday,
                clientIndividualNewDto.passport))
    }

    override fun updateClientIndividual(clientIndividualUpdateDto: ClientIndividualUpdateDto): CompletableFuture<UUID> {
        logger.debug("triggered updateClientIndividual: $clientIndividualUpdateDto")
        return commandGateway.send(UpdateClientIndividualCommand(clientIndividualUpdateDto.clientId,
                clientIndividualUpdateDto.lastName,
                clientIndividualUpdateDto.firstName,
                clientIndividualUpdateDto.middleName,
                clientIndividualUpdateDto.citizenship,
                clientIndividualUpdateDto.birthday,
                clientIndividualUpdateDto.passport))
    }

}