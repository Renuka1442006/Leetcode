# Write your MySQL query statement below
SELECT c.customer_id, count(c.customer_id) as count_no_trans
FROM Visits c LEFT JOIN Transactions t
ON c.visit_id=t.visit_id
WHERE t.visit_id IS NULL
GROUP BY c.customer_id;