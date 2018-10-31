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

  //获取维修列表————完成
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

  //删除维修记录————完成
  app.get('/repair/app/deleterepairRecord', function (req, res) {
      console.log(req.query)
      db.repair.findByIdAndRemove(
        req.query._id,
        function(err,doc){
          if(err){
            console.log(err)
            res.json({code:700,msg:'删除失败'})
          }else{
            res.json({code:200,msg:'删除成功'})
          }
        }
      )
  })

  //修改维修记录————完成
  app.post('/repair/app/changerepairRecord', function (req, res) {
    console.log(req.body)
    db.repair.findByIdAndUpdate(
      req.body._id,
      req.body,
      {upsert:true},
      function(err,doc){
        if (err) {
          console.log('修改错误：' + err);
          res.json({code: 700, msg:'修改失败：'})
          return
        } else{
          res.json({code: 200, msg:'修改成功'})
        }
      }
    )
  })

  //增加维修记录————完成
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
        {__v:0},
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
  //删除中心记录————完成
  app.get('/repair/app/deleteCenterRecord', function (req, res) {
      db.center.findByIdAndRemove(
        req.query._id,
        function(err,doc){
          if(err){
            res.json({code:700,msg:'删除失败'})
          }else{
            res.json({code:200,msg:'删除成功'})
          }
        }
      )
  })
  //增加中心记录————完成
  app.get('/repair/app/addCenterRecord', function (req, res) {
    db.center.create(
      {center_name:req.query.center_name},
      function(err,doc){
        if(err){
          res.json({code:700,msg:'添加失败'})
        }else{
          res.json({code:200, msg:'添加成功'})
        }
      }
      )
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
  //增加设备详细————完成
  app.get('/repair/app/addDevice', function (req, res) {
    db.device.create(
      {center_name:req.query.device_name},
      function(err,doc){
        if(err){
          res.json({code:700,msg:'添加失败'})
        }else{
          res.json({code:200, msg:'添加成功'})
        }
      }
    )
  })
  //删除设备详细————完成
  app.post('/repair/app/deleteDevice', function (req, res) {
    db.decive.findByIdAndRemove(
      req.query._id,
      function(err,doc){
        if(err){
          res.json({code:700,msg:'删除失败'})
        }else{
          res.json({code:200,msg:'删除成功'})
        }
      }
    )
  })

  //人员管理=======================================
  //查询人员
  app.get('/repair/app/getPersonList', function (req, res) {
    
    let personBean = [];
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
  //增加人员————完成
  app.post('/repair/app/addPerson', function (req, res) {
    db.person.create(
      req.body,
      function(err,doc){
        if(err){
          res.json({code:700,msg:'添加失败'})
        }else{
          res.json({code:200, msg:'添加成功'})
        }
      }
      )
  })
  //删除人员————完成
  app.get('/repair/app/deletePerson', function (req, res) {
    db.person.findByIdAndRemove(
      req.query._id,
      function(err,doc){
        if(err){
          res.json({code:700,msg:'删除失败'})
        }else{
          res.json({code:200,msg:'删除成功'})
        }
      }
    )
  })
  //修改人员
  app.post('/repair/app/changePerson', function (req, res) {

  })

  //维修项目明细====================================
  //查询项目详细
  app.get('/repair/app/getProjectList', function (req, res) {
    let projectBean = [];

    // project
    const getProject = new Promise((resolve, reject) => {
      db.project.find(
        {},
        function (err, doc) {
          if (err) {
            console.log('project find error!');
            reject('reject project')
          } else {
            if (!doc) {
              projectBean = [];
            } else {
              projectBean = doc;
            }
            resolve(projectBean)
          }
        })
    })

    const p_all = Promise.all([getProject])

    p_all.then((suc) => {
      let data = {
        "ProjectBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })

  })
  //增加项目详细————完成
  app.get('/repair/app/addProject', function (req, res) {
    db.project.create(
      {center_name:req.query.project_name},
      function(err,doc){
        if(err){
          res.json({code:700,msg:'添加失败'})
        }else{
          res.json({code:200, msg:'添加成功'})
        }
      }
      )
  })
  //删除设备详细————完成
  app.post('/repair/app/deleteProject', function (req, res) {
    db.project.findByIdAndRemove(
      req.query._id,
      function(err,doc){
        if(err){
          res.json({code:700,msg:'删除失败'})
        }else{
          res.json({code:200,msg:'删除成功'})
        }
      }
    )
  })

  //维修网点明细====================================
  //查询网点详细
  app.get('/repair/app/getSiteList', function (req, res) {
    let siteBean = [];

    // site
    const getSite = new Promise((resolve, reject) => {
      db.site.find(
        {},
        function (err, doc) {
          if (err) {
            console.log('site find error!');
            reject('reject site')
          } else {
            if (!doc) {
              siteBean = [];
            } else {
              siteBean = doc;
            }
            resolve(siteBean)
          }
        })
    })

    const p_all = Promise.all([getSite])

    p_all.then((suc) => {
      let data = {
        "SiteBean": suc[0]
      }
      res.json({ code: 200, msg: '查询成功', data: data })
      return
    }).catch((err) => {
      console.log('err all:' + err)
      res.json({ code: 600, msg: '查询出错', data: data })
      return
    })

  })
  //增加网点详细————完成
  app.get('/repair/app/addSite', function (req, res) {
    db.site.create(
      {center_name:req.query.site_name},
      function(err,doc){
        if(err){
          res.json({code:700,msg:'添加失败'})
        }else{
          res.json({code:200, msg:'添加成功'})
        }
      }
      )
  })
  //删除网点详细————完成
  app.post('/repair/app/deleteSite', function (req, res) {
    db.site.findByIdAndRemove(
      req.query._id,
      function(err,doc){
        if(err){
          res.json({code:700,msg:'删除失败'})
        }else{
          res.json({code:200,msg:'删除成功'})
        }
      }
    )
  })

  app.get('*', function (req, res) {
    res.end('404')
  })

}