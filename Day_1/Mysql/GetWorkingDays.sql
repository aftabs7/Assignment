DELIMITER //
CREATE FUNCTION getWorkingDays(join_date DATE) RETURNS INT
BEGIN
    DECLARE working_days INT;
    SET working_days = DATEDIFF(CURDATE(), join_date);
    RETURN working_days;
END //
DELIMITER ;
