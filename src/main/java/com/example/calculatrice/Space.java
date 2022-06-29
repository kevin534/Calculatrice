package com.example.calculatrice;

public class Space {
    public String addSingleSpaces(String expression) {

            //Ajouter des espaces aux opérandes / , ^ , * , + , -
        expression = expression.replaceAll("(?<=[0-9()])[\\/]", " / ");
        expression = expression.replaceAll("(?<=[0-9()])[\\^]", " ^ ");
        expression = expression.replaceAll("(?<=[0-9()])[\\*]", " * ");
        expression = expression.replaceAll("(?<=[0-9()])[+]", " + ");
        expression = expression.replaceAll("(?<=[0-9()])[-]", " - ");

            /*
             *   remplacer les espaces doubles par des espaces simples
             *   jusqu'à ce que la chaîne soit correctement formatée.
             */
        expression = expression.replaceAll(" {2,}", " ");

            return expression;
    }
}
