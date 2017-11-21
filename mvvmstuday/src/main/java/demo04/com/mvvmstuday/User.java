package demo04.com.mvvmstuday;

/**
 * Created by 小可爱 on 2017/11/14.
 */

public class User {
    private String username;
    private String nickname;
    private int age;

    public User() {
    }

    public User(String username, String nickname, int age) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
