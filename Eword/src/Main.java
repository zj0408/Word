import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;

public class Main { 
	static Scanner in = new Scanner(System.in);
	static Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); 
    @SuppressWarnings("resource")
	public static void main(String[] args)throws IOException { 
    	
    	// ��ȡҪ������ļ�
    	System.out.println("�������ļ���:");
    	String src=in.next();
		BufferedReader a = new BufferedReader(new FileReader(src));
       //�����Ƶ
    	Map<String, Integer> map = new TreeMap<String, Integer>();
            String value= a.readLine();
            while (value!= null) {
            	String[] words = value.split("[^a-zA-Z]"); //���������
            	for (int i = 0; i < words.length; i++) {   		
                      String key = words[i].toLowerCase(); //��дת��Сд
                		if (key.length() > 0) {
                      		if (!map.containsKey(key)) {
                          		map.put(key, 1);
                          		} 
                      		else { 
                      			int k = map.get(key)+1;// ������ǵ�һ�γ��֣��Ͱ�kֵ++
                                map.put(key, k);
                          		}
                      		}
                  		} 
                value = a.readLine();
            }
            System.out.println("----------����----------");
            System.out.println("1:��ʾ��ѯ�ĵ��ʴ�Ƶ");
            System.out.println("2:�����Ƶ��ߵ�ǰN������");
            System.out.println("3:������ʼ���Ƶ��result.txt");
            System.out.println("0:�˳�");
            int w= in.nextInt();  
            while(w!=0){
                switch(w){
                    case 1:
                    	word(map);
            	        break;
                    case 2:
                    	print(map);
            	        break;
                    case 3:
                    	Write(map);
            	        break;
                }
                System.out.println("��ѡ��ִ�еĹ��ܣ�");
                w= in.nextInt();  
            }
        }    
    
        //��ʾ��Ƶ����״ͼ
    public static void word(Map<String, Integer> map){
        System.out.println("��������Ҫ��ѯ�ĵ��� :");
        in.nextLine();
            String string = in.nextLine();		
            String[] word= string.split("/");			
            float sum;
            for(int i=0; i<word.length; i++) {
            	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        			//int count=w.getValue();      			
            		if(word[i].equals(w.getKey()))
            		{  
            			System.out.println("����"+w.getKey() + "����" + w.getValue()+"��");
            			sum=(float)(w.getValue())/50; 
            			for(int j=0;j<sum;j++){
            				System.out.print("#");
            			}
            			System.out.println();
            		}  
                } 
            }
        }

      //���ǰn������
    public static void print(Map<String, Integer> map) {  
    	  Sort rs = new Sort();
    	  Map=rs.sort(map,2);
    	  System.out.println("������鿴�������еĵ��ʸ���n��");
          int n = in.nextInt();
          for(Entry<String,Integer> w : Map.entrySet()) {  
              System.out.println("����"+w.getKey() + "�����г���" + w.getValue()+"��");  
              n--;
              if(n<=0)	
              	break;
          } 
           
        }  
      
        //����д��result.txt
    public static void Write(Map<String, Integer> map)throws IOException {  
    	  Sort rs = new Sort();
    	  Map=rs.sort(map,3);
          File file = new File("result.txt");
          FileWriter f = new FileWriter(file.getAbsoluteFile());
          for(Entry<String,Integer> w: Map.entrySet()) {
        	  f.write(w.getKey() + "�����й�����:" + w.getValue()+"�� -------- ");
          }
          f.close();
          System.out.println("�������");
      }  
}

