import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker{
    static ArrayList<String> categories = new ArrayList<>();
    static ArrayList<Double> budgets = new ArrayList<>();
    static ArrayList<Expense> expenses = new ArrayList<>();

    static void addExpense(String category, double amount, String description){
        expenses.add(new Expense(category, amount, description));
    }

    static void categorizeExpenses(String category){
        if(!categories.contains(category)) {
            categories.add(category);
            budgets.add(0.0);
        }
    }

    static void setBudget(String category, double budget){
        int index = categories.indexOf(category);
        if(index != -1){
            budgets.set(index, budget);
        }
        System.out.println("Category not found.");
    }

    static void viewExpenses() {
        for (Expense expense : expenses) {
            System.out.println("Category: " + expense.category
                    + ", Aomunt: " + expense.amount
                    + ", Description: " + expense.description);

        }
    }

    static void viewSpendingReport(){
        for(int i = 0; i<categories.size(); i++){
            String category = categories.get(i);
            double totalSpent  = 0;
            for(Expense expense  : expenses){
                if(expense.category.equals(category)){
                    totalSpent += expense.amount;
                }
            }
            System.out.println("Category: " + category + ", Total Spent: " + totalSpent + ", Budget: " + budgets.get(i));
        }
    }

    static void budgetAlert() {
        for (int i = 0; i < categories.size(); i++) {
            String category = categories.get(i);
            double totalSpent = 0;
            for(Expense expense: expenses){
                if(expense.category.equals(category)){
                    totalSpent += expense.amount;
                }
            }
            if(totalSpent > budgets.get(i)){
                System.out.println("Alert: spending in " + category + "exceeds the budget!");
            }

        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Categorize Expenses");
            System.out.println("3. Set Budget");
            System.out.println("4. View Expenses");
            System.out.println("5. View Spending Report");
            System.out.println("6. Budget Alert");
            System.out.println("7. Exit");
            System.out.println("Enter Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    addExpense(category, amount, description);
                    break;
                case 2:
                    System.out.print("Enter category: ");
                    String newCategory = scanner.nextLine();
                    categorizeExpenses(newCategory);
                    break;
                case 3:
                    System.out.print("Enter category: ");
                    String budgetCategory = scanner.nextLine();
                    System.out.print("Enter budget amount: ");
                    double budget = scanner.nextDouble();
                    setBudget(budgetCategory, budget);
                    break;
                case 4:
                    viewExpenses();
                    break;
                case 5:
                    viewSpendingReport();
                    break;
                case 6:
                    budgetAlert();
                    break;
                case 7:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invallid choice. Please try again.");
            }
        } while (choice != 7);
        scanner.close();
    }
}
