package com.term;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;//根布局
    private Toolbar toolbar;//标题操作栏
    private NavigationView navigationView;//侧边栏
    private ImageView topImg, bottomImg, userImg, praiseImg, messageImg;
    private TextView title, subTitle, content, praiseNum, messageNum, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDate();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        topImg = findViewById(R.id.item_img);
        bottomImg = findViewById(R.id.bottom_img);
        userImg = findViewById(R.id.user_img);
        title = findViewById(R.id.item_title);
        subTitle = findViewById(R.id.item_sub_title);
        content = findViewById(R.id.item_content);
        praiseNum = findViewById(R.id.praise_num);
        messageNum = findViewById(R.id.message_num);
        userName = findViewById(R.id.user_name);
        praiseImg = findViewById(R.id.message_praise);
        messageImg = findViewById(R.id.message_img);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        praiseImg.setOnClickListener(new View.OnClickListener() {
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
        messageImg.setOnClickListener(new View.OnClickListener() {
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

    private void initDate() {
        topImg.setBackgroundResource(R.mipmap.coffee_top);
        bottomImg.setBackgroundResource(R.mipmap.chocolate_icon);
        userImg.setBackgroundResource(R.mipmap.head_icon);
        title.setText("Nam dapibus nisl vitae");
        subTitle.setText("Breakfase");
        content.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Utpretium pretium tempor. Ut eget imperdiet neque. In vo.");
        userName.setText("Alexandra Jones");
        praiseNum.setText("16");
        messageNum.setText("3");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(this, "点击搜索", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item1) {
            Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item2) {
            Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.one) {
            Toast.makeText(this, "点击第一项", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.two) {
            Toast.makeText(this, "点击第二项", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.three) {
            Toast.makeText(this, "点击第三项", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.four) {
            Toast.makeText(this, "点击第四项", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
