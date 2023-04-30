package entity;

public class Employee extends User {
    private String proSkill;
    private int projectId;

    public Employee() {
    }

    public Employee(int id, String fullName, String email, String password, Role role, String proSkill, int projectId) {
        super(id, fullName, email, password, role);
        this.proSkill = proSkill;
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
