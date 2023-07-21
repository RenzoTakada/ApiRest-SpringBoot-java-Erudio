package br.com.euridio.apirestspringbootjavaeuridio.Exceptions;

import java.io.Serializable;
import java.util.Date;


public class ExpectionResponse implements Serializable {

    private Date timeStamp;
    private String message;
    private String details;

    public ExpectionResponse(Date timeStamp,String message, String details){
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;

    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
