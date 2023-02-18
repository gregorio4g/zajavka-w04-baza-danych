select distinct p.product_code from purchase pu
left join product p on pu.product_id = p.id
where date_time < to_date('2022-07-01', 'YYYY-MM-DD')
;