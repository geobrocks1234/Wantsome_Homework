select d.name 'Department Name', e.first_name 'Manager First Name', l.city 'Department Location' 
from geo_departments d 
join geo_employees e 
on (d.manager_id = e.id) 
join geo_locations l on cast(d.location_id as signed)=cast(l.id as signed);