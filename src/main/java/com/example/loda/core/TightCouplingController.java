package com.example.loda.core;

import com.example.loda.core.tightCoupling.TightCoupling;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @author
@Controller
public class TightCouplingController {
    private final TightCoupling tightCoupling;
    private final ApplicationContext applicationContext;
    public TightCouplingController(TightCoupling tightCoupling,ApplicationContext applicationContext) {
        this.tightCoupling = tightCoupling;
        this.applicationContext =applicationContext;
    }

    @GetMapping("/tightCoupling")
    public String tightCoupling(){
        System.out.println(tightCoupling.TightCoupling(applicationContext));
        return null;
    }
}
