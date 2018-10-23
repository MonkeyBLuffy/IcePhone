const db = require('./db')

module.exports = function (app) {
  app.all("*", function(req, res, next) {
    // res.writeHead(200, { "Content-Type": "text/plain", "Access-Control-Allow-Origin":"*" })
    // res.header('Access-Control-Allow-Origin', '*')
    // res.header('Access-Control-Allow-Headers', 'X-Requested-With')
    // res.header('Access-Control-Allow-Methods', 'PUT, POST, GET, DELETE, OPTIONS')
    // res.header("X-Powered-By",' 3.2.1')
    // res.header("Content-Type", "application/json;charset=utf-8")
    // next()
    // res.header('Access-Control-Allow-Origin', '*');
    // res.header("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
    // res.header("Access-Control-Allow-Methods","*");

    next();
    // if (req.method == 'OPTIONS') {
    //   res.send(200);
    // }
    // else {
    //   next();
    // }
  });
  // api login

  //维修列表==================================================
  //获取维修列表
  app.get('/repaire/app/getRepairedList', function(req, res){
    db.repaireModel.find({}, function(err, doc){
      if (err) {
        console.log('查询出错：' + err);
        res.json({code: 700, msg:'查询出错：' + err})
        return
      } else {
        if (!doc) {
          res.json({code: 600, msg:'没有维修记录', data: doc})
          return
        } else {
          res.json({code: 200, msg:'查询成功', data: doc})
          return
        }

      }
    })
    
  })
  //删除维修记录
  app.get('/repaire/app/deleteRepaireRecore', function(req, res){

    
  })

  //修改维修记录
  app.post('/repaire/app/changeRepaireRecord', function(req, res){

    
  })
  
  //增加维修记录
  app.post('/repaire/app/addRepaireRecord', function(req, res){

    
  })

  //联社中心==========================================
  //获取联社中心列表
  app.get('/repaire/app/getCenterList', function(req, res){

    
  })
  //删除维修记录
  app.get('/repaire/app/deleteCenterRecore', function(req, res){

  
  })

  //修改维修记录
  app.post('/repaire/app/changeCenterRecord', function(req, res){

  
  })

  //增加维修记录
  app.post('/repaire/app/addCenterRecord', function(req, res){

  
  })

  app.get('*', function(req, res){
    res.end('404')
  })

}