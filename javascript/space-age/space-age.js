const EARTH_YEAR_IN_SECONDS = 31557600

const roundToTwoDecimalPlaces = value => Math.round(value * 100) / 100

const toEarthYearsInSeconds = earthYearFactor => EARTH_YEAR_IN_SECONDS * earthYearFactor

const calculateAge = earthYearFactor => ageInSeconds => roundToTwoDecimalPlaces(ageInSeconds / toEarthYearsInSeconds(earthYearFactor))

const PLANET_CALCULATION_MAPPING = {
  earth: calculateAge(1),
  mercury: calculateAge(0.2408467),
  venus: calculateAge(0.61519726),
  mars: calculateAge(1.8808158),
  jupiter: calculateAge(11.862615),
  saturn: calculateAge(29.447498),
  uranus: calculateAge(84.016846),
  neptune: calculateAge(164.79132)
}

export const age = (planet, ageInSeconds) => PLANET_CALCULATION_MAPPING[planet.toLowerCase()](ageInSeconds)