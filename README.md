# MOK YOK IT - Task 4

In this task, I was supposed to use Talend Open Studio For Data Integration to recreate task 1.

# Description of the project

In the project I used all components that were in the hint: *tFileInputJSON*, *tFilterRow*, *tSortRow* and *tFileOutputDelimited*.
In the *fFileInputJson*, I created my own schema and used Json Query to appropriately map it from json file.
In *tFilterRow*, I used a custom condition  on *kontakt_ts* with operator *Greater or equal to* with value of: `TalendDate.parseDate("yyyy-MM-dd", "2017-07-01")`
For *tSortRow*, I used normal criteria on *klient_id* and *kontakt_ts* in ascending order.
There is one thing that needs to be changed for the program to work properly. After being opened, go to *tFileOutputDelimited* component and change
*File Name* in Basic Settings to the directory in which you want the file to be generated. 