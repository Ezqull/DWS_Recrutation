-- 2.	Zaproponuj zapytanie SQL zwracające ostatni status każdego klienta, z którym były co najmniej 3 próby kontaktu. Potraktuj podesłany plik jako tabelę.

SELECT s1.klient_id, s1.status
FROM statuses s1
JOIN(
    SELECT klient_id, MAX(kontakt_ts) AS ostatni_timestamp
    FROM tabela
    GROUP BY klient_id
    HAVING COUNT(klient_id) > 2
) s2 ON s1.klient_id = t2.klient_id AND s1.kontakt_ts = s2.ostatni_timestamp;
