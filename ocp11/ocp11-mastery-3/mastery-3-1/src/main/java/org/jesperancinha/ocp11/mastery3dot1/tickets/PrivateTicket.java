package org.jesperancinha.ocp11.mastery3dot1.tickets;

import java.time.LocalDateTime;

public class PrivateTicket {

    private final LocalDateTime date;

    private final String concert;

    private final String artist;

    private PrivateTicket(LocalDateTime date, String concert, String artist) {
        this.date = LocalDateTime.from(date);
        this.concert = concert;
        this.artist = artist;
    }

    public static PrivateTicket createTicket(LocalDateTime date, String concert, String artist) {
        return new PrivateTicket(date, concert, artist);
    }

    public LocalDateTime getDate() {
        return LocalDateTime.from(date);
    }
}
