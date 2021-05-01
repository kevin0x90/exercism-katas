#include "hamming.h"
#include <stdbool.h>

static inline bool is_end_of_string(const char *str)
{
  return *str == '\0';
}

int compute(const char *lhs, const char *rhs)
{
  int difference = 0;

  for (; !is_end_of_string(lhs) && !is_end_of_string(rhs); ++lhs, ++rhs)
  {
    if (*lhs != *rhs)
    {
      ++difference;
    }
  }

  return is_end_of_string(lhs) && is_end_of_string(rhs)
    ? difference
    : -1;
}
