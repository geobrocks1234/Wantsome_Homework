select FIRST_NAME as "First Name", length(FIRST_NAME) as "Lenght of First Name" from geo_employees
WHERE FIRST_NAME LIKE "A%" OR FIRST_NAME LIKE "J%" OR FIRST_NAME LIKE "M%"
ORDER BY FIRST_NAME;