package sti.andreas.nasir.service.impl;


import sti.andreas.nasir.service.StiService;

public class Main {
    private StiService stiService;

    public Main(StiService stiService) {

        this.stiService = stiService;
    }
    public static void main(String[] args) {
        Main main = new Main(new StiServiceImpl());

    }
}
