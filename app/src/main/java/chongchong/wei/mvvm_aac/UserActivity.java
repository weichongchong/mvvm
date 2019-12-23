package chongchong.wei.mvvm_aac;

import android.view.View;

import chongchong.wei.mvvm_aac.base.BaseMvvmActivity;
import chongchong.wei.mvvm_aac.databinding.ActivityUserBinding;
import chongchong.wei.mvvm_aac.user.UserVM;

public class UserActivity extends BaseMvvmActivity<UserVM, ActivityUserBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void afterCreate() {
        mViewDataBind.setTitle("DataBinding绑定演示");
        mViewDataBind.setUserVM(mViewModel);
        mViewDataBind.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.getUser();
            }
        });
    }
}
