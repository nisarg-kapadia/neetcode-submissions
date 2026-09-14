class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int bills_5 = 0;
        int bills_10 = 0;
        int bills_20 = 0;

        for(int b : bills){

            if(b == 5){
                bills_5++;
            }else if(b == 10){

                if(bills_5 > 0){
                    bills_5--;
                    bills_10++;
                }else{
                    return false;
                }
            }else{

                if(bills_10 > 0 && bills_5 > 0){
                    bills_10--;
                    bills_5--;
                } else if(bills_5 >= 3){
                    bills_5 -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}