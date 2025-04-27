public class stock {

    public static void stockPrice(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int max_profit =0;
        for(int i=0;i<prices.length;i++){
            int sellPrice = prices[i];
            if(buyPrice<sellPrice){
                int profit = sellPrice-buyPrice;
                max_profit = Math.max(max_profit, profit);
                
            }
            else{
                buyPrice=sellPrice;
            }   
        }
        System.out.println(max_profit);
    }
    public static void main(String[] args) {
        int prices[]= {7,1,5,3,6,4};
        stockPrice(prices);

    }
    
}
