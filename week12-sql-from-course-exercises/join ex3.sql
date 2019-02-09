select j.name, avg(e.salary) 
	from geo_employees e 
		join geo_jobs j 
        on e.job_id=j.id
			group by j.name;