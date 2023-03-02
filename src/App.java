import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import model.legal_person.LegalPerson;
import model.person.Person;
import model.physical_person.PhysicalPerson;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> listPerson = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberPayers = sc.nextInt();

        for(int i = 0; i < numberPayers; i++){

            System.out.print("Individual or company(i/c): ");
            char individualOrCompany = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            Double annualIncome = sc.nextDouble();

            if( individualOrCompany == 'i'){

                System.out.print("Health expeditures: ");
                Double healtExpenditures = sc.nextDouble();
                listPerson.add(new PhysicalPerson(name, annualIncome, healtExpenditures));
            }
            else{

                System.out.print("Number of employees: ");
                int numbreOfEmployees =  sc.nextInt();
                listPerson.add(new LegalPerson(name, annualIncome, numbreOfEmployees));
            }
        }
        Double result = 0.00;
        for (Person person : listPerson) {
            System.out.print( person.getName()+": $" );
            System.out.println( String.format("%.2f",person.tax()) );
            result += person.tax();
        }
        System.out.println("Total Taxes: $ "+ result);
        sc.close();
    }
}
