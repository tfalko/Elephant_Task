package pl.tfalkowski.Elephant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static final int INF = 1000000000;
    static final int MAXN = 1000000;

    static int[] weight = new int[MAXN];
    static int[] org = new int[MAXN];
    static int[] perm = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];

    static int minw = INF;

    public static void main(String[] args)
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        try
        {
            StringTokenizer input = new StringTokenizer(rd.readLine());
            N = Integer.parseInt(input.nextToken());
            input = new StringTokenizer(rd.readLine());
            for (int a = 0; a<N; ++a)
            {
                weight[a] = Integer.parseInt(input.nextToken());
                minw = Math.min(minw, weight[a]);
            }
            input = new StringTokenizer(rd.readLine());
            for (int a = 0; a<N; ++a)
                org[a] = Integer.parseInt(input.nextToken())-1;
            input = new StringTokenizer(rd.readLine());
            for (int a = 0; a<N; ++a)
                perm[Integer.parseInt(input.nextToken())-1] = org[a];
        }
        catch (IOException e) {}
        long result = 0;
        for (int start = 0; start<N; ++start)
            if (!vis[start])
            {
                int minc = INF;
                long sum = 0;
                int cur = start;
                int dl = 0;
                for (;;)
                {
                    minc = Math.min(minc, weight[cur]);
                    sum += weight[cur];
                    cur = perm[cur];
                    vis[cur] = true;
                    ++dl;
                    if (cur==start)
                        break;
                }
                result += Math.min(sum+(dl-2)*(long)minc, sum+minc+(dl+1)*(long)minw);
            }
        System.out.println(result);
    }
}
