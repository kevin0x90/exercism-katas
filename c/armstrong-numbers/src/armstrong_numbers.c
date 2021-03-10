#include "armstrong_numbers.h"

#include <assert.h>

inline unsigned int number_of_digits(int number)
{
  unsigned int numberOfDigits = 0;
  for (int remaining = number; remaining > 0; remaining /= 10, ++numberOfDigits);

  return numberOfDigits;
}

inline int digit_power(int digit, unsigned int power)
{
  int result = digit;
  for (unsigned int i = 1; i < power; result *= digit, ++i);

  return result;
}

inline int sum_of_digits_to_power(int number, unsigned int power)
{
  int sum = 0;
  for (int remaining = number; remaining > 0; remaining /= 10)
  {
    int digit = remaining % 10;
    sum += digit_power(digit, power);
  }

  return sum;
}

bool is_armstrong_number(int candidate)
{
  assert(candidate >= 0);
  unsigned int numberOfDigits = number_of_digits(candidate);

  return sum_of_digits_to_power(candidate, numberOfDigits) == candidate;
}
