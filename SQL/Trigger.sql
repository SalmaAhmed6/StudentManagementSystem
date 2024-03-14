DROP TRIGGER ADMIN.UPDATEGPAONCHANGE;

CREATE OR REPLACE TRIGGER ADMIN.UpdateGPAOnChange
BEFORE UPDATE OF Semester, Grade_Level ON ADMIN.STUDENTS FOR EACH ROW
BEGIN
    IF :NEW.Semester != :OLD.Semester OR :NEW.Grade_Level != :OLD.Grade_Level THEN
        CalculateGPA(:NEW.StudentID, :OLD.Semester, :OLD.Grade_Level);
    END IF;
END;
/
