package string_match;

public class  BF {
		/**
	 * 穷举法字符串匹配
	 * @param source  源字符串
	 * @param target  目标字符串
	 * @return 返回目标字符串的源字符串的开始的位置
	 */
	public static int indexOf(String source, String target) {
        if (source == null && target == null) return 0;
        if (source == null) return -1;
        if (target == null) return 0;
                int j;
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i+j) != target.charAt(j)) 
                	break;
            }
            if (j == target.length()) 
            	return i;
        }
        return -1;
    }
}

