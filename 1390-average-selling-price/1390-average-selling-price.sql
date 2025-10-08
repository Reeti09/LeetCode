# Write your MySQL query statement below
select p.product_id, 
round(coalesce(sum(u.units*p.price)*1.0/sum(u.units),0),2) as average_price
from Prices p
left join UnitsSold u on u.product_id=p.product_id 
and u.purchase_date between p.start_date and p.end_date
group by p.product_id

