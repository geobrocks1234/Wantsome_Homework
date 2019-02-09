select d.id 'Department ID', d.name 'Department Name', e.first_name 'Department Manager Name' 
from geo_departments d 
inner join geo_employees e 
on (d.manager_id = e.id);