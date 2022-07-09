import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int x, y, n;
        String[] xyn = sc.nextLine().trim().split(" ");
        n = Integer.parseInt(xyn[0]);
        x = Integer.parseInt(xyn[1]);
        y = Integer.parseInt(xyn[2]);
        int[] am = new int[n];
        String[] ams = sc.nextLine().trim().split(" ");
        for (i = 0; i < n; i++) {
            am[i] = Integer.parseInt(ams[i]);
            System.out.println(am[i]);
        }
        Arrays.sort(am);
        sc.close();
        return;
    }
}