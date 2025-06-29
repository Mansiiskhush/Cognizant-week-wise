-- Exercise 1: Control Structures
SET SERVEROUTPUT ON;

BEGIN
  FOR c IN (SELECT CustomerID FROM Customers 
            WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = c.CustomerID;
  END LOOP;
END;
/


ALTER TABLE Customers ADD IsVIP CHAR(1); -- Run this only once
/

BEGIN
  FOR c IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers SET IsVIP = 'Y' WHERE CustomerID = c.CustomerID;
  END LOOP;
END;
/


BEGIN
  FOR l IN (SELECT LoanID, CustomerID FROM Loans 
            WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || l.LoanID || 
                         ' for customer ' || l.CustomerID || 
                         ' is due within 30 days.');
  END LOOP;
END;
/
