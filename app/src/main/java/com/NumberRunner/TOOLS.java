package com.NumberRunner;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class TOOLS {
	/**
	 * ��ȱ���
	 */
	public static double WIDTH_RATE;
	/**
	 * �߶ȱ���
	 */
	public static double HEIGHT_RATE;
	/**
	 * �ܶȱ���
	 */
	public static double DENSITY_RATE;
	/**
	 * ��ʼ�����ϵͳ��ǰ�ֻ��ĸ������
	 * @param context
	 */
	public static void init(Context context){
		DisplayMetrics metric = new DisplayMetrics();
		((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metric);
		int CURRENT_SCREEN_WIDTH = metric.widthPixels;  // ��Ļ��ȣ����أ�
		int CURRENT_SCREEN_HEIGHT = metric.heightPixels;  // ��Ļ�߶ȣ����أ�
		
		WIDTH_RATE=(CURRENT_SCREEN_WIDTH*1f)/720;//��ȱ���
		HEIGHT_RATE=(CURRENT_SCREEN_HEIGHT*1f)/1280;//�߶ȱ���
	}
	/**
	 * ��׼��Ļ�ܶȣ�0.75 / 1.0 / 1.5��
	 */
	public static double STANDARD_DENSITY=2d;
	/**
	 * ������֪��׼dip��õ�ǰӦ����ʾ�Ŀ��px��С
	 * @param standardDPValue
	 * @return
	 */
	public static int getCurrentPxForWidth(double standardDPValue){
		return (int)((standardDPValue * STANDARD_DENSITY + 0.5f)*WIDTH_RATE);
	}
	/**
	 * ������֪��׼dip��õ�ǰӦ����ʾ�ĸ߶�px��С
	 * @param standardDPValue
	 * @return
	 */
	public static int getCurrentPxForHeight(double standardDPValue){
		return (int)((standardDPValue * STANDARD_DENSITY + 0.5f)*HEIGHT_RATE);
	}
}
