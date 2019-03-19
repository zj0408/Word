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
    	
    	// 读取要处理的文件
    	System.out.println("请输入文件名:");
    	String src=in.next();
		BufferedReader a = new BufferedReader(new FileReader(src));
       //计算词频
    	Map<String, Integer> map = new TreeMap<String, Integer>();
            String value= a.readLine();
            while (value!= null) {
            	String[] words = value.split("[^a-zA-Z]"); //处理标点符号
            	for (int i = 0; i < words.length; i++) {   		
                      String key = words[i].toLowerCase(); //大写转换小写
                		if (key.length() > 0) {
                      		if (!map.containsKey(key)) {
                          		map.put(key, 1);
                          		} 
                      		else { 
                      			int k = map.get(key)+1;// 如果不是第一次出现，就把k值++
                                map.put(key, k);
                          		}
                      		}
                  		} 
                value = a.readLine();
            }
            System.out.println("----------功能----------");
            System.out.println("1:显示查询的单词词频");
            System.out.println("2:输出词频最高的前N个单词");
            System.out.println("3:输出单词及词频到result.txt");
            System.out.println("0:退出");
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
                System.out.println("请选择执行的功能：");
                w= in.nextInt();  
            }
        }    
    
        //显示词频和柱状图
    public static void word(Map<String, Integer> map){
        System.out.println("请输入需要查询的单词 :");
        in.nextLine();
            String string = in.nextLine();		
            String[] word= string.split("/");			
            float sum;
            for(int i=0; i<word.length; i++) {
            	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        			//int count=w.getValue();      			
            		if(word[i].equals(w.getKey()))
            		{  
            			System.out.println("单词"+w.getKey() + "出现" + w.getValue()+"次");
            			sum=(float)(w.getValue())/50; 
            			for(int j=0;j<sum;j++){
            				System.out.print("#");
            			}
            			System.out.println();
            		}  
                } 
            }
        }

      //输出前n个单词
    public static void print(Map<String, Integer> map) {  
    	  Sort rs = new Sort();
    	  Map=rs.sort(map,2);
    	  System.out.println("请输入查看降序排列的单词个数n：");
          int n = in.nextInt();
          for(Entry<String,Integer> w : Map.entrySet()) {  
              System.out.println("单词"+w.getKey() + "在文中出现" + w.getValue()+"次");  
              n--;
              if(n<=0)	
              	break;
          } 
           
        }  
      
        //排序写入result.txt
    public static void Write(Map<String, Integer> map)throws IOException {  
    	  Sort rs = new Sort();
    	  Map=rs.sort(map,3);
          File file = new File("result.txt");
          FileWriter f = new FileWriter(file.getAbsoluteFile());
          for(Entry<String,Integer> w: Map.entrySet()) {
        	  f.write(w.getKey() + "在文中共出现:" + w.getValue()+"次 -------- ");
          }
          f.close();
          System.out.println("已输出！");
      }  
}

