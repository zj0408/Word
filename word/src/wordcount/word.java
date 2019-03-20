package wordcount;


import java.util.*; 
import java.util.Map.Entry;
import java.io.*;
//import java.security.KeyStore.Entry; 
public class word {
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		

		BufferedReader infile = new BufferedReader(new FileReader("file.txt"));
		String string;
		String file = null;
		while ((string = infile.readLine()) != null) {
			file += string;
		}

		file = file.toLowerCase();// ������ĸСд��
		file = file.replaceAll("[^A-Za-z]", " ");// ����ƥ���Ӣ���ַ�Ϊ�ո�
		file = file.replaceAll("\\s+", " "); // ���򣬽�1������ո�ƥ��Ϊһ���ո�

		String words[];
		words = file.split("\\s+");// ȡ�����ʣ��������ʴ���������

		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			String key = words[i];
			if (hashMap.get(key) != null) { 
				int value = ((Integer) hashMap.get(key)).intValue();
				value++;
				hashMap.put(key, new Integer(value));
			} else {
				hashMap.put(key, new Integer(1));
			}
		}
		while(true)
		{
			System.out.println("***************************************************");
			System.out.println(" 		A:        ָ�����ʴ�Ƶͳ��					   ");
			System.out.println(" 		B:  ͳ�������ı��������Ƶ�����result.txt		   ");
			System.out.println(" 		C:          ��Ƶ��ͳ��					       ");
			System.out.println(" 		D:          �˳�ϵͳ					       ");
			System.out.println("***************************************************");
			
			System.out.println("Please input code: ");
			String code = in.next();
			if(code.equals("A"))
			{
				String word[]= new String[100];
				int n;
				System.out.println("word number:");
				 n=in.nextInt();
				for(int i=0;i<n;i++)
				{
					System.out.println("input word "+(i+1));
					word[i]=in.next();
					
				}
				
				for(Map.Entry<String, Integer> arg : hashMap.entrySet())
				{
					for(int i=0;i<n;i++)
					{
						if(word[i].equals(arg.getKey()))
						{
							System.out.println("���ʣ�"+arg.getKey()+"���ִ�����"+arg.getValue());
							break;
						}
					}
					
				}

			}
			
			if(code.equals("B"))
			{
				Map<String, Object> treeMap = new TreeMap<String, Object>(hashMap);
				Set entrySet = treeMap.entrySet();

				
				BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));  //ʵ����һ��writer����
				for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) { // ѭ������
					//ע��:����һ�в���д��String result =String result =(String)iterator.next();
					String result =iterator.next().toString();
					bw.write(result); // ����writer��write�������õ���resultд���ļ�
					bw.newLine(); // ����һ��
					bw.flush();  // ��ջ���
				}
				System.out.println("success!");	
			}
			
			//Map<String, Integer> hashMap = new HashMap<String, Integer>();
			// Map<String,String> hashMap = new HashMap<String ,String>();

			if(code.equals("C"))
			{
				sortMapByValues(hashMap);
			}
			
			if(code.equals("D"))
				System.exit(0);
		}	
	}
	private static void sortMapByValues(Map<String, Integer>hashMap)
	{ 
		Scanner in = new Scanner(System.in);
		int n,count=0;
		System.out.println("��Ƶ�ʸ�����");
		n=in.nextInt();
		 Set<java.util.Map.Entry<String, Integer>> mapEntries = hashMap.entrySet();  
		 List<Entry<String,Integer>> aList = new LinkedList<Entry<String,Integer>>(mapEntries); 

		 Collections.sort(aList, new Comparator<Entry<String,Integer>>() { 

		 public int compare(Entry<String, Integer> ele1, 
		 Entry<String, Integer> ele2) { 

		 return ele2.getValue().compareTo(ele1.getValue()); 
		 } 
		 });  
		 Map<String,Integer> aMap2 = new LinkedHashMap<String, Integer>(); 
		 for(Entry<String,Integer> entry: aList) { 
		 aMap2.put(entry.getKey(), entry.getValue()); 
		 } 
		 System.out.println("��Ƶ���Լ�����ִ�����"); 
		 for(Entry<String,Integer> entry : aMap2.entrySet()) 
		 { 
			 System.out.println("���ʣ� " +entry.getKey() + "      ����   ��" + entry.getValue()); 
			 count=count+1;
			 if(count==n)
				 break;
		 } 
	} 
}

