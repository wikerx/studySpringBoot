package com.scott.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 作者： 薛俊鹏
 * 时间： 2018年8月14日上午11:21:45
 * 内容： 生成随机的订单号
 * 状态： 编写
 */
public class GetOrderNo {
	
	/*根据时间生成一个随机数*/
	public static synchronized String ReturnOrderNo(){
		//格式化当前时间
				SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String strDate = sfDate.format(new Date());
				//得到17位时间如：20170411094039080
				//为了防止高并发重复,再获取3个随机数
				String random = getRandom620(3);
				String BillNo = strDate + random;
				//最后得到20位订单编号。
				return BillNo;
	}
	
	/**
	 * 获取6-10 的随机位数数字
	 * @param length	想要生成的长度
	 * @return result
	 */
	private static String getRandom620(Integer length) {
		String result = "";
		Random rand = new Random();
		int n = 20;
		if (null != length && length > 0) {
			n = length;
		}
		int randInt = 0;
		for (int i = 0; i < n; i++) {
			randInt = rand.nextInt(10);
			result += randInt;
		}
		return result;
	}
	
	/*用于分布式最好*/
	 public static String getOrderIdByUUId() {
         int machineId = 1;//最大支持1-9个集群机器部署
         int hashCodeV = UUID.randomUUID().toString().hashCode();
         if(hashCodeV < 0) {//有可能是负数
             hashCodeV = - hashCodeV;
         }
         // 0 代表前面补充0     
         // 4 代表长度为4     
         // d 代表参数为正数型
         return machineId + String.format("%015d", hashCodeV);
     }
}
