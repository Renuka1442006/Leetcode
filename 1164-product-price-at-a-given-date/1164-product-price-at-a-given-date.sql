# Write your MySQL query statement below
SELECT p.product_id,
p.new_price AS price 
FROM Products p 
JOIN (
    SELECT product_id,
       MAX(change_date) as change_date
       FROM Products 
       WHERE change_date<='2019-08-16'
       GROUP BY product_id
) t
ON p.product_id=t.product_id
AND p.change_date=t.change_date
UNION
select DISTINCT product_id,
 10 as price
 FROM Products
 WHERE product_id NOT IN (
    select product_id 
    FROM products 
    WHERE change_date <= '2019-08-16'
 );

