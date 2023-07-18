package org.example.model.comparator;

import org.example.model.Status;

import java.util.Comparator;

public class StatusComparator implements Comparator<Status> {

    @Override
    public int compare(Status status1, Status status2) {
        int klientIdComparison = Integer.compare(status1.getKlientId(), status2.getKlientId());

        if (klientIdComparison != 0) {
            return klientIdComparison;
        }

        return status1.getKontaktTs().compareTo(status2.getKontaktTs());
    }
}
