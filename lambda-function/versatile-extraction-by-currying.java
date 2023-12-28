import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;


class Customer {
    public int id;
    public String company;
    public String name;
    public String rank;
    public String email;

    public Customer(int id, String company, String name, String rank, String email) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.rank = rank;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", company='" + company +
                ", name='" + name +
                ", rank='" + rank +
                ", email='" + email +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<Customer> customerList = Arrays.asList(
                new Customer(1, "MH Corp.", "Makenzie Hibbert", "A", "makenzie@example.com"),
                new Customer(2, "MH Corp.", "Abram Martinho Fleming", "B", "abram@example.com"),
                new Customer(3, "Best Inc.", "Trey Best", "A", "trey@example.com"),
                new Customer(4, "Best Inc.", "Joshua Charnley", "B", "joshua@example.com"),
                new Customer(5, "Best Inc.", "Sue Rodger", "C", "sue@example.com")
        );

        Function<String, Predicate<Customer>> filterByCompany = company -> personal -> personal.company.equals(company);
        Function<String, Predicate<Customer>> filterByRank = rank -> personal -> personal.rank.equals(rank);

        BiFunction<List<Customer>, Function<String, Predicate<Customer>>, Function<String, List<Customer>>> versatileExtraction = (list, uniqueFilter) -> value -> {
            return list.stream()
                    .filter(uniqueFilter.apply(value))
                    .collect(Collectors.toList());
        };

        System.out.println(versatileExtraction.apply(customerList, filterByCompany).apply("MH Corp."));
        System.out.println(versatileExtraction.apply(customerList, filterByRank).apply("A"));
    }
}
