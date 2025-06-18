# Write your MySQL query statement below
SELECT
    M.employee_id,
    M.name,
    COUNT(R.employee_id) AS reports_count,
    ROUND(AVG(R.age)) AS average_age
FROM
    Employees AS M  -- Alias 'M' for Managers
JOIN
    Employees AS R  -- Alias 'R' for Reports
ON
    M.employee_id = R.reports_to
GROUP BY
    M.employee_id, M.name
ORDER BY
    M.employee_id;