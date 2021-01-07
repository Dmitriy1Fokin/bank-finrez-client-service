package ru.fdo.bank.finrez.clientservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.CreateClientCorpCommand;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.UpdateClientCorpCommand;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.event.ClientCorpCreatedEvent;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.event.ClientCorpUpdatedEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Aggregate
@Entity
@Table(name = "client_corp")
public class ClientCorp {

    @Id
    @AggregateIdentifier
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "org_form")
    private String orgForm;
    @Column(name = "abbreviated_name")
    private String abbreviatedName;
    @Column(name = "INN")
    private String inn;
    @Column(name = "KPP")
    private String kpp;
    @Column(name = "OGRN")
    private String ogrn;
    @Column(name = "OKPO")
    private String okpo;
    @Column(name = "OKVED")
    private String okved;
    @Column(name = "address_u")
    private String addressU;
    @Column(name = "address_f")
    private String addressF;
    @Column(name = "email")
    private String email;

    public ClientCorp(){}

    @CommandHandler
    public ClientCorp(CreateClientCorpCommand cmd){
        AggregateLifecycle.apply(new ClientCorpCreatedEvent(cmd.getClientId(), 
                cmd.getName(),
                cmd.getOrgForm(),
                cmd.getAbbreviatedName(),
                cmd.getInn(),
                cmd.getKpp(),
                cmd.getOgrn(),
                cmd.getOkpo(),
                cmd.getOkved(),
                cmd.getAddressU(),
                cmd.getAddressF(),
                cmd.getEmail()));
    }

    @CommandHandler
    public void handle(UpdateClientCorpCommand cmd){
        AggregateLifecycle.apply(new ClientCorpUpdatedEvent(cmd.getClientId(),
                cmd.getName(),
                cmd.getOrgForm(),
                cmd.getAbbreviatedName(),
                cmd.getInn(),
                cmd.getKpp(),
                cmd.getOgrn(),
                cmd.getOkpo(),
                cmd.getOkved(),
                cmd.getAddressU(),
                cmd.getAddressF(),
                cmd.getEmail()));
    }

    @EventSourcingHandler
    public void on(ClientCorpCreatedEvent event){
        this.clientId = event.getClientId();
        this.name = event.getName();
        this.orgForm = event.getOrgForm();
        this.abbreviatedName = event.getAbbreviatedName();
        this.inn = event.getInn();
        this.kpp = event.getKpp();
        this.ogrn = event.getOgrn();
        this.okpo = event.getOkpo();
        this.okved = event.getOkved();
        this.addressU = event.getAddressU();
        this.addressF = event.getAddressF();
        this.email = event.getEmail();
    }

    @EventSourcingHandler
    public void on(ClientCorpUpdatedEvent event){
        this.clientId = event.getClientId();
        this.name = event.getName();
        this.orgForm = event.getOrgForm();
        this.abbreviatedName = event.getAbbreviatedName();
        this.inn = event.getInn();
        this.kpp = event.getKpp();
        this.ogrn = event.getOgrn();
        this.okpo = event.getOkpo();
        this.okved = event.getOkved();
        this.addressU = event.getAddressU();
        this.addressF = event.getAddressF();
        this.email = event.getEmail();
    }
}
