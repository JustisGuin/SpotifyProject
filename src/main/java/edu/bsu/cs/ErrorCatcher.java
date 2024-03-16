package edu.bsu.cs;

public class ErrorCatcher {
    public String statusError(int requestToken){
    if (requestToken >=200 && requestToken<300 ){
        return String.valueOf(requestToken);
    } else {
        System.err.printf("Error in API request.\nTo learn more about request error please go to https://developer.spotify.com/documentation/web-api/concepts/api-calls\nRequest Response Code:%d\n",requestToken);
        return ("error");

    }
}
}


