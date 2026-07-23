# Write your MySQL query statement below
SELECT customer_id, count(customer_id) AS count_no_trans FROM Visits v WHERE
NOT EXISTS (select 1 FROM Transactions t WHERE t.visit_id=v.visit_id) 
GROUP BY v.customer_id;
