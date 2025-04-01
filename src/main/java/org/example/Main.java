package org.example;


import static spark.Spark.*;

import org.example.Controller.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        port(4567);

        PalindromoController.initRoutes();
        CirculoController.initRoutes();
        PersonaController.initRoutes();
        EmergenciaController.initRoutes();
        InflacionController.initRoutes();
        ArticuloController.initRoutes();
    }
}