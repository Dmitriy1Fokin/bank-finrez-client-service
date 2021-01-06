package ru.fdo.bank.finrez.clientservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import ru.fdo.bank.finrez.clientservice.coreapi.command.CreateClientCorpCommand;
import ru.fdo.bank.finrez.clientservice.coreapi.command.UpdateClientCorpCommand;
import ru.fdo.bank.finrez.clientservice.coreapi.event.ClientCorpCreatedEvent;
import ru.fdo.bank.finrez.clientservice.coreapi.event.ClientCorpUpdatedEvent;

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
        AggregateLifecycle.apply(new ClientCorpCreatedEvent(cmd.getClientId(), cmd.getClientCorpNewDto()));
    }

    @CommandHandler
    public void handle(UpdateClientCorpCommand cmd){
        AggregateLifecycle.apply(new ClientCorpUpdatedEvent(cmd.getClientCorpUpdateDto()));
    }

    @EventHandler
    public void on(ClientCorpCreatedEvent event){
        this.clientId = event.getClientId();
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

    @EventHandler
    public void on(ClientCorpUpdatedEvent event){
        this.clientId = event.getClientCorpUpdateDto().getClientId();
        this.name = event.getClientCorpUpdateDto().getName();
        this.orgForm = event.getClientCorpUpdateDto().getOrgForm();
        this.abbreviatedName = event.getClientCorpUpdateDto().getAbbreviatedName();
        this.inn = event.getClientCorpUpdateDto().getInn();
        this.kpp = event.getClientCorpUpdateDto().getKpp();
        this.ogrn = event.getClientCorpUpdateDto().getOgrn();
        this.okpo = event.getClientCorpUpdateDto().getOkpo();
        this.okved = event.getClientCorpUpdateDto().getOkved();
        this.addressU = event.getClientCorpUpdateDto().getAddressU();
        this.addressF = event.getClientCorpUpdateDto().getAddressF();
        this.email = event.getClientCorpUpdateDto().getEmail();
    }
}
