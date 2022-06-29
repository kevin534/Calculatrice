package com.example.calculatrice;

import java.text.DecimalFormat;

public class Model {
public final static int DEFAULT_VALUE = -1;
    public final static String STRING_EMPTY = "";
    public Model(String input) {

    }


    public  Double evaluationOfExpression(String expr){
        DecimalFormat df = new DecimalFormat("#.####");
        /*
        *  Formater correctement l'expression avant d'effectuer des opérations
         */
        Space space = new Space();

        String expression = space.addSingleSpaces(expr);

        try {
            /*
            *  Nous évaluerons les opérations suivantes par role de priorité suivant cette ordre:
            *   - les parenthèses
            *   - la division
            *   - la puissance
            *   - la multiplication
            *   - l'addition
            *   - la soustraction
             */

            /*
            *  indexClose renvoie la position de la première occurrence du caractère ")" dans expression
             */
            int indexClose = expression.indexOf(")");

            // initialisation
            int indexOpen = DEFAULT_VALUE;

            // controle si indexClose à trouver une position
            if (indexClose != DEFAULT_VALUE) {

                // récupération de la nouvelle chaîne composée d'une sous-chaîne de la chaîne de départ .
                String substring = expression.substring(0, indexClose);

                // récupération de la dernière position du caractère "(" dans la sous-chaîne
                indexOpen = substring.lastIndexOf("(");

                // récupération d'une sous-chaine de la sous-chaine de départ
                // en supprimant les espaces aux deux extrémités de la sous-chaine
                substring = substring.substring(indexOpen + 1).trim();

                if(indexOpen != DEFAULT_VALUE && indexClose != DEFAULT_VALUE) {

                    Double result = evaluationOfExpression(substring);

                    // réconstruction de l'expression à évaluer
                    expression = expression.substring(0, indexOpen).trim() + " " + result + " " + expression.substring(indexClose + 1).trim();

                    // évaluation de l'expression sans espace
                    return evaluationOfExpression(expression.trim());
                }
            }

            String operation = STRING_EMPTY;

            if(expression.indexOf(" / ") != DEFAULT_VALUE){
                operation = "/";
            }else if(expression.indexOf(" ^ ") != DEFAULT_VALUE){
                operation = "^";
            } else if(expression.indexOf(" * ") != DEFAULT_VALUE){
                operation = "*";
            } else if(expression.indexOf(" + ") != DEFAULT_VALUE){
                operation = "+";
            } else if(expression.indexOf(" - ") != DEFAULT_VALUE){
                operation = "-";
            } else{
                // réturne simplement l'expression convertir en double si elle ne contient pas d'opération
                return Double.parseDouble(expression);
            }

            // récupération de la position de l'opération dans l'expression
            int index = expression.indexOf(operation);

            if(index != DEFAULT_VALUE){

                indexOpen = expression.lastIndexOf(" ", index - 2);
                indexOpen = (indexOpen == DEFAULT_VALUE)?0:indexOpen;
                indexClose = expression.indexOf(" ", index + 2);
                indexClose = (indexClose == DEFAULT_VALUE)?expression.length():indexClose;

                if(indexOpen != DEFAULT_VALUE && indexClose != DEFAULT_VALUE) {
                    // récuperation de la valeur gauche en double
                    Double lhs = Double.parseDouble(expression.substring(indexOpen, index));
                    // récuperation de la valeur droite en double
                    Double rhs = Double.parseDouble(expression.substring(index + 2, indexClose));
                   Operator operateur = new Operator();

                   Double result = null;
                   result = operateur.getResultOperation(operation,rhs,lhs);


                    if(indexClose == expression.length()){
                        expression = expression.substring(0, indexOpen) + " " + result + " " + expression.substring(indexClose);
                    }else{
                        expression = expression.substring(0, indexOpen) + " " + result + " " + expression.substring(indexClose + 1);
                    }
                    return Double.valueOf(df.format(evaluationOfExpression(expression.trim())));
                }
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }
        return 0.0;
    }

}
