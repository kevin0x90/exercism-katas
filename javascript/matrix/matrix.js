function parseRows(rowStrings) {
  return rowStrings.reduce((result, row) => {
    result.push(row.split(' ').map(elem => parseInt(elem, 10)))
    return result
  }, [])
}

function generateColumns(maxNumberOfColumns, rows) {
  const columns = []
  for (let i = 0; i < maxNumberOfColumns; ++i) {
    columns.push([])
    for (let k = 0; k < rows.length; ++k) {
      columns[i].push(rows[k][i])
    }
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
