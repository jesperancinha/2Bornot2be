package com.steelzack.b2b2bwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

/**
 * Created by joao on 15-5-16.
 */

@Service
public class DetailController {

    @Autowired
    DetailService detailService;

    public Response<String> findDetailById(Integer id) {
        detailService.findBetailById(id);
        return null;
    }
}
