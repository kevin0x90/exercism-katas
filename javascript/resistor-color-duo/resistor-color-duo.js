const RESISTOR_COLOR_VALUE_MAPPING = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9
}

function calculateColorResistance(resistance, resistorColor, colorIndex) {
  return resistance * getDigitPlaceMultiplier(colorIndex) + getResistorColorValue(resistorColor)
}

function getDigitPlaceMultiplier(resistorColorIndex) {
  return Math.pow(10, resistorColorIndex)
}

function getResistorColorValue(resistorColor) {
  const value = RESISTOR_COLOR_VALUE_MAPPING[resistorColor]

  if (value === undefined) {
    throw new Error(`invalid resistor color ${resistorColor} does not exist`)
  }

  return value
}

export function value(resistorColorPair) {
  return resistorColorPair.reduce(calculateColorResistance, 0)
}