package sti.andreas.nasir.service.impl;


import sti.andreas.nasir.domain.Student;
import sti.andreas.nasir.service.StiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private StiService stiService;

    public Main(StiService stiService) {
        this.stiService = stiService;
    }
    public static void main(String[] args) {
       Main main = new Main(new StiServiceImpl());
        main.stiService.run();

    }
}
