select
    sum(q.purchase_price),
    q.month_of_purchase
from (
    select
    pr.product_price,
    pu.quantity,
    pr.product_price * pu.quantity as purchase_price,
    date_trunc('month', date_time) as month_of_purchase
from
    purchase pu
    left join product pr on pu.product_id = pr.id) q
group by
    q.month_of_purchase
order by q.month_of_purchase