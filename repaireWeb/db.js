const mongoose = require('mongoose')
const Schema = mongoose.Schema

const DB_URL = 'mongodb://127.0.0.1:27017/repairdb';

// 中心的数据结构模型
const centerSchema = new Schema({
    center_name:String
})

// 维修项目的的数据结构模型
const repaireSchema = new Schema({
  time: String,
  site_name: String,
  repair_pro: String,
  repair_person: String,
  site_person: String,
  center_name: String
})

mongoose.Promise = global.Promise;
mongoose.connect(DB_URL);
const database =  mongoose.connection;
database.on('error', function(error){
  console.log('数据库repairdb连接失败：' + error)
  return
})
database.once('open', function(){
  console.log('数据库repairdb连接成功')
  // 初始化数据库
})

const db = {
  center_test: mongoose.model('center_test', centerSchema),
  repaire_test: mongoose.model('repaire_test', repaireSchema),
}

module.exports = db