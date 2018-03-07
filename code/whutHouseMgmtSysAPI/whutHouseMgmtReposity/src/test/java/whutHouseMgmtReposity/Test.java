package whutHouseMgmtReposity;

import java.util.Date;

import com.computerdesign.whutHouseMgmt.utils.DateUtil;

/**
 *
 * @author wanhaoran
 * @date 2018年3月5日 下午3:11:56
 * 
 */
public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		String s1 =DateUtil.formatDate(date);
		System.out.println(s1);
		
		Date date2 = DateUtil.parseDate(s1);
		System.out.println(date2);
	}
}
