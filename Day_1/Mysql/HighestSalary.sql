SELECT *
FROM (
    SELECT *, 
           ROW_NUMBER() OVER (PARTITION BY dept_id ORDER BY salary DESC) as rank
    FROM employees
) t
WHERE rank <= 5;
