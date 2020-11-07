defmodule WordCount do
  @spec split_by_word_delimiters(String.t()) :: [String.t()]
  defp split_by_word_delimiters(string) do
    string
    |> String.split(~r/(?![\-])[\s[:punct:]]/u, trim: true)
  end

  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t()) :: map
  def count(sentence) do
    sentence
    |> String.downcase()
    |> split_by_word_delimiters
    |> Enum.frequencies()
  end
end
