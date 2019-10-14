package com.code_base_update.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.code_base_update.beans.HostelNoticeBean;
import com.code_base_update.utility.DateUtils;
import com.medeveloper.ayaz.hostelutility.R;

import java.util.List;

public class HostelNoticeAdapter extends BaseRecyclerAdapter<HostelNoticeBean> {

    public HostelNoticeAdapter(Context context, int layoutResId, List<HostelNoticeBean> data) {
        super(context, layoutResId, data);
    }

    @Override
    void bindData(BaseViewHolder viewHolder, HostelNoticeBean item, int position) {
        viewHolder.setText(R.id.tv_notice_title, item.getNoticeId());
        viewHolder.setText(R.id.tv_faculty, item.getByFaculty());
        viewHolder.setText(R.id.tv_notice_date, DateUtils.getTime(item.getDate()));
        viewHolder.setText(R.id.tv_notice_body, item.getNoticeBody());
        if (item.getImageUrl() != null && item.getImageUrl().equals(""))
            viewHolder.setImageUrl(R.id.img_notice, item.getImageUrl());
        else viewHolder.setVisible(R.id.img_notice, false);
        final TextView noticeBody = viewHolder.getView(R.id.tv_notice_body);
        viewHolder.setOnClickListener(R.id.read_more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleReadMore(noticeBody);
            }
        });
    }

    private void toggleReadMore(TextView noticeBody) {
        //TODO toggle body size
    }

    @Override
    void updateDataOnTouch(int position) {

    }
}
