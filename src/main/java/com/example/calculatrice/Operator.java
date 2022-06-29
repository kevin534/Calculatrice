package com.example.calculatrice;

public class Operator {

    public Double getResultOperation(String operation, Double rhs, Double lhs) {
        Double result = null;
        switch (operation){
            case "/":
                // prévoir la division par 0 et retourner null
                if(rhs == 0){
                    return null;
                }
                result = lhs / rhs;
                break;
            case "^":
                result = Math.pow(lhs, rhs);
                break;
            case "*":
                result = lhs * rhs;
                break;
            case "-":
                result = lhs - rhs;
                break;
            case "+":
                result = lhs + rhs;
                break;
            default:
                break;
        }
        return result;
    }
}

