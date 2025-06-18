package com.example.implementations;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle moving with Michelin tyres";
    }
}
