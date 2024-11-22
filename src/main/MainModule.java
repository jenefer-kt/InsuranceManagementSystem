package main;

import dao.ConcreteInsuranceService;
import dao.IPolicyService;
import entity.Policy;
import exception.PolicyNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        IPolicyService policyService = new ConcreteInsuranceService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nInsurance Management System:");
            System.out.println("1. Create Policy");
            System.out.println("2. View Policy");
            System.out.println("3. View All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Policy ID: ");
                    int policyId = scanner.nextInt();
                    System.out.print("Enter Policy Name: ");
                    String policyName = scanner.next();
                    System.out.print("Enter Policy Type: ");
                    String policyType = scanner.next();
                    System.out.print("Enter Coverage Amount: ");
                    double coverageAmount = scanner.nextDouble();
                    System.out.print("Enter Premium: ");
                    double premium = scanner.nextDouble();
                    Policy newPolicy = new Policy(policyId, policyName, policyType, coverageAmount, premium);
                    if (policyService.createPolicy(newPolicy)) {
                        System.out.println("Policy created successfully.");
                    } else {
                        System.out.println("Error creating policy.");
                    }
                    break;

                case 2:
                    // View Policy
                    System.out.print("Enter Policy ID to View: ");
                    int viewId = scanner.nextInt();
                    try {
                        Policy policy = policyService.getPolicy(viewId);
                        if (policy != null) {
                            System.out.println(policy);
                        } else {
                            throw new PolicyNotFoundException("Policy not found!");
                        }
                    } catch (PolicyNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("All Policies:");
                    List<Policy> policies = policyService.getAllPolicies();
                    if (policies.isEmpty()) {
                        System.out.println("No policies available.");
                    } else {
                        for (Policy p : policies) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Policy ID to Update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Policy Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Policy Type: ");
                    String newType = scanner.next();
                    System.out.print("Enter New Coverage Amount: ");
                    double newCoverageAmount = scanner.nextDouble();
                    System.out.print("Enter New Premium: ");
                    double newPremium = scanner.nextDouble();
                    Policy updatedPolicy = new Policy(updateId, newName, newType, newCoverageAmount, newPremium);
                    if (policyService.updatePolicy(updatedPolicy)) {
                        System.out.println("Policy updated successfully.");
                    } else {
                        System.out.println("Error updating policy.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Policy ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    if (policyService.deletePolicy(deleteId)) {
                        System.out.println("Policy deleted successfully.");
                    } else {
                        System.out.println("Error deleting policy.");
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting the Insurance Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
