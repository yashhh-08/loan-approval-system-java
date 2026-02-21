package backend;

import java.util.Map;

public class LoanHandler {
    public static String processLoan(Map<String, String> params) {
        try {
            String name = params.get("name");
            int age = Integer.parseInt(params.get("age"));
            String idProof = params.get("idProof");
            String employment = params.get("employment");
            int choice = Integer.parseInt(params.get("loanType"));
            double principal = Double.parseDouble(params.get("principal"));
            double income = Double.parseDouble(params.get("income"));
            double obligations = Double.parseDouble(params.get("obligations"));
            double collateral = Double.parseDouble(params.get("collateral"));
            int creditScore = Integer.parseInt(params.get("creditScore"));

            Loan loan;
            switch (choice) {
                case 1 -> loan = new HousingLoan(name, age, idProof, employment, "Housing Loan",
                                                principal, income, obligations, collateral, creditScore);
                case 2 -> loan = new VehicleLoan(name, age, idProof, employment, "Vehicle Loan",
                                                principal, income, obligations, collateral, creditScore);
                case 3 -> loan = new SecuredPersonalLoan(name, age, idProof, employment, "Personal Loan",
                                                        principal, income, obligations, collateral, creditScore);
                default -> { return "❌ Invalid loan type selection."; }
            }

            return loan.evaluateEligibility();

        } catch (Exception e) {
            return "⚠️ Error processing loan: " + e.getMessage();
        }
    }
}
