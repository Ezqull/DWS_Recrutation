package org.example.model.comparator;

import org.example.model.Status;

import java.util.Comparator;

public class StatusComparator implements Comparator<Status> {

    /**
     * Compares two Status objects based on their klientId and kontaktTs properties.
     * @param status1 The first Status object to compare.
     * @param status2 The second Status object to compare.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to,
     *         or greater than the second argument.
     */
    @Override
    public int compare(Status status1, Status status2) {
        int klientIdComparison = Integer.compare(status1.getKlientId(), status2.getKlientId());

        if (klientIdComparison != 0) {
            return klientIdComparison;
        }

        return status1.getKontaktTs().compareTo(status2.getKontaktTs());
    }
}
