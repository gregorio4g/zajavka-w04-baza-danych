select distinct
    product_name,
    count(*) as cnt
from
    opinion o
    left join product p on p.id = o.product_id
group by
    product_name
order by
    cnt desc,
    product_name
limit 10