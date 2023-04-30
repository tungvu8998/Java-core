package entity;

public class Manager extends User {
    private int exInYear;
    private int projectId;

    public Manager() {
    }

    public Manager(int id, String fullName, String email, String password, Role role, int exInYear,int projectId) {
        super(id, fullName, email, password, role);
        this.exInYear = exInYear;
        this.projectId = projectId;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getExInYear() {
        return exInYear;
    }

    public void setExInYear(int exInYear) {
        this.exInYear = exInYear;
    }
}
