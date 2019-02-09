select jh.employee_id 'Employee ID', j.name 'Job Title', jh.end_date-jh.start_date Days from geo_job_history jh 
natural join geo_jobs j 
where jh.department_id=90;