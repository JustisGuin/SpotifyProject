package edu.bsu.cs.model;

public class ErrorCatcher {

    public static void configPropertiesError() {
        System.err.println();
        System.err.println("'NumberFormatException' Error!!! -- This is usually caused by your configuration.properties file containing a mistyped or invalid token.");
    }

    public static void configFileNotFoundError() {
        System.out.println();
        System.err.println("'FileNotFound' Error!!! -- Please verify that you have the 'configuration.properties' file in your project.");
    }

    public static void nullPointerExceptionError() {
        System.out.println();
        System.err.println("'NullPointerException' Error!!! -- Please verify that the 'configuration.properties' file has been added to your project.");
    }

    public static void printUnknownError() {
        System.out.println();
        System.err.println("Unknown error detected");
    }

    public static void sleepError() {
        System.out.println();
        System.err.println("Error with Thread.sleep() function call. Please check code for unreachable statements or loops.");
    }

    public String statusError(int requestToken) {
        switch (requestToken) {
            case 200 -> {
                return "OK - The request has succeeded.";
            }
            case 201 -> {
                return "Created - The request has been fulfilled " +
                        "and resulted in a new resource being created.";
            }
            case 202 -> {
                return "Accepted - The request has been accepted for processing, " +
                        "but the processing has not been completed.";
            }
            case 204 -> {
                return "No Content - The request has succeeded but returns no message body.";
            }
            case 304 -> {
                return "Not Modified - See Conditional requests.";
            }
            case 400 -> {
                return "Bad Request - The request could not be understood by the server " +
                        "due to malformed syntax. The message body will contain more information; " +
                        "see Response Schema.";
            }
            case 401 -> {
                return "Unauthorized - The request requires user authentication or, " +
                        "if the request included authorization credentials, authorization " +
                        "has been refused for those credentials.";
            }
            case 403 -> {
                return "Forbidden - The server understood the request, " +
                        "but is refusing to fulfill it.";
            }
            case 404 -> {
                return "Not Found - The requested resource could not be found. " +
                        "This error can be due to a temporary or permanent condition.";
            }
            case 429 -> {
                return "Too Many Requests - " +
                        "Rate limiting has been applied.";
            }
            case 500 -> {
                return "Internal Server Error";
            }
            case 502 -> {
                return "Bad Gateway - The server was acting as a gateway or proxy " +
                        "and received an invalid response from the upstream server.";
            }
            case 503 -> {
                return "Service Unavailable - The server is currently unable to " +
                        "handle the request due to a temporary condition " +
                        "which will be alleviated after some delay. " +
                        "You can choose to resend the request again.";
            }
            default -> {
                return "Unknown status code: " + requestToken;
            }
        }
    }

    public static void imageNotFoundError() {
        System.out.println();
        System.err.println("No image found!");
    }

    public static void ioExceptionError(){
        System.out.println();
        System.err.println("IOException – if an I/ O error occurs when sending or receiving, or the client has shut down");
    }

    public static void interruptedExceptionError(){
        System.out.println();
        System.err.println("InterruptedException – the operation was interrupted");
    }


}