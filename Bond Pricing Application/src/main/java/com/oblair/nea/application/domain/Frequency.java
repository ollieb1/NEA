package com.oblair.nea.application.domain;

public enum Frequency {
    QUARTERLY {
        @Override
        public double getDivisor() {
            return 4.0;
        };
    },
    SEMIANNUALLY {
        @Override
        public double getDivisor() {
            return 2.0;
        };
    },
    ANNUALLY {
        @Override
        public double getDivisor() {
            return 1.0;
        };
    };
    
    public abstract double getDivisor();
}
