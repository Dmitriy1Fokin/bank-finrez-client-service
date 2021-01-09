package ru.fdo.bank.finrez.clientservice.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.CreateClientIndividualCommand;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.command.UpdateClientIndividualCommand;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.event.ClientIndividualCreatedEvent;
import ru.fdo.bank.finrez.clientservicecommon.coreapi.event.ClientIndividualUpdatedEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Slf4j
@Aggregate
@Entity
@Table(name = "client_individual")
public class ClientIndividual {

    @Id
    @AggregateIdentifier
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "citizenship")
    private String citizenship;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "passport")
    private String passport;

    public ClientIndividual(){}

    @CommandHandler
    public ClientIndividual(CreateClientIndividualCommand cmd){
        log.debug("triggered CreateClientIndividualCommand: {}", cmd);
        AggregateLifecycle.apply(new ClientIndividualCreatedEvent(cmd.getClientId(),
                cmd.getLastName(),
                cmd.getFirstName(),
                cmd.getMiddleName(),
                cmd.getCitizenship(),
                cmd.getBirthday(),
                cmd.getPassport()));
    }

    @CommandHandler
    public void handle(UpdateClientIndividualCommand cmd){
        log.debug("triggered UpdateClientIndividualCommand: {}", cmd);
        AggregateLifecycle.apply(new ClientIndividualUpdatedEvent(cmd.getClientId(),
                cmd.getLastName(),
                cmd.getFirstName(),
                cmd.getMiddleName(),
                cmd.getCitizenship(),
                cmd.getBirthday(),
                cmd.getPassport()));
    }

    @EventSourcingHandler
    public void on(ClientIndividualCreatedEvent event){
        log.debug("triggered ClientIndividualCreatedEvent: {}", event);
        this.clientId = event.getClientId();
        this.lastName = event.getLastName();
        this.firstName = event.getFirstName();
        this.middleName = event.getMiddleName();
        this.citizenship = event.getCitizenship();
        this.birthday = event.getBirthday();
        this.passport = event.getPassport();
    }

    @EventSourcingHandler
    public void on(ClientIndividualUpdatedEvent event){
        log.debug("triggered ClientIndividualUpdatedEvent: {}", event);
        this.clientId = event.getClientId();
        this.lastName = event.getLastName();
        this.firstName = event.getFirstName();
        this.middleName = event.getMiddleName();
        this.citizenship = event.getCitizenship();
        this.birthday = event.getBirthday();
        this.passport = event.getPassport();
    }
}
