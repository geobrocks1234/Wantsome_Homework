select e.first_name, e.last_name, j.start_date, j.end_date, jj.name from geo_job_history j join geo_employees e on j.employee_id=e.id join geo_jobs jj on e.job_id=jj.id where e.salary>10000; 