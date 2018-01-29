package com.yich.layout.example.statusview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yich.layout.example.R;
import com.yich.libary.layout.StatusWrapLayout;
import com.yich.libary.layout.status.IStatusView;
import com.yich.libary.layout.status.OnUserClickListener;

/**
 * Created by yich on 2018/1/26.
 * 2016928168@qq.com
 */

public class MyEmptyView implements IStatusView {
    private View view;
    @Override
    public boolean initView(Context context) {
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.my_error_view,null);
        }
         TextView.class.cast(view.findViewById(R.id.title)).setText("this is custom empty page");
        TextView.class.cast(view.findViewById(R.id.content)).setText(" empty");
        return false;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public StatusWrapLayout.State getViewType() {
        return StatusWrapLayout.State.ERROR;
    }

    @Override
    public void onShowStatusView( final OnUserClickListener listener, Object... params) {
            if (listener!=null){
                view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });
            }

    }

    @Override
    public void onGoneStatusView(Object... params) {

    }

    @Override
    public void updataStatusView(OnUserClickListener listener, Object... param) {

    }
}
