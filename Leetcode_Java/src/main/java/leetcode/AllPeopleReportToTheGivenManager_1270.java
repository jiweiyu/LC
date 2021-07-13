package leetcode;

public class AllPeopleReportToTheGivenManager_1270 {

//    SELECT a.employee_id as EMPLOYEE_ID FROM Employees as a # those whose boss is 1
//    WHERE a.employee_id!=1 AND a.manager_id=1
//    UNION
//    SELECT b.employee_id FROM Employees as b #those whose boss' boss is 1
//    WHERE b.manager_id IN
//            (
//                    SELECT a.employee_id FROM Employees as a
//                    WHERE a.employee_id!=1 AND a.manager_id=1
//            )
//    UNION
//    SELECT c.employee_id FROM Employees as c #those whose boss' boss' boss is 1
//    WHERE c.manager_id IN
//            (
//                    SELECT b.employee_id FROM Employees as b
//                    WHERE b.manager_id IN
//                    (
//                    SELECT a.employee_id FROM Employees as a
//                    WHERE a.employee_id!=1 AND a.manager_id=1
//            )
//)
//    ORDER BY EMPLOYEE_ID;
}
