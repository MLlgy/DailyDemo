package com.commonActivities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.androidwebviewdemo.mddemo.R;
import com.takePhotoWithPerssion.ToastUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.PermissionNo;
import com.yanzhenjie.permission.PermissionYes;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author liguoying
 * @date 2017/12/5.
 */

public class AdActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_and_permission);
        findViewById(R.id.tv_permission_request_listener_callback).setOnClickListener(view ->
//                getAndPermission()
                        getPermissionAnnotion()
        );

    }

    private void getAndPermission() {
        PermissionListener listener = new PermissionListener() {
            @Override
            public void onSucceed(int requestCode, List<String> grantedPermissions) {
                // Successfully.
                if (requestCode == 200) {
                    String str = null;
                    for (String gr : grantedPermissions) {
                        str += gr;
                    }
                    ToastUtils.show(AdActivity.this, str, 2000);
                }
            }

            @Override
            public void onFailed(int requestCode, List<String> deniedPermissions) {
                // Failure.
                if (requestCode == 200) {
                    ToastUtils.show(AdActivity.this, "failed", 2000);
                }
            }
        };
        AndPermission.with(this)
                .requestCode(200)
                .permission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .callback(listener)
                .start();
    }

    private void getPermissionAnnotion() {
        AndPermission.with(this)
                .requestCode(300)
                .permission(Manifest.permission.READ_PHONE_STATE)
                .callback(this)
                .rationale((requestCode, rationale) ->
                        AndPermission.rationaleDialog(this, rationale).show()
                ).start();

    }

    // The 300 is the the requestCode().
    @PermissionYes(300)
    private void getPermissionYes(List<String> grantedPermissions) {
        ToastUtils.show(AdActivity.this, "success " + grantedPermissions.get(0), 2000);
    }

    @PermissionNo(300)
    private void getPermissionNo(List<String> deniedPermissions) {
//        AndPermission.defaultSettingDialog(this, 300).show();
        AndPermission.defaultSettingDialog(this, 400)
                .setTitle("权限申请失败")
                .setMessage("您拒绝了我们必要的一些权限，已经没法愉快的玩耍了，请在设置中授权！")
                .setPositiveButton("好，去设置")
                .show();
        ToastUtils.show(AdActivity.this, "failed " + deniedPermissions.get(0), 2000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 400: { // 这个400就是上面defineSettingDialog()的第二个参数。
                // 你可以在这里检查你需要的权限是否被允许，并做相应的操作。
                ToastUtils.show(AdActivity.this, "showdhfodhf", 2000);
                break;

            }
            default:
                break;
        }
    }
}
