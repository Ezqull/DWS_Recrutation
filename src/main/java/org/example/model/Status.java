package org.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @JsonAlias("kontakt_id")
    private int kontaktId;
    @JsonAlias("klient_id")
    private int klientId;
    @JsonAlias("pracownik_id")
    private int pracownikId;
    @JsonAlias("status")
    private String status;
    @JsonAlias("kontakt_ts")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp kontaktTs;

    /**
     * Converts the Status object to a string array.
     * @return The Status object as a string array.
     */
    public String[] toStringArray(){
        return new String[]{String.valueOf(kontaktId), String.valueOf(klientId), String.valueOf(pracownikId), status, String.valueOf(kontaktTs)};
    }
}
