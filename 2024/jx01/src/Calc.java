public class Calc {
  public static void main(String[] args) {
    int[] arr = { 10, 12, 8, 16, 20, 6, 24, 32 };
    int max, min, ave = 0;
    max = min = arr[0];

    for (int num : arr) {
      ave += num;
      if (num > max)
        max = num;
      if (num < min)
        min = num;
    }
    ave /= arr.length;

    System.out.println("最大値: " + max);
    System.out.println("最小値: " + min);
    System.out.println("平均値: " + ave);
  }
}
