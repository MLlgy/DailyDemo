package com.widget.customEdit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidwebviewdemo.mddemo.R;
import com.utils.DisplayUtil;

/**
 * Creater: liguoying
 * Time: 2018/5/23 0023 15:10
 */
public class CustomPasswordView extends LinearLayout implements PasswordView,TextView.OnEditorActionListener  {

    private static final int DEFAULT_PASSWORDLENGTH = 6;
    private static final int DEFAULT_TEXTSIZE = 16;
    private static final String DEFAULT_TRANSFORMATION = "●";
    private static final int DEFAULT_LINECOLOR = 0xaa888888;
    private static final int DEFAULT_GRIDCOLOR = 0xffffffff;

    private ColorStateList mTextColor;
    private int mTextSize = DEFAULT_TEXTSIZE;
    private int mLineWidth;
    private int mLineColor;
    private int mGridColor;
    private Drawable mLineDrawable;
    //    private Drawable mOuterLineDrawable;外部边框
    private int mPasswordLength;
    private String mPasswordTransformation;
    private int mPasswordType;

    private String[] mPasswordArr;
    private TextView[] mViewArr;

    public ImeDelFixedEditText getmInputView() {
        return mInputView;
    }

    private ImeDelFixedEditText mInputView;
    private OnPasswordChangedListener mListener;
    private PasswordTransformationMethod mTransformationMethod;
    private Context mContext;

    public CustomPasswordView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomPasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomPasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomPasswordView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        initAttrs(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomPasswordView, defStyleAttr, 0);
        mTextColor = typedArray.getColorStateList(R.styleable.CustomPasswordView_npvTextColor);
        if (mTextColor == null) {
            mTextColor = ColorStateList.valueOf(getResources().getColor(R.color.font_public_dark));
        }
        int textSize = typedArray.getDimensionPixelSize(R.styleable.CustomPasswordView_npvTextSize, -1);
        if (mTextSize == -1) {
            this.mTextSize = (int) DisplayUtil.px2sp(context,textSize);
        }
        mLineWidth = (int) typedArray.getDimension(R.styleable.CustomPasswordView_npvLineWidth, 1);
        mLineColor = typedArray.getColor(R.styleable.CustomPasswordView_npvLineColor, DEFAULT_LINECOLOR);
        mGridColor = typedArray.getColor(R.styleable.CustomPasswordView_npvGridColor, DEFAULT_GRIDCOLOR);
        mLineDrawable = typedArray.getDrawable(R.styleable.CustomPasswordView_npvLineColor);
        if (mLineDrawable == null) {
            mLineDrawable = new ColorDrawable(mLineColor);
        }
//        mOuterLineDrawable = generateBackgroundDrawable();
        mPasswordLength = typedArray.getInt(R.styleable.CustomPasswordView_npvPasswordLength, DEFAULT_PASSWORDLENGTH);
        mPasswordTransformation = typedArray.getString(R.styleable.CustomPasswordView_npvPasswordTransformation);
        if (TextUtils.isEmpty(mPasswordTransformation)) {
            mPasswordTransformation = DEFAULT_TRANSFORMATION;
        }
        mPasswordType = typedArray.getInt(R.styleable.CustomPasswordView_npvPasswordType, 0);

        typedArray.recycle();
        mPasswordArr = new String[mPasswordLength];
        mViewArr = new TextView[mPasswordLength];
    }

    private void initViews(Context context) {
//        super.setBackgroundDrawable(mOuterLineDrawable);
        setShowDividers(SHOW_DIVIDER_NONE);
        setOrientation(HORIZONTAL);

        mTransformationMethod = new CustomPasswordTransformationMethod(mPasswordTransformation);
        inflaterViews(context);
    }

    private void inflaterViews(Context context) {
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.number_password_view_layout, this);
        mInputView = (ImeDelFixedEditText) findViewById(R.id.inputView);
        mInputView.setMaxEms(mPasswordLength);
        mInputView.addTextChangedListener(textWatcher);
        mInputView.setDelKeyEventListener(onDelKeyEventListener);
        mInputView.setOnEditorActionListener(this);
        setCustomAttr(mInputView);

        mViewArr[0] = mInputView;
        int index = 1;
        while (index < mPasswordLength) {
//            View dividerView = inflater.inflate(R.layout.number_password_view_divider, null);
//            LayoutParams dividerParams = new LayoutParams(mLineWidth, LayoutParams.MATCH_PARENT);
//            dividerView.setBackgroundDrawable(mLineDrawable);
//            addView(dividerView, dividerParams);

            View view = new View(mContext);
            LayoutParams dividerParams0 = new LayoutParams(DisplayUtil.dip2px(context,5), LayoutParams.MATCH_PARENT);
            addView(view, dividerParams0);

            TextView textView = (TextView) inflater.inflate(R.layout.number_password_view_textview, null);
            setCustomAttr(textView);
            LayoutParams textViewParams = new LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);
            addView(textView, textViewParams);

            mViewArr[index] = textView;
            index++;
        }
        setOnClickListener(mOnClickListener);
    }

    /**
     * 设置EditTextInputType
     */
    private void setCustomAttr(TextView view) {
        if (mTextColor != null)
            view.setTextColor(mTextColor);
        view.setTextSize(mTextSize);
        //华为安全键盘有bug不能用后者
        int inputType = InputType.TYPE_CLASS_NUMBER/* | InputType.TYPE_NUMBER_VARIATION_PASSWORD*/;
        switch (mPasswordType) {

            case 1:
                inputType = InputType.TYPE_CLASS_TEXT/* | InputType.TYPE_TEXT_VARIATION_PASSWORD*/;
                break;

            case 2:
                inputType = InputType.TYPE_CLASS_TEXT/* | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD*/;
                break;

            case 3:
                inputType = InputType.TYPE_CLASS_TEXT /*| InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD*/;
                break;
        }
        view.setInputType(inputType);
        view.setTransformationMethod(mTransformationMethod);
    }

    /**
     * 生成密码输入框边线
     */
    private GradientDrawable generateBackgroundDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(mGridColor);
        drawable.setStroke(mLineWidth, mLineColor);
        return drawable;
    }

    /**
     * 填写字符监听
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s == null) {
                return;
            }
            String newStr = s.toString();
            if (newStr.length() == 1) {
                mPasswordArr[0] = newStr;
                notifyTextChanged();
            }
            else if (newStr.length() == 2) {
                String newNum = newStr.substring(1);
                for (int i = 0; i < mPasswordArr.length; i++) {
                    if (mPasswordArr[i] == null) {
                        mPasswordArr[i] = newNum;
                        mViewArr[i].setText(newNum);
                        notifyTextChanged();
                        break;
                    }
                }
                mInputView.removeTextChangedListener(this);
                mInputView.setText(mPasswordArr[0]);
                if (mInputView.getText().length() >= 1) {
                    mInputView.setSelection(1);
                }
                mInputView.addTextChangedListener(this);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    /**
     * 删除字符监听
     */
    private ImeDelFixedEditText.OnDelKeyEventListener onDelKeyEventListener = new ImeDelFixedEditText.OnDelKeyEventListener() {
        @Override
        public void onDeleteClick() {
            for (int i = mPasswordArr.length - 1; i >= 0; i--) {
                if (mPasswordArr[i] != null) {
                    mPasswordArr[i] = null;
                    mViewArr[i].setText(null);
                    notifyTextChanged();
                    break;
                }
                else {
                    mViewArr[i].setText(null);
                }
            }
        }
    };
    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            forceInputViewGetFocus();
        }
    };

    /**
     * EditText获得焦点
     */
    private void forceInputViewGetFocus() {
        mInputView.setFocusable(true);
        mInputView.setFocusableInTouchMode(true);
        mInputView.requestFocus();
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mInputView, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 设置字符更新监听
     */
    private void notifyTextChanged() {
        if (mListener == null)
            return;

        String currentPsw = getPassWord();
        mListener.onTextChanged(currentPsw);

        if (currentPsw.length() == mPasswordLength)
            mListener.onInputFinish(currentPsw);
    }

    /**
     * 获取密码文本
     */
    @Override
    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mPasswordArr.length; i++) {
            if (mPasswordArr[i] != null)
                sb.append(mPasswordArr[i]);
        }
        return sb.toString();
    }

    /**
     * 清空密码
     */
    @Override
    public void clearPassword() {
        for (int i = 0; i < mPasswordArr.length; i++) {
            mPasswordArr[i] = null;
            mViewArr[i].setText(null);
        }
    }

    /**
     * 设置密码文本
     */
    @Override
    public void setPassword(String password) {
        clearPassword();

        if (TextUtils.isEmpty(password))
            return;

        char[] pswArr = password.toCharArray();
        for (int i = 0; i < pswArr.length; i++) {
            if (i < mPasswordArr.length) {
                mPasswordArr[i] = pswArr[i] + "";
                mViewArr[i].setText(mPasswordArr[i]);
                if(i>0){
                    notifyTextChanged();
                }
            }
        }
    }

    /**
     * 设置密码是否显示明文
     */
    @Override
    public void setPasswordVisibility(boolean visible) {
        for (TextView textView : mViewArr) {
            textView.setTransformationMethod(visible ? null : mTransformationMethod);
            if (textView instanceof EditText) {
                EditText et = (EditText) textView;
                et.setSelection(et.getText().length());
            }
        }
    }

    /**
     * 获取密码显示类型（明文还是密文）
     */
    public boolean getPassWordVisibility() {
        return mViewArr[0].getTransformationMethod() == null;
    }

    /**
     * 切换密码（明文还是密文显示）
     */
    @Override
    public void togglePasswordVisibility() {
        boolean currentVisible = getPassWordVisibility();
        setPasswordVisibility(!currentVisible);
    }

    /**
     * 设置密码文本类型
     */
    @Override
    public void setPasswordType(PasswordType passwordType) {
        boolean visible = getPassWordVisibility();
        int inputType = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD;
        switch (passwordType) {

            case TEXT:
                inputType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;
                break;

            case TEXTVISIBLE:
                inputType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
                break;

            case TEXTWEB:
                inputType = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD;
                break;
        }

        for (TextView textView : mViewArr)
            textView.setInputType(inputType);

        setPasswordVisibility(visible);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putStringArray("passwordArr", mPasswordArr);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mPasswordArr = bundle.getStringArray("passwordArr");
            state = bundle.getParcelable("instanceState");
            mInputView.removeTextChangedListener(textWatcher);
            setPassword(getPassWord());
            mInputView.addTextChangedListener(textWatcher);
        }
        super.onRestoreInstanceState(state);
    }



    /**
     * 设置密码文本更新监听
     */
    @Override
    public void setOnPasswordChangedListener(OnPasswordChangedListener listener) {
        this.mListener = listener;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (onEditorActionListener != null) {
            onEditorActionListener.onEditorActionListener(v, actionId, event);
        }
        return false;
    }

    /**
     * 用来回调（当文本改变时或者达到最大的长度）
     */
    public interface OnPasswordChangedListener {
        /**
         * 文本改变
         *
         * @param psw new text
         */
        void onTextChanged(String psw);

        /**
         * 文本达到最大长度
         *
         * @param psw complete text
         */
        void onInputFinish(String psw);

    }

    @Override
    public void setBackground(Drawable background) {
    }

    @Override
    public void setBackgroundColor(int color) {
    }

    @Override
    public void setBackgroundResource(int resid) {
    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.onEditorActionListener = onEditorActionListener;
    }

    private OnEditorActionListener onEditorActionListener;
    public interface OnEditorActionListener{
        void onEditorActionListener(TextView v, int actionId, KeyEvent event);
    }
}
