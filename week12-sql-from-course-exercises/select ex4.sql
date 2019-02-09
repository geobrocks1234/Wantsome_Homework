SELECT id, first_name,last_name, salary FROM geo_employees 
WHERE salary > 
ALL(SELECT avg(salary)FROM geo_employees GROUP BY department_id);