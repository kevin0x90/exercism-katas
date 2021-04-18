#include "resistor_color.h"

int color_code(const resistor_band_t color) {
  return color;
}

const resistor_band_t* colors(void) {
  static resistor_band_t result[] = {
    BLACK,
    BROWN,
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    VIOLET,
    GREY,
    WHITE
  };

  return result;
}