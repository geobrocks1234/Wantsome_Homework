select concat(first_name," ",last_name) as "Name" from geo_employees where salary>(select salary from geo_employees where last_name like "Bell") order by first_name; 