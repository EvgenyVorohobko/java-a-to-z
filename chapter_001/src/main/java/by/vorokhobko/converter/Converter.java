package by.vorokhobko.converter;

public class Converter {

    public int rubleToEuro(int value) {
        return value / 70;
    }

    public int rubleToDollar(int value) {
        return value / 60;
    }

    public int euroToRuble(int value) {
        return value * 70;
    }

    public int dollarToRuble(int value) {
        return value * 60;
    }
}