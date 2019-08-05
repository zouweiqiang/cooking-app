package cf.leaf.homework;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView batterLevel;
    private BroadcastReceiver batteryLevelRcvr;
    private IntentFilter batteryLevelFilter;
    private ViewPager viewPager;
    private List<ImageView> imageViewList;
    private int images[] = {R.drawable.topbg, R.drawable.f2, R.drawable.f3};
    private ImageView icons[];//用来存放多个dot的数组
    private LinearLayout linearLayout;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        batterLevel = (TextView)findViewById(R.id.batteryLevel);



        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout = (LinearLayout) findViewById(R.id.ll);
        initData();  //创建数据源
        initIcons();
        //创建适配器
        MyAdapter adapter = new MyAdapter();
        viewPager.setAdapter(adapter);
        //定义Viewpager的监听事件
        //        viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        //            @Override
        //            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
        //
        //            }
        //        });
        //
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position   当前滑动选中位置 position
             * @param positionOffset   位置偏移 [0,1)
             * @param positionOffsetPixels  page页滑动的像素值
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                System.out.println("aaa"+"onPageScrolled----position:" + position + ",positionOffset:" + positionOffset + ",positionOffsetPixels:"
                        + positionOffsetPixels + "-----");

                Log.i("aaa", "onPageScrolled----position:" + position + ",positionOffset:" + positionOffset + ",positionOffsetPixels:"
                        + positionOffsetPixels + "-----");
            }

            /**
             * 页面选中时回调方法
             * @param position   选中的page页索引值
             */
            @Override
            public void onPageSelected(int position) {
                System.out.println("");
                Log.i("aaa", "onPageSelected-----position:" + position + "-----");
                for (int i = 0; i < icons.length; i++) {
                    icons[i].setEnabled(true);
                }
                icons[position].setEnabled(false);
            }

            /**
             *  滚动状态发生改变时回调方法
             *  int state：表示状态
             *  SCROLL_STATE_IDEL  停止状态
             *  SCROLL_STATE_FLYING  快速滑动状态
             *  SCROLL_STATE_TOUCH_SCROLL  触摸滑动状态
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("aaa", "---onPageScrollStateChanged--state:" + state + "-----");
            }
        });
    }


    //初始化数据源
    public void initData() {
        imageViewList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(images[i]);
            imageViewList.add(iv);
        }
    }

    //初始化dot小图标
    public void initIcons() {
        icons = new ImageView[images.length];
        for (int i = 0; i < icons.length; i++) {
            //获取容器中第i个子
            icons[i] = (ImageView) linearLayout.getChildAt(i);
            icons[i].setEnabled(true);
            //给ImageView贴标签
            icons[i].setTag(i);
            //etClickable()是设置控件点击无效，但是可以点击，颜色不会变灰色。
            icons[i].setClickable(true);
            //给ImageView定义选中点击事件
            //点击dot，Viewpager页面也要发生改变
            icons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //设置viewPager当前的Item是第(int)view.getTag()个
                    viewPager.setCurrentItem((int) view.getTag());
                }
            });
        }
        icons[0].setEnabled(false);
    }

    //自定义一个适配器
    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            Log.i("aa", "---------instantiateItem---------" + position);
            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //            super.destroyItem(container, position, object);
            Log.i("aa", "---------destroyItem---------" + position);
            container.removeView(imageViewList.get(position));
        }
    }

    public void click(View view) {
        Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
        this.startActivity(intent);

    }











}
