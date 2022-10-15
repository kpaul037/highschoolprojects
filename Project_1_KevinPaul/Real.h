// Kevin Paul, kpp200001

#ifndef REAL_H
#define REAL_H
#include <iostream>

class Real {
private:
	double real;
public:
	Real() { real = 0.0; }
	Real(double real) { this->real = real; }

	double getReal() { return real; }
	void setReal(double real) { this->real = real; }

	friend ostream& operator<<(ostream& out, Real& r) {
		out << r.getReal();
		return out;
	}

	bool operator==(Real& r);
	bool operator<(Real& r);
	bool operator>(Real& r);
};

#endif
