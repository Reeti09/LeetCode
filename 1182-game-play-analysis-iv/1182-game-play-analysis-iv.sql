SELECT
    ROUND(
        COUNT(DISTINCT A1.player_id) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2) AS fraction
FROM
    Activity AS A1
JOIN (
    SELECT
        player_id,
        MIN(event_date) AS first_login_date
    FROM
        Activity
    GROUP BY
        player_id
) AS FirstLogins ON A1.player_id = FirstLogins.player_id
WHERE
    A1.event_date = DATE_ADD(FirstLogins.first_login_date, INTERVAL 1 DAY);