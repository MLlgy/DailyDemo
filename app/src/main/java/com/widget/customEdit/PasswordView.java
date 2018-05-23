package com.widget.customEdit;

/**
 * Creater: liguoying
 * Time: 2018/5/23 0023 15:11
 */
public interface PasswordView {
    String getPassWord();

    /**清除文本*/
    void clearPassword();
    /**设置文本*/
    void setPassword(String password);
    /**设置文本是否显示（密文还是明文）*/
    void setPasswordVisibility(boolean visible);
    /**获取文本显示类型（密文还是明文）*/
    boolean getPassWordVisibility();
    /**切换文本显示（密文还是明文）*/
    void togglePasswordVisibility();
    /**设置文本操作回调*/
    void setOnPasswordChangedListener(CustomPasswordView.OnPasswordChangedListener listener);
    /**设置输入文本类型*/
    void setPasswordType(PasswordType passwordType);
}
