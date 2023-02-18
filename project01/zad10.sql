select q.producer_name from (
    select distinct
    p.producer_name,
    sum(pu.quantity)
from
    purchase pu
    left join product pr on (pu.product_id = pr.id)
    left join producer p on (pr.producer_id = p.id)
group by
    p.producer_name) q
order by
    q.sum desc
limit 1