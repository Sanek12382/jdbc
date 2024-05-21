package entity;

public class Post {
    private int id;
    private int userId;
    private String body;
    private String title;
    private String status;


    public Post(int id, int userId, String body, String title, String status) {
        this.id = id;
        this.userId = userId;
        this.body = body;
        this.title = title;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "post{" +
                "id=" + id +
                ", userId=" + userId +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
