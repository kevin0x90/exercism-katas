Number.prototype.isDivisibleBy = function (number) {
  return this % number === 0;
};

export function isLeap(year) {

  if (!Number.isInteger(year)) {
    throw `Invalid input: ${year}! parameter year must be a integer number`;
  }

  return (year.isDivisibleBy(4) && !year.isDivisibleBy(100)) || (year.isDivisibleBy(400));
};