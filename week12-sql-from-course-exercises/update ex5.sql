update geo_employees set     SALARY =  case  when DEPARTMENT_ID = 40 then SALARY*25/100 
											 when DEPARTMENT_ID = 90 then SALARY*15/100 
											 when DEPARTMENT_ID = 110 then SALARY*10/100 
									   else DEPARTMENT_ID end  where   DEPARTMENT_ID in (40, 90, 110)