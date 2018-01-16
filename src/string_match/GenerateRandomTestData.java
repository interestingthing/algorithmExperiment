package string_match;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomTestData {
	/**
	 * ����һ���������������в���,ÿ��һ��
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	public static void init() throws IOException {
		File out = new File("src/string_match/testData.txt");
		if(!out.exists()){
			out.createNewFile();
		}
		Random r = new Random();
		FileOutputStream os = new FileOutputStream(out);
		for (int i = 1; i < 1000001; i++) {
			if(i%100000==0)
				System.out.println("�ѳ�ʼ��"+i+"������");
			String s = "";
			for (int j = 0; j < 300; j++) {
				s+=Math.abs(r.nextInt());
			}
			s+="\n";
			os.write(s.getBytes());
		}
		os.close();
		System.out.println("��ʼ�����");
		
	}
}
