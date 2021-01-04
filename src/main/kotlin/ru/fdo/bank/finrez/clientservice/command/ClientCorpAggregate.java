package ru.fdo.bank.finrez.clientservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import ru.fdo.bank.finrez.clientservice.coreapi.command.CreateClientCorpCommand;
import ru.fdo.bank.finrez.clientservice.coreapi.event.ClientCorpCreatedEvent;
import ru.fdo.bank.finrez.clientservice.dto.TypeOfClient;

import java.util.UUID;

@Aggregate
public class ClientCorpAggregate {

    @AggregateIdentifier
    private UUID clientCorpAggregateId;
    private Long clientId;
    private TypeOfClient typeOfClient;
    private String name;
    private String orgForm;
    private String abbreviatedName;
    private String inn;
    private String kpp;
    private String ogrn;
    private String okpo;
    private String okved;
    private String addressU;
    private String addressF;
    private String email;

    public ClientCorpAggregate(){}

    @CommandHandler
    public ClientCorpAggregate(CreateClientCorpCommand command){
        AggregateLifecycle.apply(new ClientCorpCreatedEvent(command.getCreateClientCorpCommandId(),
                command.getClientCorpNewDto()));
    }

    @EventSourcingHandler
    public void on(ClientCorpCreatedEvent event){
        this.clientCorpAggregateId = event.getCreateClientCorpCommandId();
        this.clientId = null;
        this.typeOfClient = event.getClientCorpNewDto().getTypeOfClient();
        this.name = event.getClientCorpNewDto().getName();
        this.orgForm = event.getClientCorpNewDto().getOrgForm();
        this.abbreviatedName = event.getClientCorpNewDto().getAbbreviatedName();
        this.inn = event.getClientCorpNewDto().getInn();
        this.kpp = event.getClientCorpNewDto().getKpp();
        this.ogrn = event.getClientCorpNewDto().getOgrn();
        this.okpo = event.getClientCorpNewDto().getOkpo();
        this.okved = event.getClientCorpNewDto().getOkved();
        this.addressU = event.getClientCorpNewDto().getAddressU();
        this.addressF = event.getClientCorpNewDto().getAddressF();
        this.email = event.getClientCorpNewDto().getEmail();
    }
}
