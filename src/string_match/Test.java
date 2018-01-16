package string_match;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Test {
	
	/**
	 * ��BF��KMP����ͬ�����½��в��Բ�������Խ��
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException {
    	System.out.println("��ʼ��"+new Date());
    	GenerateRandomTestData.init();
    	Random r = new Random();
    	int i = 1;
    	int count_bf = 0, count_kmp = 0;
    	while (i <= 100) {						//�Ƚ�20��
    		System.out.println("��"+i+"�ֲ���");
			String target = new String().valueOf(Math.abs(r.nextInt()));
			System.out.println("target:" + target);
			long bf = test(target, "BF");
			long kmp = test(target, "KMP");
			if(kmp<bf){
				count_kmp++;
				System.out.println("KMP��");
			}else{
				count_bf++;
				System.out.println("BF��");	
			}
			i++;
			System.out.println();
		}
    	System.out.println("BF ��Ĵ���:"+count_bf);
    	System.out.println("kmp��Ĵ���:"+count_kmp);
    	System.out.println("������"+new Date());
	}
    /**
     * ��100�����ݽ��д�������ȽϵĽ��
     * @param target Ҫ���ҵ��ַ���
     * @param algosName �㷨����
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
	public static long test(String target,String algosName) throws FileNotFoundException, IOException {
		FileReader in = new FileReader("src/string_match/testData.txt");
    	BufferedReader br = new BufferedReader(in);
    	FileWriter out = new FileWriter("src/string_match/result"+algosName+".txt"); 
    	BufferedWriter bw = new BufferedWriter(out);
    	Date begin = new Date();				//��ʼִ��ʱ��
    	String source = "";
    	//int line = 0;
    	int result = 0;
    	while((source=br.readLine())!=null){
    		if(algosName.equals("BF"))
    			result = BF.indexOf(source, target);
    		else
    			result = KMP.indexOf(source, target);
    			
    		bw.write(result+"\n");
    	}
		Date end = new Date();					//ִ�н���ʱ��
		long t = end.getTime()-begin.getTime();
		System.out.println(algosName+"�㷨����1000000����������ʱ��"+t+"ms");
		br.close();
		bw.close();
		return t;
	}
}
