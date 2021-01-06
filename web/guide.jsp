<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>浏览器精确定位</title>
    <link rel="stylesheet" href="template/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="template/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="template/css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="template/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="template/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="template/img/favicon.ico">

    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <style>
        html, body, #container {
            height: 100%;
        }

        .info {

        }

        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            left: 50px;
            width: 280px;
        }

        #panel .amap-call {
            background-color: #009cf9;
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
        }

        #panel .amap-lib-driving {
            border-bottom-left-radius: 4px;
            border-bottom-right-radius: 4px;
            overflow: hidden;
        }

        .arrival {
            position: absolute;
            /*display:;*/
            bottom: 0;
            right: 0;
            z-index: 99;
            margin: 0.3rem;
        }
    </style>
<body>
<div id='container'></div>
<div id="panel">
    <%--    --%>
</div>
<div class="col-lg-6 info" id="info" style="width: 400px">
    <div class="card">
        <div class="card-close">
            <div class="dropdown">
                <button type="button" id="closeCard2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                        class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                <div aria-labelledby="closeCard2" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                          class="dropdown-item remove">
                    <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit">
                    <i class="fa fa-gear"></i>Edit</a></div>
            </div>
        </div>
        <div class="card-header d-flex align-items-center">
            <h3 class="h4">导航</h3>
        </div>
        <div class="card-body">
            <div class="form-horizontal">
                <div class="form-group row input-item">
                    <label class="col-sm-3 form-control-label">起点</label>
                    <div class="col-sm-9">
                        <input id='input_start' type="text" onchange="getStart()" placeholder="请输入起点">
                    </div>
                </div>
                <div class="form-group row input-item">
                    <label class="col-sm-3 form-control-label">终点</label>
                    <div class="col-sm-9">
                        <input id='input_end' type="text" onchange="getEnd()" placeholder="请输入终点">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-9 offset-sm-3">
                        <button onclick="Carguide()" class="btn btn-primary">导航</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div>

    <br>

    <!--    <h4 id='status'></h4>-->
    <!--    <hr>-->
    <!--    <p id='result'></p>-->
    <!--    <hr>-->
</div>
<link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
<script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
<script type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.15&key=dcada9127871dae9e3b92d182cf0d96e&plugin=AMap.Autocomplete&&plugin=AMap.Driving"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
<script src="template/vendor/jquery/jquery.min.js"></script>
<script src="template/vendor/popper.js/umd/popper.min.js"></script>
<script src="template/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="template/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="template/vendor/chart.js/Chart.min.js"></script>
<script src="template/vendor/jquery-validation/jquery.validate.min.js"></script>
<!-- Main File-->
<script src="template/js/front.js"></script>
<script type="text/javascript">
    window.onload = function () {
        $.ajax({
            type: 'post',
            //ansyv:true,
            cache: false,
            url: '<%=application.getContextPath()%>/getParkingList.do',
            success: function (data) {
                console.log(data)
                window.parking = new Array();
                data.forEach((value, index) => {
                    console.log(value)
                    window.parking.push(new Parking(value.parkingName, value.lat, value.lng, value.charges, value.spare, value.maxSize,value.parkingId))
                })
            },
            error: function () {
            }
        })
    }
    var map = new AMap.Map('container', {
        resizeEnable: true
    });
    var driving = new AMap.Driving({
        map: map,
        panel: "panel"
    });
    AMap.plugin('AMap.Geolocation', function () {
        var geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：5s
            buttonPosition: 'RB',    //定位按钮的停靠位置
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,   //定位成功后是否自动调整地图视野到定位点

        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition(function (status, result) {
            if (status == 'complete') {
                onComplete(result)
            } else {
                onError(result)
            }
        });
    });

    //解析定位结果
    function onComplete(data) {
        // document.getElementById('status').innerHTML = '定位成功'
        var str = [];
        str.push('定位结果：' + data.position);
        window.nowPos = data.position
        window.ep = window.nowPos
        console.log(data)
        str.push('定位类别：' + data.location_type);
        if (data.accuracy) {
            str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        // document.getElementById('result').innerHTML = str.join('<br>');
    }

    //解析定位错误信息
    function onError(data) {
        // document.getElementById('status').innerHTML = '定位失败'
        // document.getElementById('result').innerHTML = '失败原因排查信息:' + data.message;
    }

    var auto = new AMap.Autocomplete({
        input: "input_start"
    });
    var auto2 = new AMap.Autocomplete({
        input: "input_end"
    });

    function Location(lat, lng) {
        this.lat = lat;
        this.lng = lng;

    }

    function Parking(name, lat, lng, charge, spare, maxSize,parking_id) {
        this.name = name
        this.lat = lat
        this.lng = lng
        this.charge = charge
        this.spare = spare
        this.maxSize = maxSize
        this.parking_id = parking_id
    }

    Location.prototype = {
        constructor: Location,  //每个函数都有prototype属性，指向该函数原型对象，原型对象都有constructor属性，这是一个指向prototype属性所在函数的指针
        say: function () {
            alert(this.lat + " " + this.lng);
        }
    }
    Parking.prototype = {
        constructor: Parking,
        say: function () {
            alert(this.lat + " " + this.lng);
        }
    }
    var startP = new Location(null, null);
    var endP = new Location(null, null);
    var statrR
    var endR;
    getStart = () => {
        var input_startVal = document.getElementById("input_start").value;
        if (input_startVal !== null && input_startVal !== undefined) {
            auto.search(input_startVal, function (status, result) {
                // 搜索成功时，result即是对应的匹配数据
                if (result !== undefined && result !== null && result !== "") statrR = result

            })
        } else {
            window.ep = window.nowPos
        }
    }
    getEnd = () => {
        var input_endVal = document.getElementById("input_end").value

        if (input_endVal !== null && input_endVal !== undefined) {
            // console.log("i want to end")
            auto2.search(input_endVal, (status, result) => {
                if (result !== undefined && result !== null && result !== "") endR = result


            })
        }
    }

    changeEnd = (lng, lat,parkingId) => {
        let temp = new AMap.LngLat(lng, lat)
        driving.search(e, temp, function (status, result) {
            // var $newElement=;//创建元素,返回jQuery对象
            $("#panel").append($('<button class="arrival btn btn-primary" id="arrivalButton" >确认已经到达</button>'))
            // document.getElementById("arrivalButton").style.opacity = '1'
            // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
            console.log(parkingId)
            $.ajax({
                    type: 'post',
                    // ansyv:true,
                    cache: false,
                    data:{parking_id:parkingId},
                    url: '<%=application.getContextPath()%>/reserve.do',
                    success: function (data) {
                        console.log(data)
                        // window.parking = new Array();
                        // data.forEach((value, index) => {
                        //     console.log(value)
                        //     window.parking.push(new Parking(value.parkingName, value.lat, value.lng, value.charges, value.spare, value.maxSize))
                        // })
                    },
                    error: function () {
                    }
                })
            if (status === 'complete') {
                log.success('绘制驾车路线完成')
            } else {
                log.error('获取驾车数据失败：' + result)
            }
        })

    }
    initMarker = () => {
        // var endp = new AMap.LngLat(sp.lat,sp.lng)
        window.parking.forEach((value, index, parking) => {
            let tempp = new AMap.LngLat(value.lng, value.lat)
            var valuet = value.name+"\n 收费价格每小时:"+value.charge+"元\n停车场容量"+value.maxSize+"\n停车场空余停车位："+value.spare
            console.log(tempp)
            // let endp = new AMap.LngLat()
            let distance = Math.round(tempp.distance(s));
            // console.log(distance)
            if (distance < 5000) {
                let m1 = new AMap.Marker({
                    map: map,
                    // draggable:true,
                    position: tempp,
                    title: valuet
                });
                map.setFitView();
                // m1.on('click',changeEnd(value.lat,value.lng))
                m1.on('click', () => {
                    changeEnd(value.lng, value.lat,value.parking_id)
                })
                let line = new AMap.Polyline({
                    strokeColor: '#80d8ff',
                    isOutline: true,
                    outlineColor: 'white'
                });
                line.setMap(map);
                let text = new AMap.Text({
                    text: '',
                    style: {
                        'background-color': '#29b6f6',
                        'border-color': '#e1f5fe',
                        'font-size': '12px'
                    }
                });
                text.setMap(map)
                let textPos = s.divideBy(2).add(tempp.divideBy(2));
                // var distance = Math.round(p1.distance(p2));
                var path = [s, tempp];
                line.setPath(path);
                text.setText('两点相距' + distance + '米')
                text.setPosition(textPos)

            }

        })
    }
    Carguide = () => {

        console.log(endR.tips[0].location)
        window.sp = endR.tips[0].location
        //这里有错误 把StartP用end初始化了
        if (statrR !== undefined) {
            window.ep = statrR.tips[0].location

            console.log(statrR.tips[0].location)
        }
        if (window.sp.lat !== undefined) {
            startP.lat = sp.lat
            console.log(sp.lat);
        }

        if (window.sp.lng !== undefined) {
            startP.lng = sp.lng
            console.log(sp.lng);
        }
        if (window.ep.lat !== undefined) {
            endP.lat = ep.lat
            console.log(ep.lat);
        }

        if (window.ep.lng !== undefined) {
            endP.lng = ep.lng
            console.log(ep.lng);
        }
        window.s = new AMap.LngLat(startP.lng, startP.lat)
        window.e = new AMap.LngLat(endP.lng, endP.lat)
        driving.search(e, s, function (status, result) {
            // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
            if (status === 'complete') {
                log.success('绘制驾车路线完成')
            } else {
                log.error('获取驾车数据失败：' + result)
            }
        });
        initMarker()
        // document.getElementById("info").style.display='none'
    }

</script>

</body>
</html>
