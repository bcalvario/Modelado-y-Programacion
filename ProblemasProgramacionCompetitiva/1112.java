import java.util.Scanner;

// https://www.urionlinejudge.com.br/judge/en/problems/view/1112
// https://www.geeksforgeeks.org/two-dimensional-binary-indexed-tree-or-fenwick-tree/

public class Main{
    
    static class FenwickTree {

        int[][] campo;
        int X, Y;

        public FenwickTree(int X, int Y) {
            this.X = X;
            this.Y = Y;
            this.campo = new int[X][Y];
        }

        public int getSum(int i2, int j2) {
            int sum = 0;
            for (int i = i2; i >= 0; i = (i & (i + 1)) - 1)
                for (int j = j2; j >= 0; j = (j & (j + 1)) - 1)
                    sum += campo[i][j];
            return sum;
        }

        public int getSumCuadro(int x1, int y1, int x2, int y2) {
            int auxx1 = x1 > x2 ? x2: x1;
            int auxx2 = x1 < x2 ? x2: x1;
            int auxy1 = y1 > y2 ? y2: y1; 
            int auxy2 = y1 < y2 ? y2: y1;
            return getSum(auxx2, auxy2) - getSum(auxx1 - 1, auxy2) - getSum(auxx2, auxy1 - 1) + getSum(auxx1 - 1, auxy1 - 1);
        }

        public int getX() {
            return campo.length;
        }
        
        public int getY() {
            return campo[0].length;
        }
        
        public void setCampo(int x, int y, int plaga) {
            campo[x][y] += plaga;
        }
    }

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x, y, precio;
        x = entrada.nextInt();
        y = entrada.nextInt();
        precio = entrada.nextInt();

        while (x != 0 || y != 0 || precio != 0) {

            FenwickTree campo = new FenwickTree(x, y);
            
            int consultas;
            consultas = entrada.nextInt();
            
            
            for(int i = 0; i < consultas; i++) {
                String a_p;
                a_p = entrada.next();
                
                if (a_p.equals("A")) {
                    int plaga;
                    plaga = entrada.nextInt();
                    x = entrada.nextInt();
                    y = entrada.nextInt();
                    for (int a = x; a < campo.getX(); a |= a + 1)
                        for (int b = y; b < campo.getY(); b |= b + 1)
                            campo.setCampo(a, b, plaga);
                } else {
                    int x1, x2, y1, y2, sum;
                    x1 = entrada.nextInt();
                    y1 = entrada.nextInt();
                    x2 = entrada.nextInt();
                    y2 = entrada.nextInt();
                    sum = campo.getSumCuadro(x1, y1, x2, y2);
                    System.out.println(sum*precio);
                }
            }
            System.out.println();
            x = entrada.nextInt();
            y = entrada.nextInt();
            precio = entrada.nextInt();

        }
        entrada.close();
    }
}
