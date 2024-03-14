CREATE OR REPLACE PROCEDURE ADMIN.UpdateStudentInfo(
    p_StudentID IN NUMBER,
    p_NewFirstName IN VARCHAR2,
    p_NewLastName IN VARCHAR2,
    p_NewDateOfBirth IN DATE,
    p_NewStreet IN VARCHAR2,
    p_NewCity IN VARCHAR2,
    p_NewGovernment IN VARCHAR2,
    p_NewEmail IN VARCHAR2,
    p_NewPhone IN VARCHAR2,
    p_NewSemester IN NUMBER,
    p_NewGradeLevel IN NUMBER,
    p_NewDepartmentID IN NUMBER
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
    SET 
        FIRSTNAME = p_NewFirstName,
        LASTNAME = p_NewLastName,
        DATEOFBIRTH = p_NewDateOfBirth,
        STREET = p_NewStreet,
        CITY = p_NewCity,
        GOVERNMENT = p_NewGovernment,
        EMAIL = p_NewEmail,
        PHONE = p_NewPhone,
        SEMESTER = p_NewSemester,
        GRADE_LEVEL = p_NewGradeLevel,
        DEPARTMENTID = p_NewDepartmentID
    WHERE StudentID = p_StudentID;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        RAISE;
END UpdateStudentInfo;
/
