# Write your MySQL query statement below
SELECT
    -- Calculate the percentage:
    -- (Count of customers whose first order was immediate) / (Total count of unique customers) * 100
    -- Use 100.0 to ensure floating-point arithmetic for accurate percentage.
    COALESCE(
        ROUND(SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0 / COUNT(d.customer_id), 2),
        0.00
    ) AS immediate_percentage
FROM
    Delivery AS d
WHERE
    (d.customer_id, d.order_date) IN ( -- This subquery identifies the first order for each customer
        SELECT
            customer_id,
            MIN(order_date) -- Finds the earliest order_date for each customer
        FROM
            Delivery
        GROUP BY
            customer_id
    );