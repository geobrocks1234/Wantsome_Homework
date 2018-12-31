package week4.ComplexNumber;

public class Complex {
    private double realPart, imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static Complex complex(double realPart, double imaginaryPart){
        return new Complex(realPart, imaginaryPart);
    }

    public Complex add(Complex b) {
        Complex a = this;
        double real = a.realPart + b.realPart;
        double imag = a.imaginaryPart + b.imaginaryPart;
        return new Complex(real, imag);
    }

    public Complex negate(){
        return new Complex(-this.realPart, -this.imaginaryPart);
    }

    public Complex multiply(Complex b) {
        Complex a = this;
        double real = a.realPart * b.realPart - a.imaginaryPart * b.imaginaryPart;
        double imag = a.realPart * b.imaginaryPart + a.imaginaryPart * b.realPart;
        return new Complex(real, imag);
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Complex that = (Complex) other;
        return (this.realPart == that.realPart) && (this.imaginaryPart == that.imaginaryPart);
    }

    public String toString() {
        if (this.imaginaryPart == 0) return this.realPart + "";
        if (this.realPart == 0) return this.imaginaryPart + "i";
        if (this.imaginaryPart <  0) return this.realPart + " - " + (-this.imaginaryPart) + "i";
        return this.realPart + " + " + this.imaginaryPart + "i";
    }
}
