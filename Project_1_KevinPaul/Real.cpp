// Kevin Paul, kpp200001

using namespace std;
#include "Real.h"
#include <iostream>
#define EPSILON 0.0000000001

bool Real::operator==(Real& r) {
	return (fabs(real - r.getReal()) < EPSILON) ? true : false;
}

bool Real::operator<(Real& r) { return real < r.getReal(); }

bool Real::operator>(Real& r) { return real > r.getReal(); }