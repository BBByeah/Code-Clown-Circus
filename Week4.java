class QuadraticEquationSolver {
    private final double a;
    private final double b;
    private final double c;

    // 构造函数
    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 计算方程的根
    public void solve() {
        if (a == 0) {
            System.out.println("对...对吗？");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("方程有两个实数根: " + root1 + " 和 " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("方程有一个实数根: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("方程有两个复数根: " + realPart + " + " + imaginaryPart + "i 和 " + realPart + " - " + imaginaryPart + "i");
        }
    }
}

class LoanCalculator {
    private final double loanAmount; // 贷款总额（万元）
    private final int loanTerm; // 贷款时间（月数）
    private final double annualInterestRate; // 年利率

    //构造函数
    public LoanCalculator(double loanAmount, int loanTerm, double annualInterestRate) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.annualInterestRate = annualInterestRate;
    }

    // 计算等额本金还款法的总利息
    public double calculateEqualPrincipalTotalInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        double totalInterest = 0.0;
        double principalPerMonth = loanAmount / loanTerm;

        for (int month = 1; month <= loanTerm; month++) {
            totalInterest += (loanAmount - (month - 1) * principalPerMonth) * monthlyInterestRate;
        }

        return totalInterest;
    }

    // 计算等额本息还款法的总利息
    public double calculateEqualTotalInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        double totalInterest = 0.0;
        double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm)) /
                (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);

        totalInterest = monthlyPayment * loanTerm - loanAmount;

        return totalInterest;
    }

    public static void main(String[] args) {
        double loanAmount = 1000; // 贷款总额（万元）
        int loanTerm = 12; // 贷款时间（月数）
        double annualInterestRate = 0.05; // 年利率（百分比）

        LoanCalculator calculator = new LoanCalculator(loanAmount, loanTerm, annualInterestRate);

        double equalPrincipalTotalInterest = calculator.calculateEqualPrincipalTotalInterest();
        double equalTotalInterest = calculator.calculateEqualTotalInterest();

        System.out.println("等额本金还款法的总利息: " + equalPrincipalTotalInterest + " 万元");
        System.out.println("等额本息还款法的总利息: " + equalTotalInterest + " 万元");

        // 示例：解方程 x^2 - 3x + 2 = 0
        QuadraticEquationSolver solver = new QuadraticEquationSolver(1, -3, 2);
        solver.solve();
    }
}

