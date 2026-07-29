# Write your MySQL query statement below
SELECT employee_id,department_id
FROM Employee
WHERE employee_id IN
(
     SELECT employee_id
     FROM Employee
     GROUP BY Employee_id
     HAVING count(*)=1
) OR primary_flag='Y';