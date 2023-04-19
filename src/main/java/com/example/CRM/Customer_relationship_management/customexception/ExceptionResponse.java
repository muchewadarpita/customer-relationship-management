package com.example.CRM.Customer_relationship_management.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {


    private Date date;
    private String status;
    private String error;
    private String path;

    @Override
    public String toString() {
        return "{\n" +
                "  \"timestamp\": \"" + date + "\",\n" +
                "  \"status\": " + status + ",\n" +
                "  \"error\": \"" + error + "\",\n" +
                "  \"path\": \"" + path + "\"\n" +
                "}";
    }


}
