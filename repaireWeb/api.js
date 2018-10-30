const db = require('./db')
const bodyParser = require('body-parser');
const url = require("url");//解析url为对象
const querystring = require('querystring');//解析如‘a=1&b=2’为对象

module.exports = function (app) {
  app.use(bodyParser.json());
  app.use(bodyParser.urlencoded({extended: false}));
  app.all("*", function (req, res, next) {
    next();
  });
  // api login

  //维修列表================================================================================

  //获取维修列表 //完成
  app.get('/repair/app/getrepairList', function (req, res) {
    
    let repairBean = [];
    const param = {};
    const time = {};
    if(req.query.centerName!=undefined) param.center_name = req.query.centerName;
    if(req.query.startTime!=undefined) {
      time.$gte = req.query.startTime;
      param.time = time;
    }
    if(req.query.endTime!=undefined) {
      time.$lte = req.query.endTime;
      param.time = time;
    }
    console.log(param)
    // repair
    const getrepairBean = new Promise((resolve, reject) => {
      db.repair.find(
        param,
        {__v:0},
        function (err, doc) {
          if (err) {
            console.log('repairBean find error!')
            reject('reject repairBean')
          } else {
            if (!doc) {
              repairBean = [];
            } else {
              repairBean = doc;
            }
            resolve(repairBean)
          }
        })
    })

    const p_all = Promise.all([getrepairBean])

    p_all.then((suc) => {
      let data = {
        "repairBean": suc[0]
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
  app.get('/repair/app/deleterepairRecord', function (req, res) {

  })

  //修改维修记录--完成
  app.post('/repair/app/changerepairRecord', function (req, res) {
    console.log(req.body)
    db.repair.findByIdAndUpdate(
      req.body._id,
      req.body,
      {upsert:true},
      function(err,doc){
        if (err) {
          console.log('修改错误：' + err);
          res.json({code: 700, msg:'查询出错：' + err})
          return
        } else{
          res.json({code: 200, msg:'修改成功'})
        }
      }
    )
  })

  //增加维修记录--完成
  app.post('/repair/app/addrepairRecord', function (req, res) {
    db.repair.create(
      req.body,
      function(err,doc){
        if(err){
          console.log('添加失败' + err);
          res.json({code: 700, msg:'添加失败'})
        } else{
          console.log(doc);
          res.json({code: 200, msg:'添加成功'})
        }
      }
    )

  })

  //联社中心==========================================
  //获取联社中心列表--完成
  app.get('/repair/app/getCenterList', function (req, res) {
    let centerBean = [];

    // center
    const getCenter = new Promise((resolve, reject) => {
      db.center.find(
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
  //删除中心记录
  app.get('/repair/app/deleteCenterRecord', function (req, res) {

  })
  //增加中心记录
  app.post('/repair/app/addCenterRecord', function (req, res) {

  })

  //设备详细=====================================
  //查询设备详细————完成
  app.get('/repair/app/getDeviceList', function (req, res) {
    let deviceBean = [];

    const getDevice = new Promise((resolve, reject) => {
      db.device.find(
        {},
        function (err, doc) {
          if (err) {
            console.log('device find error!');
            reject('reject device')
          } else {
            if (!doc) {
              deviceBean = [];
            } else {
              deviceBean = doc;
            }
            resolve(deviceBean)
          }
        })
    })

    const p_all = Promise.all([getDevice])

    p_all.then((suc) => {
      let data = {
        "DeviceBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })

  })
  //增加设备详细
  app.get('/repair/app/addDevice', function (req, res) {

  })
  //删除设备详细
  app.post('/repair/app/deleteDevice', function (req, res) {

  })

  //人员管理=======================================
  //查询人员
  app.get('/repair/app/getrepairList', function (req, res) {
    
    let repairBean = [];
    const param = {};
    const time = {};
    if(req.query.centerName!=undefined) param.center_name = req.query.centerName;
    if(req.query.startTime!=undefined) {
      time.$gte = req.query.startTime;
      param.time = time;
    }
    if(req.query.endTime!=undefined) {
      time.$lte = req.query.endTime;
      param.time = time;
    }
    console.log(param)
    // repair
    const getrepairBean = new Promise((resolve, reject) => {
      db.repair.find(
        param,
        {__v:0},
        function (err, doc) {
          if (err) {
            console.log('repairBean find error!')
            reject('reject repairBean')
          } else {
            if (!doc) {
              repairBean = [];
            } else {
              repairBean = doc;
            }
            resolve(repairBean)
          }
        })
    })

    const p_all = Promise.all([getrepairBean])

    p_all.then((suc) => {
      let data = {
        "repairBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })
  })
  //增加人员
  app.get('/repair/app/addPerson', function (req, res) {

  })
  //删除人员
  app.get('/repair/app/deletePerson', function (req, res) {

  })
  //修改人员
  app.post('/repair/app/changePerson', function (req, res) {

  })

  //维修项目明细====================================
  //查询项目详细
  app.get('/repair/app/getProjectList', function (req, res) {
    let centerBean = [];

    // center
    const getCenter = new Promise((resolve, reject) => {
      db.center.find(
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
  //增加设备详细
  app.get('/repair/app/addProject', function (req, res) {

  })
  //删除设备详细
  app.post('/repair/app/deleteProject', function (req, res) {

  })

  //维修网点明细====================================
  //查询网点详细
  app.get('/repair/app/getSiteList', function (req, res) {
    let centerBean = [];

    // center
    const getCenter = new Promise((resolve, reject) => {
      db.center.find(
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
  //增加设备详细
  app.get('/repair/app/addSite', function (req, res) {

  })
  //删除设备详细
  app.post('/repair/app/deleteSite', function (req, res) {

  })

  app.get('*', function (req, res) {
    res.end('404')
  })

}