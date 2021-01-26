package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

@Named
@SessionScoped
public class ConcertBean implements Serializable {

    @Inject
    private ConcertDAO concertDAO;

    private String response;

    private Concert concert;

    private Concert inDatabase;

    public ConcertBean() {
        this.concert = new Concert();
    }

    public void saveConcert() {
        final UUID uuid = UUID.randomUUID();
        concert.setUuid(uuid);
        concert.setDate(new Date(Instant.now().toEpochMilli()));
        try {
            concertDAO.createConcertAndThenNot(concert);
        } catch (Exception e) {
            RED.printExpectedException("An exception on its own doesn't rollback a transaction. Check your database", e);
            response = "Your record has been saved anyways!. Check the database!";
        }
        this.inDatabase = concertDAO.getConcert(uuid);
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Concert getInDatabase() {
        return inDatabase;
    }

    public void setInDatabase(Concert inDatabase) {
        this.inDatabase = inDatabase;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
