import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String phone;

    public Customer(int id, String lastName, String firstName, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }
}

public class CustomerApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel idLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel phoneLabel;
    private JButton previousButton;
    private JButton nextButton;
    private Customer[] customers;
    private int currentIndex;

    public CustomerApp() {
        customers = new Customer[]{
                new Customer(1, "Chenda", "Sovisal", "092888999"),
                new Customer(2, "Kom", "Lina", "092000999"),
                new Customer(3, "Chan", "Seyha", "092777666")
        };
        currentIndex = 0;

        setTitle("Customer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        idLabel = new JLabel();
        lastNameLabel = new JLabel();
        firstNameLabel = new JLabel();
        phoneLabel = new JLabel();
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        add(new JLabel("ID:"));
        add(idLabel);
        add(new JLabel("Last Name:"));
        add(lastNameLabel);
        add(new JLabel("First Name:"));
        add(firstNameLabel);
        add(new JLabel("Phone:"));
        add(phoneLabel);
        add(previousButton);
        add(nextButton);

        updateCustomerInfo();

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateCustomerInfo();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.length - 1) {
                    currentIndex++;
                    updateCustomerInfo();
                }
            }
        });
    }

    private void updateCustomerInfo() {
        Customer customer = customers[currentIndex];
        idLabel.setText(String.valueOf(customer.getId()));
        lastNameLabel.setText(customer.getLastName());
        firstNameLabel.setText(customer.getFirstName());
        phoneLabel.setText(customer.getPhone());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerApp().setVisible(true);
            }
        });
    }
}