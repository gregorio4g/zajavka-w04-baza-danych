update product
set product_price = 40
where id in (select pr.id
             from product pr
                      left join producer p on pr.producer_id = p.id
             where p.producer_name = 'Crona Group'
               and pr.product_price > 50)
;

select * from product pr
                  left join producer p on pr.producer_id = p.id
where p.producer_name = 'Crona Group'
;