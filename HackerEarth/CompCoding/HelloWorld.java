import java.util.Scanner;

public class HelloWorld {
int arr[]=new int[999];
static void swap(int arr[],int i,int j)
{
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}
public static void main(String[] args) {
int arr[]=new int[999];
for (int i = 0; i < arr.length; i++) {
	arr[i]=arr.length-i;
}
for (int i = 0; i < arr.length; i++) {
	for (int j = 0; j < arr.length-1; j++) {
		if(arr[j]>arr[j+1])
		{
			swap(arr,j,j+1);
		}
	}
}
for (int i = 0; i < arr.length; i++) {
	System.out.println(arr[i]+" ");
}
}
}
