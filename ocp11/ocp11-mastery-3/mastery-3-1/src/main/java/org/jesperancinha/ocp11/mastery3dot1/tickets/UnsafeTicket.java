package org.jesperancinha.ocp11.mastery3dot1.tickets;

import java.time.LocalDateTime;

public class UnsafeTicket {
    private final LocalDateTime date;

    private final String concert;

    private final String artist;

    public UnsafeTicket(LocalDateTime date, String concert, String artist) {
        this.date = date;
        this.concert = concert;
        this.artist = artist;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
