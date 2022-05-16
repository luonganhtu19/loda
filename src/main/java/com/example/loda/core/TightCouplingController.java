package com.example.loda.core;

import com.example.loda.core.tightCoupling.TightCoupling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @author
@Controller
public class TightCouplingController {
    private final TightCoupling tightCoupling;

    public TightCouplingController(TightCoupling tightCoupling) {
        this.tightCoupling = tightCoupling;
    }

    @GetMapping("/tightCoupling")
    public String tightCoupling(){
        System.out.println(tightCoupling.TightCoupling());
        return null;
    }
}
