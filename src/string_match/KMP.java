package string_match;

public class  KMP {
	/**
	 * KMP�㷨�ַ���ƥ��
	 * @param source  Դ�ַ���
	 * @param target  Ŀ���ַ���
	 * @return 
	 * @return
	 */
    public static int indexOf(String source, String target) {
    	int[] next = new int[target.length()];
    	next(target, next);						//�õ�next��ת����
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
	 * �����ת����next,��ƥ��ʧ�ܺ�targetҪ������λ��
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


