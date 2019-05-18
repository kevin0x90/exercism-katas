const GIGASECOND_IN_MILLISECONDS = 1000000000000;

module.exports = {
  gigasecond: function (startDateTime) {
    if (!(startDateTime instanceof Date) || isNaN(startDateTime.valueOf())) {
      throw "startDateTime must be of type Date";
    }

    return new Date(startDateTime.getTime() + GIGASECOND_IN_MILLISECONDS);
  }
};