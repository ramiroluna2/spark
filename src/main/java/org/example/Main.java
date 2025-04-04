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

        EJ1_PalindromoController.initRoutes();
        EJ2_CirculoController.initRoutes();
        EJ3_PersonaController.initRoutes();
        EJ4_EmergenciaController.initRoutes();
        EJ5_InflacionController.initRoutes();
        EJ6_ArticuloController.initRoutes();
        EJ7_LibroController.initRoutes();
        EJ8_TorneoController.initRoutes();
    }
}



