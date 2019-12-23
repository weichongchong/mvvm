package chongchong.wei.mvvm_aac.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;

import chongchong.wei.mvvm_aac.R;
import chongchong.wei.mvvm_aac.user.UserVM;

/**
 * 包名：chongchong.wei.mvvm_aac.base
 * 创建人：apple
 * 创建时间：2019-12-20 13:26
 * 描述：MVVM架构，基类
 */
public abstract class BaseMvvmActivity<VM extends ViewModel, VDB extends ViewDataBinding> extends AppCompatActivity {
    protected VM mViewModel;
    protected VDB mViewDataBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mViewDataBind = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBind.setLifecycleOwner(this);
        //获得泛型参数的实际类型
        Class<VM> vmClass = (Class<VM>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mViewModel = ViewModelProviders.of(this).get(vmClass);

        afterCreate();
    }


    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void afterCreate();

}
