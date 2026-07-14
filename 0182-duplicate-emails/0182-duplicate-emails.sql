SELECT email
from Person
GROUP BY email
having count(*)>1;