
import java.io.IOException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class Q3 {

   
       public static void main(String args[]) throws IOException {
    
        int k,j,lo=0;
        Random rand = new Random();
        k=rand.nextInt(6)+1;
        int[] commit = new int[1000];
        Couple[] c = new Couple[500];
        Girl[] g = new Girl [1000];
        Boy[] b = new Boy [1000];
        MiserBoy[] m = new MiserBoy[1000];
        GenerousBoy[] gb = new GenerousBoy[1000];
        GeekBoy[] geek = new GeekBoy[1000];
        Gift gf1[] = new LuxuryGift[1000];
        Gift[] u = new UtilityGift [100];
        Gift[] e = new EssentialGift [100];
        test in = new test(g,b, (UtilityGift[]) u, (LuxuryGift[]) gf1, (EssentialGift[]) e,commit,c);
        
        lo=in.makelist(c, g, b, commit);

        in.sorth(c,lo);
        System.out.println(k+" "+" happiest :");
        for(int i=0;i<k;i++) {
            System.out.println(c[i].gname + " " +c[i].bname);
        }
        
        System.out.println("==========================");
        System.out.println(k+" "+" most compatible :");

        in.sortc(c,lo);
        
        for(int i=0;i<k;i++) {
            System.out.println(c[i].gname + " " +c[i].bname);
        }
        
        System.out.println("==========================");
        System.out.println("Couples with total cost of gifts exchanged : ");
        for(int i=0;i<lo;i++) {
            System.out.println(c[i].gname + " " +c[i].bname + " " + c[i].cost);
        }
        
        
    }
    
}
