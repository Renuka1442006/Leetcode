# Write your MySQL query statement below
SELECT MAX(num) AS num
FROM
(
    select num 
    from Mynumbers
    GROUP BY num
    having count(*)=1
) as t;