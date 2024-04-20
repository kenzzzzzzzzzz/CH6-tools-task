package ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;


@Stateless
public class CalculationService {
	@PersistenceContext(unitName="calc")
    private EntityManager entityManager;

    public double performCalculation(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                return number2 != 0 ? (double) number1 / number2 : Double.NaN;
            case "*":
                return number1 * number2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public void saveCalculation(int number1, int number2, String operation, double result) {
        Calculation calculation = new Calculation(number1, number2, operation, result);
        entityManager.persist(calculation);
    }

    public List<Calculation> getAllCalculations() {
        TypedQuery<Calculation> query = entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class);
        return query.getResultList();
    }
}
