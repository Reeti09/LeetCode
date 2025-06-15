SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month, -- Extract month and year in 'YYYY-MM' format
    country,                                 -- Select the country
    COUNT(id) AS trans_count,                -- Count all transactions for the month-country group
    SUM(CASE WHEN state = 'approved' THEN 1 ELSE 0 END) AS approved_count, -- Count only approved transactions
    SUM(amount) AS trans_total_amount,       -- Sum total amount for all transactions
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount -- Sum amount for approved transactions only
FROM
    Transactions
GROUP BY
    month,   -- Group by the extracted month
    country; -- And by country