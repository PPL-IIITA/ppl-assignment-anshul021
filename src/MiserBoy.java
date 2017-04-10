/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class MiserBoy extends Boy {
    
    public MiserBoy() {
        attractive=0;
        budget=0;
        intellect=0;
        min_attraction=0;
        status= 1;
        partner = -1;
        c=0;
    }
    
    
    @Override
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
            if(criteria == 1) {
                j=0; k=0;
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
                }
                happiness=balance;
            }
            
    }
    }
    
    
    
    @Override
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

