package chongchong.wei.mvvm_aac.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;

/**
 * 包名：chongchong.wei.mvvm_aac.base
 * 创建人：apple
 * 创建时间：2019-12-23 15:35
 * 描述：
 */
public abstract class BaseMvvmFragment<VM extends ViewModel, VDB extends ViewDataBinding> extends Fragment {
    protected VM mViewModel;
    protected VDB mViewDataBind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        mViewDataBind = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mViewDataBind.setLifecycleOwner(this);
        //获得泛型参数的实际类型
        Class<VM> vmClass = (Class<VM>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mViewModel = ViewModelProviders.of(this).get(vmClass);
        return mViewDataBind.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        afterCreate();
    }

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void afterCreate();
}
