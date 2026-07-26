# Write your MySQL query statement below
SELECT contest_id,
ROUND(IFNULL(count(contest_id)*100/(select count(*) FROM Users),0),2) AS percentage
FROM Register 
GROUP BY contest_id
ORDER BY percentage DESC,contest_id ASC;
