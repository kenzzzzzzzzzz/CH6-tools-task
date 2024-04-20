package app;

import ejb.Calculation;
import ejb.CalculationService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/calc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationResource {

    @EJB
    private CalculationService calculationService;

    @POST
    public Response createCalculation(CalculationRequest request) {
        try {
            int number1 = request.getNumber1();
            int number2 = request.getNumber2();
            String operation = request.getOperation();

            double result = calculationService.performCalculation(number1, number2, operation);
            calculationService.saveCalculation(number1, number2, operation, result);

            return Response.ok(new CalculationResponse(result)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/calculations")
  
    public Response getAllCalculations() {
        try {
            List<Calculation> calculations = calculationService.getAllCalculations();
            return Response.ok(calculations).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
