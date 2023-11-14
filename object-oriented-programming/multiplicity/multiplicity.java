import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company1 = new Company();
        Company company2 = new Company();
        Company company3 = new Company();

        // employee1 works for company1 and company2.
        Employee employee1 = new Employee(company1, company2);
        company1.addEmployee(employee1);
        company2.addEmployee(employee1);

        BoardMember boardMember1 = new BoardMember();
        BoardMember boardMember2 = new BoardMember();
        // company1's boardMembers are boardMember1 and boardMember2.
        company1.setBoardMember(boardMember1, 0);
        company1.setBoardMember(boardMember2, 1);
        boardMember1.setCompany(company1, 0);
        boardMember2.setCompany(company1, 0);
        // company2's boardMember is boardMember1.
        company2.setBoardMember(boardMember1, 0);
        boardMember1.setCompany(company2, 1);

        // Company1 has company2 and company3 as subsidiaries.
        // Company 1 has no parent companies.
        company1.addSubsidiary(company2);
        company1.addSubsidiary(company3);
        company2.setParentCompany(company1);
        company3.setParentCompany(company1);

        // checking if the program works correctly.
        System.out.println(company1.employees.size());
        System.out.println(company2.employees.size());
        System.out.println(company1.subsidiaries.size());
        System.out.println(company2.subsidiaries.size());
    }
}

// An employee works for 1-2 companies.
// Employee -> (multiplicity: 1..2) -> Company
class Employee{
    public Company mainJob;
    public Company secondJob;

    public Employee(Company mainJob, Company secondJob){
        this.mainJob = mainJob;
        this.secondJob = secondJob;
    }
}

// A company can have many employees.
// Company -> (multiplicity: *) -> Employee
// A company has 1-10 BoardMembers
// Company -> (multiplicity: 1..10) -> BoardMember
// A company can have many subsidiaries.
// Company -> (multiplicity: *) -> Company
// A Company has 0-1 parent companies.
// Company -> (multiplicity: 0..1) -> Company
class Company{
    // As company can employ as many employees as they want, employees will be stored in an arraylist
    public ArrayList<Employee> employees = new ArrayList<>();

    public BoardMember[] boardMembers = new BoardMember[10];

    public ArrayList<Company> subsidiaries = new ArrayList<>();

    // If the company does not have parentCompany, this instance variable will be null (multiplicity: 0..1)
    public Company parentCompany;

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void setBoardMember(BoardMember boardMember, int position){
        boardMembers[position] = boardMember;
    }

    public void addSubsidiary(Company company){
        subsidiaries.add(company);
    }

    public void setParentCompany(Company company){
        parentCompany = company;
    }

}

// A BoardMember manages 1-5 companies.
// BoardMember -> (multiplicity: 1..5) -> Company
class BoardMember{
    public Company[] managingCompanies = new Company[5];

    public void setCompany(Company company, int position){
        managingCompanies[position] = company;
    }
}
