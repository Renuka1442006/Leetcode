SELECT p.product_name,sum(o.unit) as unit
From products p JOIN orders o
ON p.product_id=o.product_id
WHERE o.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY p.product_id,p.product_name
HAVING sum(o.unit)>=100;