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
                result =  lhs / rhs;
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
            case "%":
                result = lhs % rhs;
                break;
            case "√":
                result = lhs * Math.sqrt(rhs);
                break;
            case "L":
                result = lhs * Math.log10(rhs);
                break;
            case "l":
                result = lhs * (Math.log(rhs) / Math.log(2));
                break;
            case "C":
                result = lhs * Math.cos(rhs);
                break;
            case "S":
                result = lhs * Math.sin(rhs);
                break;
            case "T":
                result = lhs * Math.tan(rhs);
                break;
            default:
                break;
        }
        return result;
    }
}

