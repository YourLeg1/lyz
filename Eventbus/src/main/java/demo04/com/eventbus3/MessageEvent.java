package demo04.com.eventbus3;

/**
 * Created by 小可爱 on 2017/11/8.
 */

public class MessageEvent {
    public String msg;
    public int code;

    public MessageEvent(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
