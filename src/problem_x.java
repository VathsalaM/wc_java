import java.util.Arrays;


class Problem_5{

	public static int sum(int[] num){
		return num[0]+num[1]+num[2];
	}

	public static void main(String[] args) {
		for (int i=0;i<args.length ;i++ ) {
			if(sum((int[])args[i].split(","))==1000)
				System.out.println(" number is :"+args[i]);
		}
	}
}