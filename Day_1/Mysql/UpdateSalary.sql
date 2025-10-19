DELIMITER //
CREATE PROCEDURE updateSalary(IN empId INT)
BEGIN
    DECLARE days INT;
    DECLARE current_salary DECIMAL(10,2);

    SELECT getWorkingDays(joining_date) INTO days
    FROM employees
    WHERE employee_id = empId;

    SELECT salary INTO current_salary
    FROM employees
    WHERE employee_id = empId;

    IF days >= 365 THEN
        SET current_salary = current_salary * 1.10; 
    ELSEIF days >= 180 THEN
        SET current_salary = current_salary * 1.05; 
    END IF;

    UPDATE employees
    SET salary = current_salary
    WHERE employee_id = empId;
END //
DELIMITER ;
