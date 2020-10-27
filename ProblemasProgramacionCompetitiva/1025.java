import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// https://www.urionlinejudge.com.br/judge/en/problems/view/1025

public class Main{
    
    public static void main(String[] args) {
        ArrayList<Integer> marbles = new ArrayList<Integer>();
        ArrayList<Integer> queries = new ArrayList<Integer>();
        Scanner entrada = new Scanner(System.in);
        int n1, n2, cont = 1;
        n1 = entrada.nextInt();
        n2 = entrada.nextInt();

        while (n1 != 0 && n2 != 0) {
            System.out.println("CASE# " + cont + ":");
            
            for (int i = 0; i < n1 + n2; i++) {
                if (i < n1)
                    marbles.add(entrada.nextInt());
                if (i >= n1)
                    queries.add(entrada.nextInt());
                }
        
            Collections.sort(marbles);

            for (Integer query : queries)
                if (!marbles.contains(query))
                    System.out.println(query + " not found");
                else
                    System.out.println(query + " found at " + (marbles.indexOf(query) + 1));
            
            marbles.clear();
            queries.clear();
            
            n1 = entrada.nextInt();
            n2 = entrada.nextInt();
            
            cont++;
        }
        entrada.close();
    }
}