package entity;

public class personalPage {
    private int id;
    private String role;
    private String bio;

    @Override
    public String toString() {
        return "personalPage{" +
                "id=" + id +

                ", role='" + role + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public personalPage(int id, String role, String bio) {
        this.id = id;
        this.role = role;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
