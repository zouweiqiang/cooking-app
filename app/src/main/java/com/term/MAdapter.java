package com.term;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {
    private List<ItemBean> list;
    private Context context;

    public MAdapter(List<ItemBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.ViewHolder viewHolder, int i) {
        viewHolder.topImg.setBackgroundResource(R.mipmap.coffee_top);
        viewHolder.bottomImg.setBackgroundResource(R.mipmap.chocolate_icon);
        viewHolder.userImg.setBackgroundResource(R.mipmap.head_icon);
        viewHolder.title.setText(list.get(i).getTitle());
        viewHolder.subTitle.setText(list.get(i).getSubTitle());
        viewHolder.content.setText(list.get(i).getContent());
        viewHolder.userName.setText(list.get(i).getUserName());
        viewHolder.praiseNum.setText(list.get(i).getPraiseNum());
        viewHolder.messageNum.setText(list.get(i).getMessageNum());
        viewHolder.praiseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AnimationUtil.AlphaScaleAnimator(v, new AnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v.animate().alpha(1).scaleX(1).scaleY(1);
                    }
                });
            }
        });
        viewHolder.messageImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AnimationUtil.AlphaScaleAnimator(v, new AnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v.animate().alpha(1).scaleX(1).scaleY(1);
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView topImg, bottomImg, userImg, praiseImg, messageImg;
        TextView title, subTitle, content, praiseNum, messageNum, userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topImg = itemView.findViewById(R.id.item_img);
            bottomImg = itemView.findViewById(R.id.bottom_img);
            userImg = itemView.findViewById(R.id.user_img);
            title = itemView.findViewById(R.id.item_title);
            subTitle = itemView.findViewById(R.id.item_sub_title);
            content = itemView.findViewById(R.id.item_content);
            praiseNum = itemView.findViewById(R.id.praise_num);
            messageNum = itemView.findViewById(R.id.message_num);
            userName = itemView.findViewById(R.id.user_name);
            praiseImg = itemView.findViewById(R.id.message_praise);
            messageImg = itemView.findViewById(R.id.message_img);
        }
    }
}
