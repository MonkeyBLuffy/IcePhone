const db = require('./db')

module.exports = function (app) {
  app.all("*", function (req, res, next) {
    next();
  });
  // api login

  //维修列表==================================================
  //获取维修列表
  app.get('/repaire/app/getRepairedList', function (req, res) {
    
    let repaireBean = [];

    const param = {};
    const time = {};
    if(req.query.centerName!='') param.center_name = req.query.centerName;
    if(req.query.startTime!='') {
      time.$gte = req.query.startTime;
      param.time = time;
    }
    if(req.query.endTime!='') {
      time.$lte = req.query.endTime;
      param.time = time;
    }


    console.log(param)
    
    // repaire
    const getRepaireBean = new Promise((resolve, reject) => {
      db.repaire_test.find(
        param,
        function (err, doc) {
          if (err) {
            console.log('repaireBean find error!')
            reject('reject repaireBean')
          } else {
            if (!doc) {
              repaireBean = [];
            } else {
              repaireBean = doc;
            }
            resolve(repaireBean)
          }
        })
    })

    const p_all = Promise.all([getRepaireBean])

    p_all.then((suc) => {
      let data = {
        "RepaireBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })
  })

  //删除维修记录
  app.get('/repaire/app/deleteRepaireRecore', function (req, res) {


  })

  //修改维修记录
  app.post('/repaire/app/changeRepaireRecord', function (req, res) {

      
  })

  //增加维修记录
  app.post('/repaire/app/addRepaireRecord', function (req, res) {


  })

  //联社中心==========================================
  //获取联社中心列表
  app.get('/repaire/app/getCenterList', function (req, res) {
    let centerBean = [];

    // center
    const getCenter = new Promise((resolve, reject) => {
      db.center_test.find(
        {},
        function (err, doc) {
          if (err) {
            console.log('center find error!');
            reject('reject center')
          } else {
            if (!doc) {
              centerBean = [];
            } else {
              centerBean = doc;
            }
            resolve(centerBean)
          }
        })
    })

    const p_all = Promise.all([getCenter])

    p_all.then((suc) => {
      let data = {
        "CenterBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })

  })
  //删除维修记录
  app.get('/repaire/app/deleteCenterRecore', function (req, res) {


  })

  //修改维修记录
  app.post('/repaire/app/changeCenterRecord', function (req, res) {


  })

  //增加维修记录
  app.post('/repaire/app/addCenterRecord', function (req, res) {


  })



  app.get('*', function (req, res) {
    res.end('404')
  })

}