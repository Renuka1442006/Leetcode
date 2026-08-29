SELECT m.name FROM Employee e
JOIN Employee m
ON e.managerId=m.id
GROUP BY m.id,m.name
HAVING count(e.id)>=5;