package com.controller;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.NumberFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jfree.chart.ChartFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.StandardChartTheme;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Course;
import com.model.Grade;
import com.model.Score;
import com.model.Student;
import com.services.ClassService;
import com.services.CommonService;


@Controller
public class ChartController {

	@Resource
	ClassService gradeService;
	@Resource
	CommonService commonService;
	
	@RequestMapping("chart1")
	public ModelAndView chart1(HttpServletRequest request) throws IOException {
	
		//得到一个柱状图的数据集
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(300, "qq", "q1");
		dataset.setValue(400, "qq", "q2");
		dataset.setValue(200, "qq", "q3");
		dataset.setValue(100, "qq", "q4");
		
		JFreeChart chart =  ChartFactory.createBarChart("统计图", "水果", "销售", dataset, PlotOrientation.VERTICAL, true, true, true);
	
		String chart1 = ServletUtilities.saveChartAsPNG(chart, 500, 300, request.getSession());
		
		////***********
	/*	double [][]data=new double[][]{{1320,1110,1123},{720,210,1423},{830,1310,123}};
		String []columnKeys={"深圳","北京","上海"};
		String []rowKeys={"苹果","香蕉","橘子"};
		*/
		 double[][] data = new double[][] { 
			 { 672, 766, 223, 540, 126 },
             { 325, 521, 210, 340, 106 }, 
             { 332, 256, 523, 240, 526 } };
             
     String[]  yKeys= { "苹果", "梨子", "葡萄" };
     String[]  xKeys= { "北京", "上海", "广州", "成都", "深圳" };
  
     
		CategoryDataset dataset2=DatasetUtilities.createCategoryDataset(yKeys ,xKeys,data);
		//设置工厂属性
		JFreeChart  chartt = ChartFactory.createBarChart3D("水果销售统计图", "水果", "销售", dataset2,PlotOrientation.VERTICAL, true, true, true);
		//报表样式对象
		CategoryPlot plot=chartt.getCategoryPlot();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
	    plot.setRangeGridlinePaint(Color.pink);
		
		// 显示数子
		BarRenderer3D renderer=new BarRenderer3D();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);		
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);  
		// 设置平行柱的之间距离
		renderer.setItemMargin(0.2);

		
		plot.setRenderer(renderer);
		String chart2 = ServletUtilities.saveChartAsPNG(chartt, 600, 500, request.getSession());
		
		///****
			 
				 
		List<Grade> grade = gradeService.selectAll1();
		
		List<Score> score = commonService.selectAllScore();
		
		List<Course> course = commonService.selectAllCourse();
		
		 double[][] data3 = new double[course.size()][grade.size()];
		 String[]  xKeys2= new String[grade.size()];
	     String[]  yKeys2= new String[course.size()];		
		////---------每个班级，每门课程的平均成绩
		int class_num = grade.size();
		int course_num = course.size();
		
		//每个班级
		for(int i =0 ; i<class_num;i++) {
			
			xKeys2[i] = grade.get(i).getGrade()+grade.get(i).getClass_name();
			//每门课程
			//
			List<Student> stu = grade.get(i).getStudents();
			for(int j = 0 ;j < course_num ; j++) {
				//课程ID
				int cid = course.get(j).getCid();
				yKeys2[j] = course.get(j).getCname();
				//该门课程所有成绩
				double sum = 0;
				int num = 0;
				//统计该班级的所有学生的分数
				for(int k = 0 ; k < stu.size() ; k++) {
					for( int m = 0 ; m < score.size() ; m++) {
						if( stu.get(k).getSid() == score.get(m).getSid() && cid == score.get(m).getCid()) {
							sum += score.get(m).getScore();
							num++;
						}
					}
				}
				
				if(sum == 0 ) {
					data3[j][i]=0.0;
				}else {
					data3[j][i]=sum/(num*1.0);
				}
				
				//
			}
		}
		
		for( int i = 0 ; i < data3.length ; i++) {
			for(int j =0 ; j < data3[i].length ; j++)
			   System.out.print("--"+data3[i][j]);
			System.out.println("");
		}
		
		for(int j =0 ; j < xKeys2.length ; j++)
			   System.out.print("==="+xKeys2[j]);
		System.out.println("");
		for(int j =0 ; j < yKeys2.length ; j++)
			   System.out.print("***"+yKeys2[j]);
		
		
		CategoryDataset dataset3=DatasetUtilities.createCategoryDataset(yKeys2,xKeys2 ,data3);
		//设置工厂属性
		JFreeChart  chartt3 = ChartFactory.createBarChart3D("统计图", "课程", "平均成绩", dataset3,PlotOrientation.VERTICAL, true, true, true);
	
		
		String chart3 = ServletUtilities.saveChartAsPNG(chartt3, 500, 300, request.getSession());	
			
			
			///-----
		ModelAndView mv = new ModelAndView();
		mv.addObject("chart1", chart1);
		mv.addObject("chart2", chart2);
		mv.addObject("chart3", chart3);
		mv.setViewName("/chart/chart1.jsp");
		
		return mv;
	}
	
	@RequestMapping("chart2")
	public String chart2(HttpServletRequest request) throws IOException {
		
		//为饼状图  建立一个数据集合
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		dataset.setValue("黑心矿", 1000);
		dataset.setValue("醉酒驾驶", 800);
		dataset.setValue("城管强拆", 400);
		dataset.setValue("医疗事故", 100);
		dataset.setValue("其他", 29);
		
		//建立图表对象  （ 标题， 数据集合，
		JFreeChart chart = ChartFactory.createPieChart3D("非正常死亡人数分布图", dataset, true, true, true);
		chart.addSubtitle(new TextTitle("2013年度"));
		
		PiePlot pieplot = (PiePlot) chart.getPlot();
		
		
		pieplot.setLabelFont(new Font("宋体",0,11));
		// 设置饼图是圆的（true），还是椭圆的（false）；默认为true  
		pieplot.setCircular(false);
		pieplot.setNoDataMessage("无数据显示");
		
		//标签格式，请使用{0}插入饼图部分的键，{1}代表绝对部分的值，{2}代表饼图部分的百分比，例如"{0} = {1} ({2})"将显示为 apple = 120 (5%)。
		StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator(
				"{0}:({1}.{2})",
				NumberFormat.getNumberInstance(), 
				NumberFormat.getPercentInstance());  
		pieplot.setLabelGenerator(standarPieIG);  
		
		
		PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
		//设置开始角度  
				pieplot3d.setStartAngle(120D);  
				//设置方向为”顺时针方向“  
				pieplot3d.setDirection(Rotation.CLOCKWISE);  
				//设置透明度，0.5F为半透明，1为不透明，0为全透明  
				pieplot3d.setForegroundAlpha(1F); 
		
		String chart21 = ServletUtilities.saveChartAsPNG(chart, 700, 500, null, request.getSession());
		
		
		List<Score> score = commonService.selectAllScore();
		Map<String , Integer> map = new HashMap<String , Integer>();
		
		for(int i = 0 ; i <score.size() ; i++) {
			String cname = score.get(i).getCname();
			
			Integer num =  map.get(cname) ;
			if ( num == null) {
				map.put(cname, 1) ;
			}else {
				map.put(cname, num++);
			}
		}
		
		DefaultPieDataset dataset2 = new DefaultPieDataset();
		Set<Entry<String ,Integer>> set = map.entrySet();
		for(Entry<String ,Integer> e : set) {
			System.out.println(e.getKey()+"---"+e.getValue());
			dataset2.setValue(e.getKey(), e.getValue());
			
		}
				
		
		
		//建立图表对象  （ 标题， 数据集合，
		JFreeChart jfreechart = ChartFactory.createPieChart3D("非正常死亡人数分布图", dataset2, true, true, true);
		jfreechart.addSubtitle(new TextTitle("2018年度"));
		
		PiePlot pieplot2 = (PiePlot) jfreechart.getPlot();
		
		
		pieplot2.setLabelFont(new Font("宋体",0,11));
		// 设置饼图是圆的（true），还是椭圆的（false）；默认为true  
		pieplot2.setCircular(false);
		pieplot2.setNoDataMessage("无数据显示");
		
		//标签格式，请使用{0}插入饼图部分的键，{1}代表绝对部分的值，{2}代表饼图部分的百分比，例如"{0} = {1} ({2})"将显示为 apple = 120 (5%)。
		StandardPieSectionLabelGenerator standarPieIG2 = new StandardPieSectionLabelGenerator(
				"{0}:({1}.{2})",
				NumberFormat.getNumberInstance(), 
				NumberFormat.getPercentInstance());  
		pieplot2.setLabelGenerator(standarPieIG2);  
		
		
		PiePlot3D pieplot3d2 = (PiePlot3D)jfreechart.getPlot(); 
		//设置开始角度  
				pieplot3d2.setStartAngle(120D);  
				//设置方向为”顺时针方向“  
				pieplot3d2.setDirection(Rotation.CLOCKWISE);  
				//设置透明度，0.5F为半透明，1为不透明，0为全透明  
				pieplot3d2.setForegroundAlpha(1F); 
		
		String chart22 = ServletUtilities.saveChartAsPNG(jfreechart, 700, 500, null, request.getSession());
		
		
		request.setAttribute("chart21", chart21);
		request.setAttribute("chart22", chart22);
		return "chart/chart2.jsp";
	}
	
	@RequestMapping("chart3")
	public String chart3(HttpServletRequest request) throws IOException {
		
		TimeSeries time  = new TimeSeries("A网站访问统计量",Month.class);
				time.add(new Month(1,2013) ,100);
				time.add(new Month(2,2013), 200);
				time.add(new Month(3,2013), 300);
				time.add(new Month(4,2013), 400);
				time.add(new Month(5,2013), 560);
				time.add(new Month(6,2013), 600);
				time.add(new Month(7,2013), 750);
				time.add(new Month(8,2013), 890);
				time.add(new Month(9,2013), 120);
				time.add(new Month(10,2013), 400);
				time.add(new Month(11,2013), 1200);
				time.add(new Month(12,2013), 1600);
				
				// 访问量统计
				TimeSeries timeSeries2=new TimeSeries("B网站访问量统计", Month.class);
				// 添加数据
				timeSeries2.add(new Month(1,2013), 50);
				timeSeries2.add(new Month(2,2013), 100);
				timeSeries2.add(new Month(3,2013), 150);
				timeSeries2.add(new Month(4,2013), 200);
				timeSeries2.add(new Month(5,2013), 220);
				timeSeries2.add(new Month(6,2013), 300);
				timeSeries2.add(new Month(7,2013), 340);
				timeSeries2.add(new Month(8,2013), 400);
				timeSeries2.add(new Month(9,2013), 450);
				timeSeries2.add(new Month(10,2013), 500);
				timeSeries2.add(new Month(11,2013), 70);
				timeSeries2.add(new Month(12,2013), 800);
				
				TimeSeriesCollection line = new TimeSeriesCollection();
				line.addSeries(time);
				line.addSeries(timeSeries2);
				
				JFreeChart chart = ChartFactory.createTimeSeriesChart("访问量统计时间折线图", "月份", "访问量", line, true, true, true);
				
				TextTitle subtitle = new TextTitle("2013年度", new Font("黑体", Font.BOLD, 12));
				chart.addSubtitle(subtitle); 
				
				//设置时间轴的范围。
				XYPlot plot = (XYPlot) chart.getPlot(); 
				DateAxis dateaxis = (DateAxis)plot.getDomainAxis();
				dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M月"));
				dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH,1)); 
				
				//设置曲线显示各数据点的值
				XYItemRenderer xyitem = plot.getRenderer(); 
				xyitem.setBaseItemLabelsVisible(true);
				xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
				xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
				xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12)); 
				plot.setRenderer(xyitem);
				
				String chart31=ServletUtilities.saveChartAsPNG(chart, 700, 500, request.getSession());
				
				request.setAttribute("chart31", chart31);
				
				
				JFreeChart chart2 =getJFreeChart();
				String chart32=ServletUtilities.saveChartAsPNG(chart2, 700, 500, request.getSession());
				request.setAttribute("chart32", chart32);
				return "chart/chart3.jsp";
	}

	private JFreeChart getJFreeChart() {
	/*s*/
		CategoryDataset mDataset = GetDataset();
		
		 StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		    ChartFactory.setChartTheme(mChartTheme);		
		  
		    JFreeChart mChart = ChartFactory.createLineChart(
		        "折线图",//图名字
		        "年份",//横坐标
		        "数量",//纵坐标
		        mDataset,//数据集
		        PlotOrientation.VERTICAL,
		        true, // 显示图例
		        true, // 采用标准生成器 
		        false);// 是否生成超链接
		    
		    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
		    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		    mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
		    mPlot.setOutlinePaint(Color.BLACK);//边界线
		    
		   
		
		return mChart;
		
	}
	

public  CategoryDataset GetDataset()
{
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	
		
		///****
		 
		 
		List<Grade> grade = gradeService.selectAll1();
		
		List<Score> score = commonService.selectAllScore();
		
		List<Course> course = commonService.selectAllCourse();
		
		 double[][] data3 = new double[course.size()][grade.size()];
		 String[]  xKeys2= new String[grade.size()];
	     String[]  yKeys2= new String[course.size()];		
		////---------每个班级，每门课程的平均成绩
		int class_num = grade.size();
		int course_num = course.size();
		
		//每个班级
		for(int i =0 ; i<class_num;i++) {
			
			xKeys2[i] = grade.get(i).getGrade()+grade.get(i).getClass_name();
			//每门课程
			//
			List<Student> stu = grade.get(i).getStudents();
			for(int j = 0 ;j < course_num ; j++) {
				//课程ID
				int cid = course.get(j).getCid();
				yKeys2[j] = course.get(j).getCname();
				//该门课程所有成绩
				double sum = 0;
				int num = 0;
				//统计该班级的所有学生的分数
				for(int k = 0 ; k < stu.size() ; k++) {
					for( int m = 0 ; m < score.size() ; m++) {
						if( stu.get(k).getSid() == score.get(m).getSid() && cid == score.get(m).getCid()) {
							sum += score.get(m).getScore();
							num++;
						}
					}
				}
				
				if(sum == 0 ) {
					data3[j][i]=0.0;
				}else {
					data3[j][i]=sum/(num*1.0);
				}
				
				//
			}
		}
	
		
		for(int i = 0 ; i<xKeys2.length  ;i++) {
			
			String gname = xKeys2[i];
			
			for(int j = 0 ; j < yKeys2.length ; j++) {
				String cname = yKeys2[j];
				mDataset.addValue(data3[j][i], gname , cname);
				System.out.println(data3[j][i]+"--"+gname+"--"+cname);
			}
		}
		
		return mDataset;
}
}