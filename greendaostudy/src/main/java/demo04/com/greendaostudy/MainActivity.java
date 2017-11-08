package demo04.com.greendaostudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo04.com.greendaostudy.app.MyApp;
import demo04.com.greendaostudy.bean.User;
import demo04.com.greendaostudy.gen.DaoSession;
import demo04.com.greendaostudy.gen.UserDao;
//可以参照这个网址
//http://www.jianshu.com/p/00d93c2d511f
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add;
    private Button bt_delete;
    private Button bt_updata;
    private Button bt_find;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DaoSession daoSessio = MyApp.getmInstance().getDaoSessio();
        userDao = daoSessio.getUserDao();

    }

    private void initView() {
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_updata = (Button) findViewById(R.id.bt_updata);
        bt_find = (Button) findViewById(R.id.bt_find);

        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_updata.setOnClickListener(this);
        bt_find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:

                List<User> list = new ArrayList<>();
                User useradd1 = new User(Long.valueOf(6),"张三");
                User useradd2 = new User(Long.valueOf(2),"李四");
                User useradd3 = new User(Long.valueOf(3),"王五");
                User useradd4 = new User(Long.valueOf(4),"赵六");
                User useradd5 = new User(Long.valueOf(5),"马七");
                list.add(useradd1);
                list.add(useradd2);
                list.add(useradd3);
                list.add(useradd4);
                list.add(useradd5);
                //userDao.insert(useradd);
                for (int i = 0; i<list.size();i++){
                    userDao.insert(list.get(i));
                }
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_delete:
                User userdelete = userDao.load(Long.valueOf(2));
                userDao.delete(userdelete);
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_updata:
                User useUpdata = userDao.load(Long.valueOf(2));
                useUpdata.setName("马9");
                userDao.update(useUpdata);//更新对象
                break;
            case R.id.bt_find:
                User userfind = userDao.load(Long.valueOf(2));
                String name = userfind.getName();
                Toast.makeText(this, "查询成功"+name, Toast.LENGTH_SHORT).show();

                List<User> userList = userDao.loadAll();
                for( User user: userList){
                    String userName = user.getName();
                    Toast.makeText(this, "查询成功"+userName, Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}
