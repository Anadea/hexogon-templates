const express = require('express')
const router  = express.Router()

const RESULT = { status: 'ok' }
const RESULT_MOVE = { status: 'ok', figure: 0 }

router.post('/', (req, res) => {
  res.json(RESULT)
})

router.get('/:id', (req, res) => {
  res.json(RESULT_MOVE)
})

router.put('/:id', (req, res) => {
  res.json(RESULT)
})

router.delete('/:id', (req, res) => {
  res.json(RESULT)
})

module.exports = router
