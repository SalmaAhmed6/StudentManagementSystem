CREATE OR REPLACE FUNCTION ADMIN.CalculateGPAA(
    p_StudentID IN NUMBER
) RETURN NUMBER
AS
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

    -- Return the calculated GPA
    RETURN v_GPA;
END CalculateGPAA;
/
