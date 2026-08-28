# Write your MySQL query statement below
SELECT u2.unique_id, u1.name FROM Employees u1
LEFT JOIN EmployeeUNI u2
ON u1.id=u2.id;