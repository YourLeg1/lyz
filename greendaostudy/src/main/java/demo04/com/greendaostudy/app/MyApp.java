package demo04.com.greendaostudy.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import demo04.com.greendaostudy.gen.DaoMaster;
import demo04.com.greendaostudy.gen.DaoSession;

/**
 * Created by 小可爱 on 2017/11/6.
 */

//类的用途 ：单例设计模式
public class MyApp extends Application{
    private static MyApp mInstance;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setDb();
    }


    public static MyApp getmInstance(){
        return mInstance;
    }


    private void setDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "bw.dbb", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

    }
    public DaoSession getDaoSessio(){
        return daoSession;
    }
}
