package model.legal_person;

import model.person.Person;

public class LegalPerson extends Person{
    
    private  int numberOfEmployees;

    public LegalPerson(String name, Double annualIncome, int numberOfEmployees){
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees(){
        return  numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees){
        this.numberOfEmployees = numberOfEmployees;
    }

    public final Double tax(){
        int tax = numberOfEmployees > 10 ? 14 : 16;
        return (super.getAnnualIncome() * tax)/100;
    }
}
