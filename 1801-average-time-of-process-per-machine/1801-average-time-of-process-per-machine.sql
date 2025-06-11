# Write your MySQL query statement below
select A_start.machine_id, round(avg(A_end.timestamp-A_start.timestamp),3) as processing_time
from Activity as A_start
join Activity as A_end on A_start.machine_id=A_end.machine_id
and A_start.process_id=A_end.process_id
WHERE
    a_start.activity_type = 'start'
    AND a_end.activity_type = 'end'
group by A_Start.machine_id    