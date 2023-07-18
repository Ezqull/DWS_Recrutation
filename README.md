# MOK YOK IT - Task 3

In this task I had to create query  to retrieve data to fact *f_docieralnosc*, that shows global reachability to clients.

# Script

In the select I had to create different counts that were dependent on status column. First I had to convert Timestamp kontakt_ts into date type.
All the counts are dependent on the sub-query. The sub-query gets few columns from statuses table: *klient_id*, *status* and
*kontakt_ts*. In addition, there are two columns created by myself to properly finish this task. *poprzedni_status* column contains LAG() window function,
which takes previous record for the column given after **PARTITION BY**, based on the offset (default is 1, so I didn't change it).
Next column is a *ROW_NUMBER()*, also a window function, that allowed me to get the number of the row for each appearance of *kleint_id* in statuses. 
I also had to add *date(kontakt_ts)* to **PARTITION BY** in order to get all dates in *f_docieralnosc*.
I also ordered it in descending way to be able to get a last date as a row_number 1.