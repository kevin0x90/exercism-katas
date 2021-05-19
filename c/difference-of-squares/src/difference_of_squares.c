#include "difference_of_squares.h"

unsigned int sum_of_squares(const unsigned int number)
{
  return number * (number + 1) * (2 * number + 1) / 6;
}

unsigned int square_of_sum(const unsigned int number)
{
  const unsigned int sumOfNumbersUpToInput = number * (number + 1) / 2;

  return sumOfNumbersUpToInput * sumOfNumbersUpToInput;
}

unsigned int difference_of_squares(const unsigned int number)
{
  return square_of_sum(number) - sum_of_squares(number);
}
