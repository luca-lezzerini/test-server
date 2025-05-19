package al.polis.appserver.communication;

import lombok.Getter;

@Getter
public enum ServerErrorEnum {

    OK("Success!",
            "",
            ErrorSeverityEnum.OK),
    UNKNOWN_ERROR("Unknown Error!",
            "Contact technical support",
            ErrorSeverityEnum.FATAL),
    TEACHER_MISSING("Teacher is missing or incomplete!",
            "Enter all required data",
            ErrorSeverityEnum.ERROR),
    COURSE_MISSING("Course is missing or incomplete!",
            "Enter all required data",
            ErrorSeverityEnum.ERROR),
    COURSE_NOT_FOUND("Course id has not been found.",
            "Check the id.",
            ErrorSeverityEnum.ERROR),
    TEACHER_NOT_FOUND("Teacher id has not been found.",
            "Check the id.",
            ErrorSeverityEnum.ERROR),
    STUDENT_NOT_FOUND("Student id has not been found.",
            "Check the id.",
            ErrorSeverityEnum.ERROR),
    FILTER_MISSING("Filter is missing or incomplete!",
            "Enter all required data to filter",
            ErrorSeverityEnum.ERROR),
    STUDENT_MISSING("Student is missing or incomplete!",
            "Enter all required data",
            ErrorSeverityEnum.ERROR),
    DELETE_COURSE_NOT_ALLOWED("The course has relationships and cannot be deleted.",
            "Remove relationships to delete the course",
            ErrorSeverityEnum.ERROR),
    DELETE_TEACHER_NOT_ALLOWED("The teacher has relationships and cannot be deleted.",
            "Remove relationships to delete the teacher",
            ErrorSeverityEnum.ERROR),
    DELETE_STUDENT_NOT_ALLOWED("The student has relationships and cannot be deleted.",
            "Remove relationships to delete the student",
            ErrorSeverityEnum.ERROR);

    private final String message;
    private final String action;
    private final ErrorSeverityEnum severity;

    private ServerErrorEnum(String message, String action, ErrorSeverityEnum severity) {
        this.message = message;
        this.action = action;
        this.severity = severity;
    }

}
