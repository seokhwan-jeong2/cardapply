package cardapply.domain;

import cardapply.CustomerApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer_table")
@Data
//<<< DDD / Aggregate Root
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private Long jusaupno;

    private Integer customergubun;

    private String address;

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void customer(Applied applied) {
        //implement business logic here:

        /** Example 1:  new item 
        Customer customer = new Customer();
        repository().save(customer);

        CustomerManaged customerManaged = new CustomerManaged(customer);
        customerManaged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(applied.get???()).ifPresent(customer->{
            
            customer // do something
            repository().save(customer);

            CustomerManaged customerManaged = new CustomerManaged(customer);
            customerManaged.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
