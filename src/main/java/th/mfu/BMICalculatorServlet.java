package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: get parameter from request: "weight" and "height
        String wString = request.getParameter("weight");
        String wHeight = request.getParameter("height");

        if (wString != null && !wString.isEmpty() && wHeight != null && !wHeight.isEmpty()) {
            try {
                double weight = Double.parseDouble(request.getParameter("Weight"));
                double height = Double.parseDouble(request.getParameter("Height"));

                double bmi = calculateBMI(weight, height);
                String build = determineBuild(bmi);

                request.setAttribute("bmi", Math.round(bmi));
                request.setAttribute("build", build);

                request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid weight or height values.");
            }
        } else {
            response.getWriter().println("Please provide weight and height parameters.");
        }
    }

    private double calculateBMI(double weight, double height) {
        return weight / (height) * (height);
    }

    private String determineBuild(double bmi) {

        if (bmi < 18.5) {
            return ("underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            return ("normal");
        } else if (bmi <= 25 && bmi < 30) {
            return ("obese");
        } else {
            return ("extremely obese");
        }
    }
}
