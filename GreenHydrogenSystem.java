import java.util.*;

public class GreenHydrogenSystem {
    static Scanner sc = new Scanner(System.in);
    static double energy=0, hydrogen=0, stored=0, transported=0;

    static void dashboard(){
        System.out.println("\n===== DASHBOARD =====");
        System.out.printf("Renewable Energy : %.2f kWh%n", energy);
        System.out.printf("Hydrogen Produced: %.2f kg%n", hydrogen);
        System.out.printf("Hydrogen Stored  : %.2f kg%n", stored);
        System.out.printf("Hydrogen Transported: %.2f kg%n", transported);
    }

    public static void main(String[] args){
        while(true){
            System.out.println("\nGREEN HYDROGEN MANAGEMENT SYSTEM");
            System.out.println("1. Enter Renewable Energy");
            System.out.println("2. Calculate Hydrogen");
            System.out.println("3. Store Hydrogen");
            System.out.println("4. Transport Hydrogen");
            System.out.println("5. Dashboard");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter renewable energy (kWh): ");
                    energy=sc.nextDouble();
                    break;
                case 2:
                    hydrogen=energy/50.0; // simple estimation
                    System.out.printf("Estimated Hydrogen = %.2f kg%n",hydrogen);
                    break;
                case 3:
                    System.out.print("Enter amount to store (kg): ");
                    stored=sc.nextDouble();
                    if(stored>hydrogen){
                        stored=hydrogen;
                        System.out.println("Storage adjusted to available hydrogen.");
                    }
                    break;
                case 4:
                    System.out.print("Enter amount to transport (kg): ");
                    transported=sc.nextDouble();
                    if(transported>stored){
                        transported=stored;
                        System.out.println("Transport adjusted to stored hydrogen.");
                    }
                    stored-=transported;
                    break;
                case 5:
                    dashboard();
                    break;
                case 6:
                    System.out.println("\n===== REPORT =====");
                    dashboard();
                    System.out.printf("Estimated CO2 Saved: %.2f kg%n", hydrogen*10);
                    break;
                case 7:
                    System.out.println("Thank you.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
