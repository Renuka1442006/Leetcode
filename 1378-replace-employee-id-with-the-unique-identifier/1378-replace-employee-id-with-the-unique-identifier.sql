# Write your MySQL query statement below
SELECT u1.unique_id, u2.name from Employees u2 LEFT JOIN EmployeeUNI u1 ON u1.id=u2.id;