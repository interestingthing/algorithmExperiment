package string_match;

public class  BF {
		/**
	 * ��ٷ��ַ���ƥ��
	 * @param source  Դ�ַ���
	 * @param target  Ŀ���ַ���
	 * @return ����Ŀ���ַ�����Դ�ַ����Ŀ�ʼ��λ��
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

