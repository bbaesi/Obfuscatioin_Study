package layout_ob;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RenameIdentfiers {

	public static void main(String[] args) {
		
		//파일 불러오기
		File in = new File("//Users/sihyeonbae/eclipse-workspace/obfuscation_test/src/layout_ob/Test.java");
		File out = new File("//Users/sihyeonbae/eclipse-workspace/obfuscation_test/src/layout_ob/Out.java");
		Test testClass = new Test();
				
		String className = testClass.getClass().getSimpleName(); //클래스 확인 변
        Field[] fields = testClass.getClass().getFields(); // 필드 확인 변수 
        String[] strFiledls = new String[fields.length];
        Method[] Methods = testClass.getClass().getDeclaredMethods();	// 메소드 확인 변수
        String[] strMethods = new String[Methods.length];;
		
	    String line; 
	    String[] variable = new String [6]; //변수 확인
	    String obfus[] = {"aaaaa", "bbbbb", "ccccc", "ddddd","eeeee", "ffffff"}; // 난독화
	    
	    int count = 0;
        
        for(int i = 0; i<fields.length; i++) {
        	strFiledls[i] = fields[i].getName().toString();;
        }

        for(int i = 0; i<Methods.length; i++) {
        	strMethods[i] = Methods[i].getName().toString();;
        }
        
		try{
			BufferedReader br = new BufferedReader(new FileReader(in));
			BufferedWriter bw = new BufferedWriter (new FileWriter(out));
		    while ((line = br.readLine()) != null) {
		    	if(line.contains(className)) { //클래스 난독
		            line = line.replaceAll(className, "iiiiiii");
		    	}
		        for(int i = 0; i<strFiledls.length; i++) { //필드 난독화
			    	if(line.contains(strFiledls[i])) {
			            line = line.replaceAll(strFiledls[i], "IIIIIII");
			    	}
		        }
		        for(int i = 0; i<strMethods.length; i++) { // 메소드 난독화
			    	if(line.contains(strMethods[i])) {
			            line = line.replaceAll(strMethods[i], "IiIiIiI");
			    	}
		        }
		        if(line.contains("int ")) { // 변수 난독화
		        	int start = line.indexOf("int")+4;
		        	String text = line.substring(start);
		        	int end = text.indexOf(" ");
		        	int ln = text.indexOf(";");
		        	if(end!=-1) {
		        		text = text.substring(0, end);
		        	}else text = text.substring(0, ln);
		        	variable[count] = text;
		        	count++;
		        }
		        for(int i = 0; i<variable.length; i++) {
			    	if(variable[i]!=null) {
				    	if(line.contains(variable[i])) {
				            line = line.replaceAll(variable[i], obfus[i]);
				    	}
			    	}
		        }
		    	bw.write(line);
		    	bw.newLine();
	            System.out.println(line);
		    }
		    bw.close();
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}
}


