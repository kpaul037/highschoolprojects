// Kevin Paul, kpp200001

#ifndef COMPLEX_H
#define COMPLEX_H
#include <iostream>

class Complex : public Real {
private:
	double imaginary;
public:
	Complex() { imaginary = 0.0; }
	
	Complex(double imaginary) : Real(0.0) {
		this->imaginary = imaginary;
	}

	double getImaginary() { return imaginary; }
	void setImaginary(double imaginary) { this->imaginary = imaginary; }

	friend ostream& operator<<(ostream& out, Complex& c) {
		out << c.getImaginary();
		return out;
	}

	bool operator==(Complex& r);
	bool operator<(Complex& r);
	bool operator>(Complex& r);
};

#endif