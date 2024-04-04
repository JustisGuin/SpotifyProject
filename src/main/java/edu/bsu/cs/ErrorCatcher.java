package edu.bsu.cs;

public class ErrorCatcher {

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
}


