# Write your MySQL query statement below
select e.name, b.bonus
from Bonus as b
right join Employee as e
on e.empId=b.empId
where b.bonus<1000 or b.bonus is null