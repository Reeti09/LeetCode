# Write your MySQL query statement below
SELECT
    v.customer_id,           -- Select the customer_id
    COUNT(v.visit_id) AS count_no_trans -- Count the number of visits where no transaction occurred
FROM
    Visits AS v              -- Start with the Visits table (alias as 'v')
LEFT JOIN
    Transactions AS t        -- Left join with the Transactions table (alias as 't')
ON
    v.visit_id = t.visit_id  -- Join on visit_id
WHERE
    t.transaction_id IS NULL -- Filter for rows where there was NO match in the Transactions table
                             -- (meaning no transaction was made for that visit_id)
GROUP BY
    v.customer_id;           -- Group the results by customer_id to count visits per customer