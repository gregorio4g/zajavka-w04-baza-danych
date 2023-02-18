select distinct
    c.*
from
    opinion o
    left join customer c on (o.customer_id = c.id)
where
    stars = 5