package org.example;

import static spark.Spark.port;
import static spark.Spark.get;
import java.lang.Math;
public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");

        get("sin", (req,res) -> Math.sin(Double.parseDouble(req.queryParams("value"))));

        get("cos", (req,res) -> Math.cos(Double.parseDouble(req.queryParams("value"))));

        get("ispalindrome", (req,res) -> {
            String[] str = req.queryParams("value").split("");
            for (String i : str) {
                System.out.printf(i);
            }
            return req.queryParams("value");
        });

        get("vector", (req,res) -> "4");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
