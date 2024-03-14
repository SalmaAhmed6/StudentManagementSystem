CREATE OR REPLACE TRIGGER UpdateGPAOnChange
BEFORE UPDATE OF Semester, Grade_Level ON Admin.Students
FOR EACH ROW
BEGIN
    IF :NEW.Semester != :OLD.Semester OR :NEW.Grade_Level != :OLD.Grade_Level THEN
        CalculateGPA(:NEW.StudentID, :OLD.Semester, :OLD.Grade_Level);
    END IF;
END;
show errors;
/
CREATE OR REPLACE PROCEDURE CalculateGPA(
    p_StudentID IN NUMBER,
    p_OldSemester IN NUMBER,
    p_OldGradeLevel IN NUMBER
) AS
    v_TotalCredits NUMBER := 0;
    v_TotalWeightedGradePoints NUMBER := 0; -- To store the sum of (GPA * CreditPoints) for each course
    v_CreditPoints NUMBER;
    v_GPA NUMBER;
BEGIN
    FOR course_rec IN (SELECT CourseID, Grade FROM Admin.Student_Course WHERE StudentID = p_StudentID) LOOP
        -- Convert the numerical grade to a GPA on a 4.0 scale
        v_GPA := CASE
                     WHEN course_rec.Grade >= 90 THEN 4.0
                     WHEN course_rec.Grade >= 80 THEN 3.33
                     WHEN course_rec.Grade >= 70 THEN 3.0
                     WHEN course_rec.Grade >= 60 THEN 2.0
                     ELSE 0.0
                 END;

        -- Assuming you have a CreditPoints column in the Courses table
        SELECT Credits INTO v_CreditPoints FROM Admin.Courses WHERE CourseID = course_rec.CourseID;

        -- Accumulate the sum of (GPA * CreditPoints) for each course
        v_TotalWeightedGradePoints := v_TotalWeightedGradePoints + (v_GPA * v_CreditPoints);
        v_TotalCredits := v_TotalCredits + v_CreditPoints;
    END LOOP;

    -- Calculate the GPA by dividing the sum of (GPA * CreditPoints) by the total credits
    IF v_TotalCredits > 0 THEN
        v_GPA := v_TotalWeightedGradePoints / v_TotalCredits;
    ELSE
        v_GPA := 0.0;
    END IF;

    -- Update GPA in Student_History table
    INSERT INTO Admin.STUDENT_HISTORY (StudentID, Semester, GradeLevel, GPA)
    VALUES (p_StudentID, p_OldSemester, p_OldGradeLevel, v_GPA);

END CalculateGPA;
/
SHOW ERRORS;
CREATE OR REPLACE PROCEDURE UpdateStudentInfo(
    p_StudentID IN NUMBER,
    p_NewStreet IN VARCHAR2,
    p_NewCity IN VARCHAR2,
    p_NewCountry IN VARCHAR2
) AS
    v_ExistingStudent NUMBER;
BEGIN
    -- Check if the student with the given StudentID exists
    SELECT COUNT(*) INTO v_ExistingStudent FROM Admin.Students WHERE StudentID = p_StudentID;

    IF v_ExistingStudent = 0 THEN
        -- Raise an exception if the student doesn't exist
        RAISE_APPLICATION_ERROR(-20001, 'Invalid StudentID. Student not found.');
    END IF;

    -- Update student information in the Students table
    UPDATE Admin.Students
    SET STREET = p_NewStreet,
        CITY = p_NewCity,
        GOVERNMENT = p_NewCountry
    WHERE StudentID = p_StudentID;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Log or handle the exception as needed
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateStudentInfo;
/

EXEC UpdateStudentInfo(8, 2, 'New City', 'New Country');
set serveroutput on;