function parseRows(rowStrings) {
  return rowStrings.map(row => row.split(' ').map(elem => parseInt(elem, 10)))
}

function generateColumns(maxNumberOfColumns, rows) {
  const columns = []
  for (let i = 0; i < maxNumberOfColumns; ++i) {
    columns[i] = rows.map(row => row[i])
  }

  return columns
}

function parseMatrix(matrixDescription) {
  const rowStrings = matrixDescription.split('\n')
  const rows = parseRows(rowStrings)
  const maxNumberOfColumns = rows.reduce((result, row) => Math.max(result, row.length), 0)
  const columns = generateColumns(maxNumberOfColumns, rows)

  return {
    rows,
    columns,
  }
}

export class Matrix {
  constructor(matrixDescription) {
    this.matrix = parseMatrix(matrixDescription)
  }

  get rows() {
    return this.matrix.rows
  }

  get columns() {
    return this.matrix.columns
  }
}
