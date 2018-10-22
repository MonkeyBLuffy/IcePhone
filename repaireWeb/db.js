const mongoose = require('mongoose')
const Schema = mongoose.Schema

// 中心的数据结构模型
const centerSchema = new Schema({
    id:String,
    center_name:String
})

// 维修项目的的数据结构模型
const repaireSchema = new Schema({
  id: String,
  time: String,
  site_name: String,
  repair_pro: String,
  repair_person: String,
  site_person: String,
  center_name: String,
})

mongoose.Promise = global.Promise;
const database = mongoose.connect('mongodb://127.0.0.1:27017/repairdb')
database.connection.on('error', function(error){
  console.log('数据库repairdb连接失败：' + error)
  return
})
database.connection.once('open', function(){
  console.log('数据库repairdb连接成功')
  // 初始化数据库
})

const db = {
  centerModel: database.model('centerModel', centerSchema),
  repaireModel: database.model('repaireModel', repaireSchema),
}

module.exports = db