package com.widget.customEdit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/**
 * Creater: liguoying
 * Time: 2018/5/23 0023 15:12
 */
public class ImeDelFixedEditText extends EditText {
    private OnDelKeyEventListener delKeyEventListener;

    public ImeDelFixedEditText(Context context) {
        super(context);
    }

    public ImeDelFixedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImeDelFixedEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return new CustomizedInputConnection(super.onCreateInputConnection(outAttrs),true);
    }

    private class CustomizedInputConnection extends InputConnectionWrapper {
        public CustomizedInputConnection(InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        @Override
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            if (beforeLength == 1 && afterLength == 0) {
                return sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL)) && sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            }
            return super.deleteSurroundingText(beforeLength,afterLength);
        }

        @Override
        public boolean sendKeyEvent(KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                if (delKeyEventListener != null) {
                    delKeyEventListener.onDeleteClick();
                    return true;
                }
            }
            return super.sendKeyEvent(event);
        }
    }

    public void setDelKeyEventListener(OnDelKeyEventListener delKeyEventListener) {
        this.delKeyEventListener = delKeyEventListener;
    }
    public interface OnDelKeyEventListener {
        void onDeleteClick();
    }
}
