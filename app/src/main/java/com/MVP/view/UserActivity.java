package com.MVP.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;


import com.MVP.presenter.UserPresenter;
import com.R;

public class UserActivity extends AppCompatActivity implements IUserView, OnClickListener {

    private static final String TAG = "UserActivity";

    private TextView mOk, mCancel;
    private EditText mName, mMima, mID;

    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mCancel = (TextView) findViewById(R.id.tv_btn_cancel);
        mMima = (EditText) findViewById(R.id.et_mima);
        mName = (EditText) findViewById(R.id.et_name);
        mOk = (TextView) findViewById(R.id.tv_btn_ok);
        mID = (EditText) findViewById(R.id.et_id);
        userPresenter = new UserPresenter(this);
        mOk.setOnClickListener(this);
        mCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_btn_ok:
//                与用户进行交互，获得数据，将数据传递至presenter进行逻辑的操作
                userPresenter.saveUser(getID(),getFirstName(),getLastName());
                break;
            case R.id.tv_btn_cancel:
                userPresenter.loadUser(getID());
                break;
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return new Integer(mID.getText().toString());
    }

    @Override
    public String getFirstName() {
        return mName.getText().toString();
    }

    @Override
    public String getLastName() {
        return mMima.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        Log.e(TAG, "setFirstName: "+firstName );
        mName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        Log.e(TAG, "setLastName: "+lastName );
        mMima.setText(lastName);
    }


}
