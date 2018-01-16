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
	 * 对BF和KMP在相同环境下进行测试并输出测试结果
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException {
    	System.out.println("开始："+new Date());
    	GenerateRandomTestData.init();
    	Random r = new Random();
    	int i = 1;
    	int count_bf = 0, count_kmp = 0;
    	while (i <= 100) {						//比较20次
    		System.out.println("第"+i+"轮测试");
			String target = new String().valueOf(Math.abs(r.nextInt()));
			System.out.println("target:" + target);
			long bf = test(target, "BF");
			long kmp = test(target, "KMP");
			if(kmp<bf){
				count_kmp++;
				System.out.println("KMP快");
			}else{
				count_bf++;
				System.out.println("BF快");	
			}
			i++;
			System.out.println();
		}
    	System.out.println("BF 快的次数:"+count_bf);
    	System.out.println("kmp快的次数:"+count_kmp);
    	System.out.println("结束："+new Date());
	}
    /**
     * 对100万数据进行处理，输出比较的结果
     * @param target 要查找的字符串
     * @param algosName 算法名称
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
    	Date begin = new Date();				//开始执行时间
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
		Date end = new Date();					//执行结束时间
		long t = end.getTime()-begin.getTime();
		System.out.println(algosName+"算法处理1000000个样例总用时："+t+"ms");
		br.close();
		bw.close();
		return t;
	}
}
