select distinct pr.product_code, count(*) as cnt
from purchase pu
         left join product pr on pu.product_id = pr.id
group by pr.product_code
order by 2 desc
limit 5;