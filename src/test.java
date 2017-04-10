
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class test {
 int gs,bs,es,us,ls;
    
    
    public test(Girl g[],Boy b[],UtilityGift u[],LuxuryGift l[], EssentialGift e[],int commit[], Couple c[]) throws IOException{
        FileInputStream girl = new FileInputStream("girl.txt");
        FileInputStream boy = new FileInputStream("boy.txt");
        FileInputStream utility_gift = new FileInputStream("utility.txt");
        FileInputStream luxury_gift = new FileInputStream("luxury.txt");
        FileInputStream essential_gift = new FileInputStream("essential.txt");
        Scanner s =new Scanner(girl);
        Scanner s2 =new Scanner(boy);
        Scanner s3 = new Scanner(essential_gift);
        Scanner s4 = new Scanner(utility_gift);
        Scanner s5 = new Scanner(luxury_gift);
        File file = new File("log.txt");
     try (FileWriter qwe = new FileWriter(file,true)) {
         gs=Integer.parseInt(s.next());
         bs=Integer.parseInt(s2.next());
         es=Integer.parseInt(s3.next());
         us=Integer.parseInt(s4.next());
         ls=Integer.parseInt(s5.next());
         
         for(int i=0;i<gs;i++) {
             g[i]=new Girl();
             g[i].name=s.next();
             g[i].attractive=s.nextInt();
             g[i].maintainance_cost=s.nextInt();
             g[i].intellect=s.nextInt();
             g[i].criteria=s.nextInt();
             g[i].type=s.nextInt();
         }
         
         for(int i=0;i<bs;i++) {
             b[i]=new Boy();
             b[i].name=s2.next();
             b[i].attractive=s2.nextInt();
             b[i].intellect=s2.nextInt();
             b[i].budget=s2.nextInt();
             b[i].min_attraction=s2.nextInt();
             b[i].criteria=s2.nextInt();
         }
         
         
         for(int i=0;i<es;i++) {
             e[i] = new EssentialGift();
             e[i].value=s3.nextInt();
             e[i].price=s3.nextInt();
         }
         
         for(int i=0;i<us;i++) {
             u[i] = new UtilityGift();
             u[i].utility_value=s4.nextInt();
             u[i].utility_class=s4.nextInt();
             u[i].value=s4.nextInt();
             u[i].price=s4.nextInt();
         }
         
         
         for(int i=0;i<ls;i++) {
             l[i] = new LuxuryGift();
             l[i].rating=s5.nextInt();
             l[i].difficulty=s5.nextInt();
             l[i].value=s5.nextInt();
             l[i].price=s5.nextInt();
         }
         
         for(int i=0;i<gs;i++) {
             int x=g[i].matchMaker(b, bs);
             commit[i]=x;
             
         }
         
         
         for(int i=0;i< bs;i++) {
             b[i].gifting(g, l, e, ls, es, gs);
         }
         
         for(int i=0;i<500;i++) {
             c[i] = new Couple();
         }
         Date date = new Date();
         for(int j=0;j<gs;j++) {
             
             if(g[j].status == 2){
                 qwe.write(date.toString()+ " " + "Committed " + "  " + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
                 qwe.write(System.getProperty("line.separator"));
                 
             }
             else{
                 qwe.write(date.toString()+ " " + "Not Committed " + "  " + g[j].name + "  " + g[j].partner +"  " + g[j].cost + '\n');
                 qwe.write(System.getProperty("line.separator"));
             }
             
             
         }
         qwe.flush();
     }
        
            
        
    
    }
  
    public void sorth(Couple c[], int n){
        Couple temp;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(c[i].happy<c[j].happy){
                    temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
    }
    
    public void sortc(Couple c[], int n){
        Couple temp;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(c[i].compatible<c[j].compatible){
                    temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
    }
    
   
    public int makelist(Couple c[],Girl g[],Boy b[],int commit[]){
        int j,lo=0;
        for(j=0;j<gs;j++) {
            int flag=c[lo].find_happy(gs, bs, g[j], b, commit, j);
            if(flag==1)
                lo++;
            
        }
        return lo;
    }
        
}   
    
    


   

