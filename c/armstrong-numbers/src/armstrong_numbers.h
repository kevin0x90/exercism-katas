#ifndef ARMSTRONG_NUMBERS
#define ARMSTRONG_NUMBERS

#include <stdbool.h>

int digit_power(int digit, unsigned int power);

unsigned int number_of_digits(int number);

int sum_of_digits_to_power(int number, unsigned int power);

bool is_armstrong_number(int candidate);

#endif
