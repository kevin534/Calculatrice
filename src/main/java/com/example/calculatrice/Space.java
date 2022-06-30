package com.example.calculatrice;

public class Space {
    public String addSingleSpaces(String expression) {

            //Ajouter des espaces aux opérandes / , ^ , * , + , -
        expression = expression.replaceAll("(?<=[0-9()])[\\/]", " / ");
        expression = expression.replaceAll("(?<=[0-9()])[\\^]", " ^ ");
        expression = expression.replaceAll("(?<=[0-9()])[\\*]", " * ");
        expression = expression.replaceAll("(?<=[0-9()])[+]", " + ");
        expression = expression.replaceAll("(?<=[0-9()])[-]", " - ");
        expression = expression.replaceAll("(?<=[0-9()])[%]", " % ");
        expression = expression.replaceAll("(?<=[0-9()])[√]", " √ ");  //  √  = sqrt()
        expression = expression.replaceAll("(?<=[0-9()])[L]", " L "); // L = log10
        expression = expression.replaceAll("(?<=[0-9()])[l]", " l "); // l = log2
        expression = expression.replaceAll("(?<=[0-9()])[C]", " C "); // C = cosinus
        expression = expression.replaceAll("(?<=[0-9()])[S]", " S "); // S = sinus
        expression = expression.replaceAll("(?<=[0-9()])[T]", " T "); // T = tangente
            /*
             *   remplacer les espaces doubles par des espaces simples
             *   jusqu'à ce que la chaîne soit correctement formatée.
             */
        expression = expression.replaceAll(" {2,}", " ");

            return expression;
    }
}
