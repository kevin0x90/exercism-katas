#include "leap.h"

namespace leap {

  namespace {
    static inline bool is_divisible_by(unsigned int year, unsigned int divisor)
    {
      return year % divisor == 0;
    }
  }

  bool is_leap_year(unsigned int year)
  {
    return is_divisible_by(year, 4) && (!is_divisible_by(year, 100) || is_divisible_by(year, 400));
  }

}  // namespace leap
