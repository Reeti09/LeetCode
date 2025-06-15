SELECT
    r.contest_id, -- 1. Select the Contest ID
    ROUND(COUNT(r.user_id) * 100.0 / (SELECT COUNT(user_id) FROM Users), 2) AS percentage -- 2. Calculate and round the percentage
FROM
    Register AS r -- 3. Start from the Register table
GROUP BY
    r.contest_id -- 4. Group registrations by Contest ID
ORDER BY
    percentage DESC, -- 5. Order by Percentage (descending)
    r.contest_id ASC; -- 6. Then by Contest ID (ascending) for ties