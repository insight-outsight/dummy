package design_pattern.strategy;
public class Client {
    
    public static void main(String[] args) {
        int price = 50;
        int num = 7;
        double totalPrices = num * price;
        CashContext cashContext = new CashContext(new CashNormal());
        String type = "正常收费";
        double actualPrices = cashContext.getResult(totalPrices);
        System.out.println("单价：" + price + "，数量：" + num + "，类型：" + type + "，合计：" + actualPrices);

        System.out.println("------------------------------");
        cashContext = new CashContext(new CashReturn(300, 100));
        type = "满300返100";
        actualPrices = cashContext.getResult(totalPrices);
        System.out.println("单价：" + price + "，数量：" + num + "，类型：" + type + "，合计：" + actualPrices);
        
        System.out.println("------------------------------");
        cashContext = new CashContext(new CashRebate(0.8));
        type = "打8折";
        actualPrices = cashContext.getResult(totalPrices);
        System.out.println("单价：" + price + "，数量：" + num + "，类型：" + type + "，合计：" + actualPrices);

    }

}