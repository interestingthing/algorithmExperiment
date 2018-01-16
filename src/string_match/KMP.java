package string_match;

public class  KMP {
	/**
	 * KMP算法字符串匹配
	 * @param source  源字符串
	 * @param target  目标字符串
	 * @return 
	 * @return
	 */
    public static int indexOf(String source, String target) {
    	int[] next = new int[target.length()];
    	next(target, next);						//得到next跳转数组
        if (source == null && target == null) return 0;
        if (source == null) return -1;
        if (target == null) return 0;
        int j = 0;
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (; j < target.length(); j++) {
                if (source.charAt(i+j) != target.charAt(j)) 
                	break;
            }
            if (j == target.length()) 
            	return i;
            j=next[j]+1;
        }
        return -1;
    }
    
    /**
	 * 获得跳转数组next,即匹配失败后target要回跳的位置
	 * @param target
	 * @param next
	 */
	private static void next(String target,int next[]){
		int i = 0;
		int j = -1;
		next[0] = -1;
		while(i<target.length()){
			while(j == -1||i<target.length()&&target.charAt(i)==target.charAt(j)){
				i++;
				j++;
				if(i<target.length())
					next[i] = j;
			}
			if(j!=-1)
			j=next[j];
		}	
	}	
    
}


