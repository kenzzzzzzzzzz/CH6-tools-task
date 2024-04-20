package ejb;

import javax.persistence.*;

@Entity
@Table(name = "calculations")
public class Calculation {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	    @Column(nullable = false)
	    private int number1;

	    @Column(nullable = false)
	    private int number2;

	    @Column(nullable = false)
	    private String operation;

	    @Column(nullable = false)
	    private double result;

	    public Calculation() {
	    }

	    public Calculation(int number1, int number2, String operation, double result) {
	        this.number1 = number1;
	        this.number2 = number2;
	        this.operation = operation;
	        this.result = result;
	    }
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public int getNumber1() {
	        return number1;
	    }

	    public void setNumber1(int number1) {
	        this.number1 = number1;
	    }

	    public int getNumber2() {
	        return number2;
	    }

	    public void setNumber2(int number2) {
	        this.number2 = number2;
	    }

	    public String getOperation() {
	        return operation;
	    }

	    public void setOperation(String operation) {
	        this.operation = operation;
	    }

	    public double getResult() {
	        return result;
	    }

	    public void setResult(double result) {
	        this.result = result;
	    }
	    
}
