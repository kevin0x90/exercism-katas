defmodule RomanNumerals do
  @m ["", "M", "MM", "MMM"]
  @c ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
  @x ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
  @i ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]

  @doc """
  Convert the number to a roman number.
  """
  @spec numeral(pos_integer) :: String.t()
  def numeral(number) do
    Enum.at(@m, div(number, 1000)) <>
    Enum.at(@c, rem(number, 1000) |> div(100)) <>
    Enum.at(@x, rem(number, 100) |> div(10)) <>
    Enum.at(@i, rem(number, 10))
  end
end
