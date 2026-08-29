select p.product_id, 
ROUND(
   IFNULL(sum(s.units*p.price)/sum(s.units),0),2
) as average_price
FROM Prices p 
LEFT JOIN UnitsSold s 
ON p.product_id=s.product_id
AND s.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;