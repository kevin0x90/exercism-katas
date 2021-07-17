#include <math.h>
#include <stdio.h>
#include "square_root.h"

#define UNSIGNED_INT_BITS (sizeof(unsigned int) * 8)

unsigned int square_root(unsigned int radicand)
{
  unsigned int res = 0;
  // Set second highest bit
  unsigned int bit = 1 << (UNSIGNED_INT_BITS - 2);

  // "bit" starts at the highest power of four <= the argument.
  while (bit > radicand)
  {
    bit >>= 2;
  }

  while (bit != 0)
  {
    if (radicand >= res + bit)
    {
      radicand -= res + bit;
      res = (res >> 1) + bit;
    } else
    {
      res >>= 1;
    }
    bit >>= 2;
  }

  return res;
}
