package demo04.com.lyzdierzhoukaoxiangmu;

/**
 * Created by 小可爱 on 2017/11/13.
 */

public interface DownloadListner {
    void onFinished();

    void onProgress(float progress);

    void onPause();

    void onCancel();
}
