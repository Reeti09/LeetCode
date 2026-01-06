# Write your MySQL query statement below
select e.name
from Employee as e
inner join Employee as m where e.id=m.managerId
group by e.name, e.id
having count(e.id)>=5

