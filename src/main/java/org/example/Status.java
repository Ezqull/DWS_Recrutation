package org.example;

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

    public String[] toStringArray(){
        String[] array = {String.valueOf(kontaktId), String.valueOf(klientId), String.valueOf(pracownikId), status, String.valueOf(kontaktTs)};
        return array;
    }
}
