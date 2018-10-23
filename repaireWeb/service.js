const express = require('express')
const app = express()

const api = require('./api')
api(app)

app.listen(5000)

console.log('Server running at http://127.0.0.1:5000/');