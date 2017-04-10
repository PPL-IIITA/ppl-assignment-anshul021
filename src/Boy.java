/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class Boy {
    String name;
    int attractive;
    int budget;
    int intellect;
    int min_attraction;
    int criteria; 
    int status; 
    int partner;
    int happiness;
    double c;
    
    public Boy() {
        attractive=0;
        budget=0;
        intellect=0;
        min_attraction=0;
        status= 1;
        partner = -1;
        c=0;
    }
    
   
    public void gifting(Girl g[] ,LuxuryGift l[], EssentialGift e[],int l1, int e1,int n) {
        int j,k;
        if(status==2){
            j = 0;
            k=0;
            for(int i=0;i<n;i++) {
                if(g[i].partner == null ? name == null : g[i].partner.equals(name)) {
                    partner = i;
                }
            }
            int balance;
            switch (criteria) {
                case 1:
                    j=0;
                    k=0;
                    balance = g[partner].maintainance_cost;
                    while(balance>0 && j<e1){
                        g[partner].cost+=e[j].price;
                        g[partner].value+=e[j].value;
                        balance = balance-e[j].price;
                        
                        j++;
                        if(j==e1 && g[partner].cost < g[partner].maintainance_cost) {
                            g[partner].cost+=l[k].price;
                            g[partner].value+=2*l[k].value;
                            balance = balance-l[k].price;
                            k++;
                        }
                    }   happiness=balance;
                    break;
                case 2:
                    j=l1-1;
                    k=e1-1;
                    balance = budget;
                    while(balance>=0 && j>=0){
                        if(balance - l[j].price > 0 ) {
                            g[partner].cost+=l[j].price;
                            g[partner].value+=2*l[j].value;
                            balance = balance-l[j].price;
                            j--;
                        }
                        if(j==-1 && balance - e[k].price > 0) {
                            g[partner].cost+=e[k].price;
                            g[partner].value+=e[k].value;
                            balance = balance-e[k].price;
                            k--;
                        }
                    }   happiness=find_happiness(g[partner]);
                    break;
                case 3:
                    j=0;
                    k=0;
                    balance = g[partner].maintainance_cost;
                    while(balance>0 && j<e1){
                        g[partner].cost+=e[j].price;
                        g[partner].value+=e[j].value;
                        balance = balance-e[j].price;
                        j++;
                    }   if(balance > 0 && balance-l[0].price >=0) {
                        g[partner].cost+=l[0].price;
                        g[partner].value+=2*l[0].value;
                    }   happiness=g[partner].intellect;
                    break;
                default:
                    break;
            }
        }
    }
   
    public int find_happiness( Girl g) {
        switch (g.type) {
            case 1:
                g.happiness= (int)Math.log(g.cost);
                break;
            case 2:
                g.happiness =( g.cost-g.maintainance_cost + g.value);
                break;
            case 3:
                g.happiness =(int) Math.exp(g.cost);
                break;
            default:
                break;
        }
        
        return g.happiness;
    }
}

