/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ins
 */
public class Girl {
 String name;
    int attractive;
    int maintainance_cost;
    int intellect;
    int criteria; 
    int status; 
    int cost; 
    int value; 
    String partner;
    int happiness;
    int type;
    
    public Girl() {
        attractive=0;
        maintainance_cost=0;
        intellect=0;
        criteria = 0;
        status= 1;
        cost=0;
        value=0;
    }
    
    public int matchMaker(Boy b[],int n) {
        int boy_index = -1;
        int max_attribute = 0 , i;
     switch (criteria) {
         case 1:
             i=0;
             while(i<n){
                 if(b[i].budget>=maintainance_cost && b[i].attractive>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                 {
                     max_attribute = b[i].attractive;
                     boy_index = i;
                 }
                 i++;
             }break;
         case 2:
             i=0;
             while(i<n){
                 if(b[i].budget>=maintainance_cost && b[i].budget>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                 {
                     max_attribute = b[i].budget;
                     boy_index = i;
                 }
                 i++;
             }break;
         case 3:
             i=0;
             while(i<n){
                 if(b[i].budget>=maintainance_cost && b[i].intellect>=max_attribute && b[i].status==1 && b[i].min_attraction<=attractive)
                 {
                     max_attribute = b[i].intellect;
                     boy_index = i;
                 }
                 i++;
             }break;
         default:
             break;
     }
            
        if(boy_index != -1) {
            b[boy_index].status = 2;
            status = 2;
            partner=b[boy_index].name;
            
        }
            
        return boy_index;
    }
    
}
