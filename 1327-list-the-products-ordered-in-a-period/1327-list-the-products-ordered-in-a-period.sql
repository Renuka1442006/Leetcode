# Write your MySQL query statement below
SELECT p.product_name ,
sum(o.unit) as unit
from Products p
JOIN Orders o
ON p.product_id= o.product_id
where o.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY p.product_id,p.product_name
having sum(o.unit)>=100;
