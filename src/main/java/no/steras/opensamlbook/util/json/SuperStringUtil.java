package no.steras.opensamlbook.util.json;

import java.util.StringTokenizer;

/**
 * 
 * Des:字符串处理<br>
 * Logic:<br>
 * personHealth com.bdcc.hoffice.personhealth.web.util Wuhao created the Class
 * at 2010-8-17
 * 
 */
public final class SuperStringUtil {

	/**
	 * 
	 * Des:验证字符串是否是大小写字母<br>
	 * Logic:<br>
	 * 
	 * @param string
	 * @return <br>
	 *         Wuhao crated the method at 2010-8-17
	 */
	public static boolean isLetter(String string) {
		return string.matches("^[A-Za-z]+$");
	}

	/**
	 * 
	 * Des:验证字符串是否是中文<br>
	 * Logic:<br>
	 * 
	 * @param string
	 * @return <br>
	 *         Wuhao crated the method at 2010-8-17
	 */
	public static boolean isChinese(String string) {
		return string.matches("^[\\u4e00-\\u9fa5]+$");
	}

	/**
	 * 
	 * Des:验证字符串是否是数字<br>
	 * Logic:<br>
	 * 
	 * @param string
	 * @return <br>
	 *         Wuhao crated the method at 2010-8-17
	 */
	public static boolean isNumber(String string) {
		return string.matches("^[0-9]*$");
	}
	   /** 
     * 使用StringTokenizer类将字符串按分隔符转换成字符数组 
     * @param string 字符串  
     * @param divisionChar 分隔符 
     * @return 字符串数组 
     * @see [类、类#方法、类#成员] 
     */  
    public static String[] stringAnalytical(String string, String divisionChar)  
    {  
        int i = 0;  
        StringTokenizer tokenizer = new StringTokenizer(string, divisionChar);  
          
        String[] str = new String[tokenizer.countTokens()];  
          
        while (tokenizer.hasMoreTokens())  
        {  
            str[i] = new String();  
            str[i] = tokenizer.nextToken();  
            i++;  
        }  
          
        return str;  
    }
	// 附 ： 常用的正则表达式：
	//
	// 匹配特定数字：
	// ^[1-9]d*$ //匹配正整数
	// ^-[1-9]d*$ //匹配负整数
	// ^-?[1-9]d*$ //匹配整数
	// ^[1-9]d*|0$ //匹配非负整数（正整数 + 0）
	// ^-[1-9]d*|0$ //匹配非正整数（负整数 + 0）
	// ^[1-9]d*.d*|0.d*[1-9]d*$ //匹配正浮点数
	// ^-([1-9]d*.d*|0.d*[1-9]d*)$ //匹配负浮点数
	// ^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$ //匹配浮点数
	// ^[1-9]d*.d*|0.d*[1-9]d*|0?.0+|0$ //匹配非负浮点数（正浮点数 + 0）
	// ^(-([1-9]d*.d*|0.d*[1-9]d*))|0?.0+|0$ //匹配非正浮点数（负浮点数 + 0）
	// 评注：处理大量数据时有用，具体应用时注意修正
	//
	// 匹配特定字符串：
	// ^[A-Za-z]+$ //匹配由26个英文字母组成的字符串
	// ^[A-Z]+$ //匹配由26个英文字母的大写组成的字符串
	// ^[a-z]+$ //匹配由26个英文字母的小写组成的字符串
	// ^[A-Za-z0-9]+$ //匹配由数字和26个英文字母组成的字符串
	// ^w+$ //匹配由数字、26个英文字母或者下划线组成的字符串
	//
	// 在使用RegularExpressionValidator验证控件时的验证功能及其验证表达式介绍如下:
	//
	// 只能输入数字：“^[0-9]*$”
	// 只能输入n位的数字：“^d{n}$”
	// 只能输入至少n位数字：“^d{n,}$”
	// 只能输入m-n位的数字：“^d{m,n}$”
	// 只能输入零和非零开头的数字：“^(0|[1-9][0-9]*)$”
	// 只能输入有两位小数的正实数：“^[0-9]+(.[0-9]{2})?$”
	// 只能输入有1-3位小数的正实数：“^[0-9]+(.[0-9]{1,3})?$”
	// 只能输入非零的正整数：“^+?[1-9][0-9]*$”
	// 只能输入非零的负整数：“^-[1-9][0-9]*$”
	// 只能输入长度为3的字符：“^.{3}$”
	// 只能输入由26个英文字母组成的字符串：“^[A-Za-z]+$”
	// 只能输入由26个大写英文字母组成的字符串：“^[A-Z]+$”
	// 只能输入由26个小写英文字母组成的字符串：“^[a-z]+$”
	// 只能输入由数字和26个英文字母组成的字符串：“^[A-Za-z0-9]+$”
	// 只能输入由数字、26个英文字母或者下划线组成的字符串：“^w+$”
	// 验证用户密码:“^[a-zA-Z]w{5,17}$”正确格式为：以字母开头，长度在6-18之间，
	//
	// 只能包含字符、数字和下划线。
	// 验证是否含有^%&’,;=?$”等字符：“[^%&’,;=?$x22]+”
	// 只能输入汉字：“^[u4e00-u9fa5],{0,}$”
	// 验证Email地址：“^w+[-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$”
	// 验证InternetURL：“^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$”
	// 验证电话号码：“^((d{3,4})|d{3,4}-)?d{7,8}$”
	//
	// 正确格式为：“XXXX-XXXXXXX”，“XXXX-XXXXXXXX”，“XXX-XXXXXXX”，
	//
	// “XXX-XXXXXXXX”，“XXXXXXX”，“XXXXXXXX”。
	// 验证身份证号（15位或18位数字）：“^d{15}|d{}18$”
	// 验证一年的12个月：“^(0?[1-9]|1[0-2])$”正确格式为：“01”-“09”和“1”“12”
	// 验证一个月的31天：“^((0?[1-9])|((1|2)[0-9])|30|31)$”
	//
	// 正确格式为：“01”“09”和“1”“31”。
	// ^[\\u4e00-\\u9fa5]+$
	// 匹配中文字符的正则表达式：^[\\u4e00-\\u9fa5]+$
	// 匹配双字节字符(包括汉字在内)：[^x00-xff]
	// 匹配空行的正则表达式：n[s| ]*r
	// 匹配HTML标记的正则表达式：/< (.*)>.*|< (.*) />/
	// 匹配首尾空格的正则表达式：(^s*)|(s*$)
	// 匹配Email地址的正则表达式：w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*
	// 匹配网址URL的正则表达式：http://([w-]+.)+[w-]+(/[w- ./?%&=]*)?

}
