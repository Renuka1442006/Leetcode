# Write your MySQL query statement below
SELECT 
ROUND(
    count(a.player_id)/
    (select count(DISTINCT player_id) FROM Activity),2
)
AS fraction 
FROM Activity a

JOIN
(
    SELECT player_id, min(event_date) AS first_date
    FROM Activity 
    GROUP BY player_id
) t
ON a.player_id=t.player_id 
AND a.event_date=DATE_ADD(t.first_date,INTERVAL 1 DAY);
