public class Numbers {
    public static void main(String[] args) {
        double sum = 0;

        for (int i = 0; i < args.length; i++) {
            double currentNum = Double.parseDouble(args[i]);
            sum += currentNum;
        }

        double avg = sum/args.length;
        double moneyToBeMoved = 0;

        for (int i = 0; i < args.length; i++) {
            double currentNum = Double.parseDouble(args[i]);

            if (currentNum < avg) {
                moneyToBeMoved += avg - currentNum;
            }
        }

        System.out.println("To be moved: " + moneyToBeMoved );

    }
}
