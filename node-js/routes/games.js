const express = require('express')
const router  = express.Router()

const RESULT = { status: 'ok' }
const RESULT_MOVE = { status: 'ok', move_from: [0,2], move_to: [0,3] }

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
