# Write your MySQL query statement below
select e.name,t.bonus
from Employee as e
left join Bonus as t
on e.empId=t.empId
where t.bonus<1000 or t.bonus is null