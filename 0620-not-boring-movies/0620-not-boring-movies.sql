# Write your MySQL query statement below
select c.id, c.movie, c.description, c.rating
from Cinema c
where mod(c.id,2)=1
and c.description not like 'boring'
order by c.rating desc