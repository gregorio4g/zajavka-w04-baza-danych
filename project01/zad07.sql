select
    c.*,
    pr.adults_only
from
    purchase pu
left join customer c on (pu.customer_id = c.id)
left join product pr on pu.product_id = pr.id
where
    pr.adults_only = true
;