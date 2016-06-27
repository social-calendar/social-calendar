package com.socialCalendar.WeChat.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	
	public static Timestamp strToTimestamp(String strDate) throws ParseException{	
					Date a = sdfTimes.parse(strDate);
					String str = sdfTime.format(a);
					return Timestamp.valueOf(str);	
	}
	
	public static String timestampToStr(Timestamp timestamp){		
		return sdfTimes.format(timestamp);
	}
/*	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtil.timestampToStr(new Timestamp(new Date().getTime())));
		System.out.println(DateUtil.strToTimestamp("2016-06-27 10:53"));
		
	}*/
}
