package com.term;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;//根布局
    private Toolbar toolbar;//标题操作栏
    private NavigationView navigationView;//侧边栏
    private RecyclerView recycler;
    private MAdapter adapter;
    private List<ItemBean> list;

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
        recycler = findViewById(R.id.recycler);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        list = new ArrayList<>();
        adapter = new MAdapter(list, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    private void initDate() {
        ItemBean itemBean = new ItemBean();
        itemBean.setTitle("Nam dapibus nisl vitae");
        itemBean.setSubTitle("Breakfase");
        itemBean.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Utpretium pretium tempor. Ut eget imperdiet neque. In vo.");
        itemBean.setUserName("Alexandra Jones");
        itemBean.setPraiseNum("16");
        itemBean.setMessageNum("3");
        list.add(itemBean);
        adapter.notifyDataSetChanged();
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