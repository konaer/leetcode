package String;

public class P8_StringtoIntegerAtoi {
	//时间n，n是字符串长度
	//空间l
	public int myAtoi(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        
        //去空格
        int i = 0;
        while (i < len && arr[i] == ' ') {
        	i++;
        }
        if (i == len) {
        	return 0;
        }
        
        //记录正负
        int sign = 1;
        int signChar = arr[i];
        if (signChar == '+') {
        	i++;
        } else if (signChar == '-') {
        	sign = -1;
        	i++;
        }
        
        //转换后面的数字
        int ans = 0;
        while (i < len) {
        	char cur = arr[i];
        	if (cur > '9' || cur < '0') {
        		break;
        	}
        	
        	if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && cur - '0' > 7)) {
        		return Integer.MAX_VALUE;
        	}
        	//注意这个最后的判断条件，因为没带正负号，所以实际判断应该是 最后一个数，比8 大
        	if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && cur - '0' > 8)) {
        		return Integer.MIN_VALUE;
        	}
        	
        	ans = ans * 10 + sign * (cur - '0');
        	//别忘了这个i++
        	i++;
        }
        return ans;
    }
}
