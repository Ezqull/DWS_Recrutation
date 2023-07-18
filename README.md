# MOK YOK IT - Task 2

This task's goal was to create query to retrieve last status for each client with whom there have been at least 3 attempts to contact.

# Script

The script uses *INNER JOIN* to connect the statuses table to itself. Inside the *JOIN* there is a *SELECT* which has two fields to retrieve *klient_id*, column by which I will group the result and *MAX(kontakt_ts)*, to get last date for each *klient_id*. Then after grouping I only retrieve groups which contain at least 3 records.
At last the main query is joined with itself on two columns: *klient_id* and *kontakt_ts*.