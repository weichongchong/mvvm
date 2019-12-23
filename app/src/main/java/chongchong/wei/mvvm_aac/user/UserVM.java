package chongchong.wei.mvvm_aac.user;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 包名：chongchong.wei.mvvm_aac.User
 * 创建人：apple
 * 创建时间：2019-12-13 15:59
 * 描述：
 */
public class UserVM extends ViewModel {
    public final MutableLiveData<User> mUser = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("weicc_mvvm_", "onCleared");
    }

    public void getUser() {
        //模拟 http 获取数据
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //DataBind 会帮你做线程切换
                User user = new User("小明", "男", 12);
                mUser.setValue(user);
            }
        };
        handler.postDelayed(runnable, 2000);
    }
}
