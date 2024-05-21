package entity;

public class groupChat {
    private String chatname;
    private String messages;
    private int id;

    public groupChat(String chatname, String messages, int id) {
        this.chatname = chatname;
        this.messages = messages;
        this.id = id;
    }

    @Override
    public String toString() {
        return "groupChat{" +
                "chatname='" + chatname + '\'' +
                ", messages='" + messages + '\'' +
                ", id=" + id +
                '}';
    }

    public String getChatname() {
        return chatname;
    }

    public void setChatname(String chatname) {
        this.chatname = chatname;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
