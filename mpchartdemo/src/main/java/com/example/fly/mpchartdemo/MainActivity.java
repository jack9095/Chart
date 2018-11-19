package com.example.fly.mpchartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChart lineChart;// 声明图表控件


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = (LineChart) findViewById(R.id.lineChart);//绑定控件

        List<String> xDataList = new ArrayList<>();// x轴数据源
        List<Entry> yDataList = new ArrayList<>();// y轴数据数据源
        //给上面的X、Y轴数据源做假数据测试
        for (int i = 0; i < 24; i++) {
            // x轴显示的数据
            xDataList.add(i + ":00");
            //y轴生成float类型的随机数
            float value = (float) (Math.random() * 100) + 3;
            yDataList.add(new Entry(value, i));
        }

        //显示图表,参数（ 上下文，图表对象， X轴数据，Y轴数据，图表标题，曲线图例名称，坐标点击弹出提示框中数字单位）
        ChartUtil.showChart(this, lineChart, xDataList, yDataList, "供热趋势图", "供热量/时间", "kw/h");
    }
}
