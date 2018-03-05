package whutHouseMgmtReposity;

import java.util.Date;

/**
 *
 * @author wanhaoran
 * @date 2018年3月5日 下午3:11:56
 * 
 */
public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		String hour = date.getHours()+"";
		String minute = date.getMinutes()+"";
		System.out.println(hour+minute);
	}
}
