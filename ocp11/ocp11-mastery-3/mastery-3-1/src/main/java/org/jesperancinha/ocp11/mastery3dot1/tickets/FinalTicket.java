package org.jesperancinha.ocp11.mastery3dot1.tickets;

import java.time.LocalDateTime;

public final class FinalTicket {
    private final LocalDateTime date;

    private final String concert;

    private final String artist;

    public FinalTicket(LocalDateTime date, String concert, String artist) {
        this.date = LocalDateTime.from(date);
        this.concert = concert;
        this.artist = artist;
    }

    public LocalDateTime getDate() {
        return  LocalDateTime.from(date);
    }
}
