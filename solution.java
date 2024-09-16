import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShamirSecretSharing {

    // Function to decode values from a given base
    private static BigInteger decodeValue(String valueStr, int base) {
        return new BigInteger(valueStr, base);
    }

    // Function to calculate the Lagrange basis polynomial value at a specific x
    private static BigInteger lagrangeBasis(List<BigInteger> xs, int i, BigInteger x) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int j = 0; j < xs.size(); j++) {
            if (i != j) {
                numerator = numerator.multiply(x.subtract(xs.get(j)));
                denominator = denominator.multiply(xs.get(i).subtract(xs.get(j)));
            }
        }

        return numerator.divide(denominator);
    }

    // Function to calculate the constant term of the polynomial using Lagrange interpolation
    private static BigInteger lagrangeInterpolation(List<BigInteger> xs, List<BigInteger> ys) {
        BigInteger total = BigInteger.ZERO;

        for (int i = 0; i < xs.size(); i++) {
            BigInteger li = lagrangeBasis(xs, i, BigInteger.ZERO); // L_i(0)
            total = total.add(ys.get(i).multiply(li));
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read JSON input from the user
        System.out.println("Enter the JSON input:");
        String jsonInput = scanner.useDelimiter("\\A").next();  // Read the entire input
        
        // Parse JSON input
        JSONObject json = new JSONObject(new JSONTokener(new StringReader(jsonInput)));
        JSONObject keys = json.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");

        List<BigInteger> xs = new ArrayList<>();
        List<BigInteger> ys = new ArrayList<>();

        for (String key : json.keySet()) {
            if (key.equals("keys")) continue;

            JSONObject root = json.getJSONObject(key);
            int base = root.getInt("base");
            String value = root.getString("value");

            BigInteger x = new BigInteger(key);
            BigInteger y = decodeValue(value, base);

            xs.add(x);
            ys.add(y);
        }

        // Use only the first k points for interpolation
        List<BigInteger> xsSubset = xs.subList(0, k);
        List<BigInteger> ysSubset = ys.subList(0, k);

        // Compute the constant term (polynomial value at x = 0)
        BigInteger constantTerm = lagrangeInterpolation(xsSubset, ysSubset);
        System.out.println("The constant term of the polynomial (secret) is: " + constantTerm);
    }
}
