module.exports = function logger(req, _, next) {
  console.log(`
====================================
Body: ${JSON.stringify(req.body)}
Query:  ${JSON.stringify(req.query)}
====================================
  `)

  next()
}
