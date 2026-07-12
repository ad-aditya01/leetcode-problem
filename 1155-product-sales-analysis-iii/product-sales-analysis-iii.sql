# Write your MySQL query statement below
select s.product_id,
s.year as first_year,
s.quantity,
s.price
from Sales s
join (
    SELECT product_id,
           MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
)t
ON s.product_id = t.product_id
AND s.year = t.first_year;
