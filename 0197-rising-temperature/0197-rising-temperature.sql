SELECT w1.id from Weather w1
JOIN Weather w2
ON DATEDIFF(w1.recordDate,w2.recordDate)=1
and W2.temperature<w1.temperature;