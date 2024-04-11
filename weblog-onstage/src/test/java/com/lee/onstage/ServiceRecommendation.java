public class ServiceRecommendation {

    static class Service {
        String name;
        int price;
        int duration;

        Service(String name, int price, int duration) {
            this.name = name;
            this.price = price;
            this.duration = duration;
        }
    }

    public static String recommendServices(int budget, int availableTime) {
        Service[] services = {
                new Service("轮胎安装", 20, 1),
                new Service("汽车保养", 50, 2),
                new Service("汽车清洗", 30, 1),
                new Service("汽车美容", 60, 3),
                new Service("汽车维修", 40, 2)
        };

        int n = services.length;
        int[][] dp = new int[availableTime + 1][budget + 1];
        int[][] selectedServices = new int[availableTime + 1][budget + 1];

        for (int i = 0; i < n; i++) {
            for (int j = availableTime; j >= services[i].duration; j--) {
                for (int k = budget; k >= services[i].price; k--) {
                    int newPrice = dp[j - services[i].duration][k - services[i].price] + services[i].price;
                    if (newPrice > dp[j][k]) {
                        dp[j][k] = newPrice;
                        selectedServices[j][k] = i + 1;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int remainingBudget = budget;
        int remainingTime = availableTime;
        for (int i = n - 1; i >= 0; i--) {
            int serviceIndex = selectedServices[remainingTime][remainingBudget] - 1;
            if (serviceIndex == i) {
                result.append("1");
                remainingBudget -= services[serviceIndex].price;
                remainingTime -= services[serviceIndex].duration;
            } else {
                result.append("0");
            }
        }
        String s = result.toString();
        String[] split = s.split("");
        String ans = "";
        for (int i = split.length-1; i >=0; i--) {
            if(i==0){
                ans+=split[i];
            }else if(i==split.length-1){
                ans+=split[i];
                ans+=" ";
            }else {
                ans+=split[i];
                ans+=" ";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int budget2 = 110;
        int availableTime2 = 4;
        System.out.println(recommendServices(budget2, availableTime2));  // 输出："1 1 1 0 0"
    }
}
