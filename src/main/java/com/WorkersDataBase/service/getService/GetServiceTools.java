package com.WorkersDataBase.service.getService;

import org.springframework.stereotype.Component;

@Component
public class GetServiceTools {
    public Double roundSum(Double sum){
        return Math.round(sum * 100.0) / 100.0;
    }
}
