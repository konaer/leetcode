import java.util.List;
import java.util.*;

public class commonAPI {
	
	public static void main(String[] args) {
		
		//String to Integer
//		String s = "123";
//		Integer a = Integer.parseInt(s);
		
		//Integer to String
//		String s = String.valueOf(a);
		
		//String to Char Array
//		char[] array = s.toCharArray();
		
		//char Array to String
//		String s = new String(array);
		
		//Array to String
//		String s = Arrays.toString(a);
		//二维数组
//		String s = Arrays.deepToString(a);
		
		//List to Array
//		List<Integer> list = new ArrayList<>();
//		Integer[] array = list.toArray(new Integer[list.size()]);
		
		//Array to List
		Integer[] a = {1, 2, 3};
//		List<Integer> list = new ArrayList<>();
//		Collections.addAll(list, a);
		//or
//		List<Integer> list = Arrays.asList(a);
		//or
//		List<Integer> list = List.of(a);
		
		//Array sort
//		int[] s = {1,2,3};
//		Arrays.sort(s);
		
		//arraylist后面括号里，必须是一个list才行,完事还可以list里加新元素，不受影响
//		List<Integer> list2 = new ArrayList<>(List.of(a));
//		list2.add(4);
		
		//取绝对值
//		Math.abs(-1);
		
		
		//List to Set
//		Set<String> set = new HashSet<>(list);

//		//Set to List
//		List<String> list = new Arraylist<>(set);
		
//		//Set to Array
//		String[] array = set.toArray(new String[set.size()]);
	
//		//清除list所有内容
//		list.clear();
	
//		//subString
//		String subString = s.substring(start, end);
		
		//有序hash set
//		Set<String> set = new LinkedHashSet<>();
		
		//填充数组
		Arrays.fill(array, 1);
		
		//伪随机数
		//反馈0~1之间随机数
		Math.random();
		//返回[min, max)随机数
		Math.random() * (max - min + 1) + min; 
		//或者
		Random s = new Random();
		s.nextInt();
		s.nextInt(10) //生成0~10的随机数
		
		
		map.keySet() //返回所有key
		map.values() //返回所有values
		
		//set中维护插入顺序
		Set<Integer> set = LinkedHashSet<>() 
		//set中维护排序顺序
		Set<Integer> set = TreeSet<>() 
		
		//char to int
		//直接转化，返回ascii码
		char c = 't';
		int a = c;
		//如想转化成数字
		char c = '9';
		int a = Character.getNumericValue(c);
		
		//int to char
		char c = '9';
		int a = c - '0';
		
		//Deque 和 stack 的区别，遍历时候一个正向，一个反向
		
		//Integer list 变成 int array
		List<Integer> list = new ArrayList();
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		
		//翻转数组
		String[] arr = {"1","2","3"};
		List<String> list = Arrays.asList(arr);
		Collections.reverse(list);
		
		//求list的和
		stack.stream().mapToInt(i ->i).sum();
		
		//清空stringbuilder
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		
		
		//substring, 不算越界，但是打不出来的情况
		String s = "abc";
    	String sb = s.substring(3,3);
    	
    	//string中删除某个
    	String s = "123";
    	StringBuilder sb = new StringBuilder();
    	sb.deleteCharAt(i);
    	
    	//String合并拆分
    	String s = "1243";
    	s.split(",");
    	
    	String.join(",", args)
		
	}
}
