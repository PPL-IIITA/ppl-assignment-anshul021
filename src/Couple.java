
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class Couple {
    String bname;
    String gname;
    int happy;
    int compatible;
    int cost;
    
  
    public int find_happy(int gs,int bs, Girl g, Boy b[], int commit[],int i) {
        
            if(commit[i]!=-1){
                happy=g.happiness + b[commit[i]].happiness;
                compatible=b[commit[i]].budget-g.maintainance_cost + abs(b[commit[i]].intellect-g.intellect) + abs(b[commit[i]].attractive-g.attractive);
                gname=g.name;
                bname=g.partner;
                cost=g.cost;
                return 1;
            }
            else
                return 0;
        
        
    }
    
}

