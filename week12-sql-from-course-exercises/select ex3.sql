select ID, NAME from geo_departments where id NOT in (select department_id from geo_employees);

select d.id, d.name from geo_departments d 
left join geo_employees e on d.id = e.department_id
where d.id not in (select department_id from geo_employees);