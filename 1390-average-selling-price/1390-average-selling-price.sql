SELECT
    p.product_id, 
    COALESCE(ROUND(SUM(p.price * us.units) * 1.0 / SUM(us.units), 2), 0) AS average_price
FROM
    Prices AS p 
LEFT JOIN
    UnitsSold AS us 
ON
    p.product_id = us.product_id      -- Match by product ID
    AND us.purchase_date >= p.start_date -- Purchase date must be on or after the price start date
    AND us.purchase_date <= p.end_date    -- Purchase date must be on or before the price end date
GROUP BY
    p.product_id; -- Group the results by product_id to calculate average for each distinct product