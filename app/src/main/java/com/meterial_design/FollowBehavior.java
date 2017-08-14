package com.meterial_design;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by liguoying on 2017/8/14.
 */

public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {
    /**
     * 构造方法
     */
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断child的布局是否依赖dependency
     * 根据逻辑来判断返回值，返回false表示不依赖，返回true表示依赖
     *
     * 在一个交互行为中，dependent view的变化决定了另一个相关View的行为。
     * 在这个例子中，Button就是dependent view，因为TextView跟随着它。
     *
     *
     * 实际上dependent view就相当于我们前面介绍的被观察者
     * layoutDependsOn()：这个方法在对界面进行布局时至少会调用一次，
     * 用来确定本次交互行为中的 Dependent View，在上面的代码中，当 Dependency 是Button 类的实例时返回 true，
     * 就可以让系统知道布局文件中的 Button 就是本次交互行为中的 Dependent View。
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    /**
     * onDependentViewChanged()：当 Dependent View 发生变化时，这个方法会被调用，
     * 参数中的child相当于本次交互行为中的观察者，观察者可以在这个方法中对被观察者的变化做出响应，从而完成一次交互行为
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY() + 200);
        return true;
    }
}
