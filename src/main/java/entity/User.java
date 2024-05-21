package entity;

public class User {
    private int id;
    private String userName;
    private int pageId;


    public User(int id, String userName, int pageId) {
        this.id = id;
        this.userName = userName;
        this.pageId = pageId;

    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pageId=" + pageId +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }


}
