package Enums;

public enum LibraryUsers {
    TEACHER(1),SENIOR_STUDENT(2),JUNIOR_STUDENT(3);

    private static final int SMALL = 1;
    private static final int MEDIUM = 2;
    private static final int LARGE = 3;
    private static final int EXTRA_LARGE = 4;

    private final Integer priorityValue;

    // private enum constructor
    LibraryUsers(Integer priorityValue) {
        this.priorityValue = priorityValue;
    }

    public Integer getValue() {
        return priorityValue;
    }


}
