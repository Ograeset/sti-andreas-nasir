package sti.andreas.nasir.service.impl;
import java.util.logger

import sti.andreas.nasir.service.StiService;

import java.util.Scanner;

public class Main {
    private StiService stiService;

    public Main(StiService stiService) {
        this.stiService = stiService;
    }
    public static void main(String[] args) {
        Main main = new Main(new StiServiceImpl());

    }

}
