SELECT
    DATE(kontakt_ts) AS data,
    COUNT(CASE WHEN status = 'zainteresowany' THEN 1 END) AS sukcesy,
    COUNT(CASE WHEN status = 'niezainteresowany' THEN 1 END) AS utraty,
    COUNT(CASE WHEN status IN ('poczta_głosowa', 'nie_ma_w_domu') THEN 1 END) AS do_ponowienia,
    COUNT(CASE WHEN status = 'niezainteresowany' AND poprzedni_status = 'zainteresowany' THEN 1 END) AS zainteresowani_utraty,
    COUNT(CASE WHEN status = 'zainteresowany' AND poprzedni_status = 'niezainteresowany' THEN 1 END) AS niezainteresowani_sukcesy
FROM (SELECT klient_id,
             status,
             kontakt_ts,
             LAG(status) OVER (PARTITION BY klient_id ORDER BY kontakt_ts) AS poprzedni_status,
             ROW_NUMBER() OVER (PARTITION BY klient_id, date(kontakt_ts) ORDER BY kontakt_ts desc) AS wystapienie
      FROM samolot.kontakty
      ) subquery
WHERE wystapienie = 1
GROUP BY DATE(kontakt_ts)
ORDER BY DATE(kontakt_ts);