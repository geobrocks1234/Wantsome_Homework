select concat(e.first_name," ",e.last_name) 'Employee Name',j.name 'Job Title', e.salary-j.min_salary 'Difference Salary-Min_salary' 
from geo_employees e 
join geo_jobs j on e.job_id=j.id;